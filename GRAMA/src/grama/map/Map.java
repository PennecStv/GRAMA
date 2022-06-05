/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Lien;
import grama.Noeud;
import grama.Graph;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Steve Pennec
 */
public class Map extends JPanel{

    private static final int PADDING    = 15;
    private static final int ESPACEMENT = 45;
    private final int WIDTH_MAP         = 1000;
    private final int HEIGHT_MAP        = 740;
    private final Dimension dimension;
    private static final int DIAMETER_NOEUD = 30;
    private static final int RAYON_NOEUD    = DIAMETER_NOEUD / 2;
    boolean isClicked = false;
    
//    private ArrayList<Noeud> listeNoeud = new ArrayList<>();
//    private ArrayList<Lien> listeLien   = new ArrayList<>();
    
    private final ArrayList<GraphNoeud> listeGraphNoeud = new ArrayList<>();
    private final ArrayList<GraphLien> listeGraphLien   = new ArrayList<>();
    
    /***  Noeuds & Liens de Test ***/
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
        this.dimension = new Dimension(WIDTH_MAP, HEIGHT_MAP);
        super.setSize(this.dimension);
        super.setPreferredSize(this.dimension);
        super.setMinimumSize(this.dimension);
        super.setMaximumSize(this.dimension);
        
//        MouseHandler mh = new MouseHandler();
//        addMouseListener(mh);
//        addMouseMotionListener(mh);
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
            GraphNoeud noeudDep = rechercheGraphNoeud(lien.getLien().getDepartNoeud());
            GraphNoeud noeudArr = rechercheGraphNoeud(lien.getLien().getArriveNoeud());
            
            GradientPaint gradient = new GradientPaint(lien.getPosXDeb(), lien.getPosYDeb(), noeudDep.couleur, 
                                                        lien.getPosXFin(), lien.getPosYFin(), noeudArr.couleur);
            g2d.setPaint(gradient);
            
            g2d.drawLine(lien.getPosXDeb(), lien.getPosYDeb(), lien.getPosXFin(), lien.getPosYFin());
        }
    }
    
    
    private void paintNoeud(Graphics2D g2d){
        for (GraphNoeud noeud : listeGraphNoeud){
            
            g2d.setColor(noeud.getCouleur());
            g2d.fillOval(noeud.posX, noeud.posY, 30, 30);
            
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawOval(noeud.posX, noeud.posY, 30, 30);
            
            g2d.setColor(Color.BLACK); 
            
            java.awt.FontMetrics metrics = g2d.getFontMetrics(new java.awt.Font("Copperplate", java.awt.Font.BOLD, 12));
            int w = metrics.stringWidth(noeud.getNomLieu());
            int h = metrics.getHeight();
            g2d.setFont(new Font("Copperplate", Font.BOLD, 12));
            g2d.drawString(noeud.getNomLieu(), noeud.posX + RAYON_NOEUD - w/2, noeud.posY - h/2);
            
            w = metrics.stringWidth(noeud.getTypeLieu());
            g2d.drawString(noeud.getTypeLieu(), noeud.posX + RAYON_NOEUD - w/2, 
                                                   noeud.posY + RAYON_NOEUD + h/4);
        }
    }
    
    
    private void paintNoeud(Graphics2D g2d, String typeLieu){
        for (GraphNoeud noeud : listeGraphNoeud){
            
            if (noeud.getTypeLieu().equals(typeLieu)){
                g2d.setColor(noeud.getCouleur());
                g2d.fillOval(noeud.posX, noeud.posY, 30, 30);

                g2d.setColor(Color.DARK_GRAY);
                g2d.drawOval(noeud.posX, noeud.posY, 30, 30);

                g2d.setColor(Color.BLACK); 

                java.awt.FontMetrics metrics = g2d.getFontMetrics(new java.awt.Font("Copperplate", java.awt.Font.BOLD, 12));
                int w = metrics.stringWidth(noeud.getNomLieu());
                int h = metrics.getHeight();
                g2d.setFont(new Font("Copperplate", Font.BOLD, 12));
                g2d.drawString(noeud.getNomLieu(), noeud.posX + RAYON_NOEUD - w/2, noeud.posY - h/2);

                w = metrics.stringWidth(noeud.getTypeLieu());
                g2d.drawString(noeud.getTypeLieu(), noeud.posX + RAYON_NOEUD - w/2, 
                                                       noeud.posY + RAYON_NOEUD + h/4);
            }
        }
    }
    
    
    private void paintLabel(){
        
    }
    
    
    
    
    
    private void remplirListe(Graph graphe){
//        listeNoeud.add(noeud1);
//        listeNoeud.add(noeud2);
//        listeNoeud.add(noeud3);
//        listeNoeud.add(noeud4);
//        
//        listeLien.add(lien1);
//        listeLien.add(lien2);
//        listeLien.add(lien3);
//        listeLien.add(lien4);
//        listeLien.add(lien5);
//        listeLien.add(lien6);
//        listeLien.add(lien7);
//        listeLien.add(lien8);
        
        //listeNoeud = graphe.getListeNoeud();
        //listeLien = graphe.getListeLien();
    }
    
    public void generateGraphNoeud(List<Noeud> noeuds){
        List<Noeud> listeNoeud = new ArrayList<>(noeuds);
        
        int x = posX.nextInt(WIDTH_MAP - PADDING) + PADDING;
        int y = posY.nextInt(HEIGHT_MAP - PADDING) + PADDING;
        
        for (Noeud noeud : listeNoeud){
            
            while (!verifCoord(x, y)){
                System.out.println("x: " + x + " et y: " + y);
                x = posX.nextInt(WIDTH_MAP - PADDING) + PADDING;
                y = posY.nextInt(HEIGHT_MAP - PADDING) + PADDING;
            }
            
            listeGraphNoeud.add(new GraphNoeud(noeud.getTypeLieu(), noeud.getNomLieu(), x, y));
        }
    }
    
    
    public void generateGraphLien(List<Lien> liens){
        List<Lien> listeLien = new ArrayList<>(liens);
        
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
        return (   (noeud.posX + ESPACEMENT <= otherPosX 
                ||  noeud.posX - ESPACEMENT >= otherPosX)
                || 
                   (noeud.posY + ESPACEMENT <= otherPosY
                ||  noeud.posY - ESPACEMENT >= otherPosY ));
    }
    
    
    public GraphNoeud rechercheGraphNoeud(Noeud noeudRecherche){
        int i = 0;
        boolean trouve = false;
        GraphNoeud noeud = null;
        
        while (!trouve && i < listeGraphNoeud.size()){
            GraphNoeud tempNoeud = listeGraphNoeud.get(i);
            if (tempNoeud.getNomLieu().toLowerCase().equals(noeudRecherche.getNomLieu().toLowerCase())){
                noeud = tempNoeud;
                trouve = true;
            }
            i++;
        }
        
        return noeud;
    }
    
    
    
    
    
    private class MouseHandler extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent me){
            GraphNoeud node = listeGraphNoeud.get(0);
//            for (GraphNoeud noeud: listeGraphNoeud){
//                if (me.getX() > noeud.getPosX() && me.getX() < noeud.getPosX() + DIAMETER_NOEUD &&
//                    me.getY() > noeud.getPosY() && me.getX() < noeud.getPosY() + DIAMETER_NOEUD){
            isClicked = (me.getX() > node.getPosX() && me.getX() < node.getPosX() + DIAMETER_NOEUD &&
                me.getY() > node.getPosY() && me.getX() < node.getPosY() + DIAMETER_NOEUD);
            
            if (isClicked)
                System.out.println("C'est clické !");
        }
        
        @Override
        public void mouseDragged(MouseEvent me) {
            super.mouseDragged(me);
            GraphNoeud node = listeGraphNoeud.get(0);
            if (isClicked){
                System.out.println("Less goo");
                int NewX = me.getX();
                int newY = me.getY();
                node.setPosX(NewX);
                node.setPosY(newY);
                
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            super.mouseReleased(me);
            System.out.println("C'est pas Less goo");
            isClicked = false;
        }  
    }
}
