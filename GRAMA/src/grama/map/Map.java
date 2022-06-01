/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Lien;
import grama.Noeud;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Steve Pennec
 */
public class Map extends JPanel{

    private static final int PADDING = 20;
    private final int width   = 700;
    private final int height  = 700;
    private static final int DIAMETER_NOEUD = 30;
    private static final int RAYON_NOEUD    = DIAMETER_NOEUD / 2;
    
    private final ArrayList<Noeud> listeNoeud = new ArrayList<>();
    private final ArrayList<Lien> listeLien   = new ArrayList<>();
    
    private final ArrayList<GraphNoeud> listeGraphNoeud = new ArrayList<>();
    private final ArrayList<GraphLien> listeGraphLien   = new ArrayList<>();
    
    Noeud noeud1 = new Noeud("V", "Villeurbanne");
    Noeud noeud2 = new Noeud("R", "MacDonald's");
    Noeud noeud3 = new Noeud("V", "Vénissieux");
    Noeud noeud4 = new Noeud("L", "Aquarium de Lyon");
    
    Lien lien1 = new Lien(5, 'D', noeud1, noeud2);
    Lien lien2 = new Lien(5, 'D', noeud2, noeud1);
    Lien lien3 = new Lien(20, 'A', noeud1, noeud3);
    Lien lien4 = new Lien(20, 'A', noeud3, noeud1);
    Lien lien5 = new Lien(15, 'N', noeud3, noeud4);
    Lien lien6 = new Lien(15, 'N', noeud4, noeud3);
    Lien lien7 = new Lien(10, 'N', noeud2, noeud3);
    Lien lien8 = new Lien(10, 'N', noeud3, noeud2);
    
   
    private final Random posX = new Random();
    private final Random posY = new Random();
    
    public Map() {
        super();
        setPreferredSize(new Dimension(750, 750));
        remplirListe();
        generateGraphNoeud();
        generateGraphLien();
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (java.awt.Graphics2D) g;

        g2d.setRenderingHint(
                java.awt.RenderingHints.KEY_ANTIALIASING,
                java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(
                java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
                java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        paintLien(g2d);
        paintNoeud(g2d);
        
        
        
    }
    
    
    private void paintLien(Graphics2D g2d){
        for (GraphLien lien : listeGraphLien){
            g2d.drawLine(lien.getPosXDeb(), lien.getPosYDeb(), lien.getPosXFin(), lien.getPosYFin());
        }
    }
    
    
    private void paintNoeud(Graphics2D g2d){
        for (GraphNoeud noeud : listeGraphNoeud){
            g2d.setColor(Color.RED);
            g2d.fillOval(noeud.posX, noeud.posY, 30, 30);
            
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawOval(noeud.posX, noeud.posY, 30, 30);
            
            g2d.setColor(Color.BLACK); 
            g2d.drawString(noeud.getNomLieu(), noeud.posX - 15, noeud.posY - 5);
        }
    }
    
    private void paintLabel(){
        
    }
    
    
    
    
    
    private void remplirListe(){
        listeNoeud.add(noeud1);
        listeNoeud.add(noeud2);
        listeNoeud.add(noeud3);
        listeNoeud.add(noeud4);
        
        listeLien.add(lien1);
        listeLien.add(lien2);
        listeLien.add(lien3);
        listeLien.add(lien4);
        listeLien.add(lien5);
        listeLien.add(lien6);
        listeLien.add(lien7);
        listeLien.add(lien8);
    }
    
    private void generateGraphNoeud(){
        int x = posX.nextInt(width);
        int y = posY.nextInt(height);
        
        
        for (Noeud noeud : listeNoeud){
            
            while (!verifCoord(x, y)){
                System.out.println("x: " + x + " et y: " + y);
                x = posX.nextInt(width);
                y = posY.nextInt(height);
            }
            
            listeGraphNoeud.add(new GraphNoeud(noeud.getTypeLieu(), noeud.getNomLieu(), x, y));
        }
    }
    
    
    private void generateGraphLien(){
        GraphNoeud noeudDepart;
        GraphNoeud noeudArrive;
        for (Lien lien : listeLien){
            noeudDepart = rechercheGraphNoeud(lien.getDepartNoeud());
            noeudArrive = rechercheGraphNoeud(lien.getArriveNoeud());
            
            listeGraphLien.add(new GraphLien(lien, noeudDepart.getPosX() + RAYON_NOEUD, noeudDepart.getPosY() + RAYON_NOEUD, 
                                                   noeudArrive.getPosX() + RAYON_NOEUD, noeudArrive.getPosY() + RAYON_NOEUD));
        }
    }
    
    
    private boolean verifCoord(int posX, int posY){
        int i = 0;
        boolean verif = true;
        
        while (verif && i < listeGraphNoeud.size()){
            GraphNoeud tempNoeud = listeGraphNoeud.get(i);
            
            verif = compareCoord(tempNoeud, posX, posY);
            
            i++;
        }
        
        return verif;
    }
    
    
    
    public boolean compareCoord(GraphNoeud noeud, int otherPosX, int otherPosY){
        return (   (noeud.posX + PADDING <= otherPosX 
                ||  noeud.posX - PADDING >= otherPosX )
                && 
                   (noeud.posY + PADDING <= otherPosY
                ||  noeud.posY - PADDING >= otherPosY ));
    }
    
    
    public GraphNoeud rechercheGraphNoeud(Noeud noeudRecherche){
        int i = 0;
        boolean trouve = false;
        GraphNoeud noeud = null;
        
        while (!trouve && i < listeGraphNoeud.size()){
            GraphNoeud tempNoeud = listeGraphNoeud.get(i);
            if (tempNoeud.getNomLieu().equals(noeudRecherche.getNomLieu())){
                noeud = tempNoeud;
                trouve = true;
            }
            i++;
        }
        
        return noeud;
    }
    
    
    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        
        public void mousePressed(MouseEvent me){
        
        }
        
        public void mouseDragged(MouseEvent me){
            
        }
        
        public void mouseReleased(MouseEvent me){
            
        }
    }
}
