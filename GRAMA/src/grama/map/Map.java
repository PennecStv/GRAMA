/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Lien;
import grama.Noeud;
import grama.Graph;
import java.awt.BasicStroke;
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
 * Cette  classe correspond au panel représentant la carte qui contiendra et qui dessinera le graphe
 * @author Steve Pennec
 */
public class Map extends JPanel{

    /**
     * Correspond à la marge sur les bords du panel
     */
    private static final int PADDING    = 15;
    
    /**
     * Correspond à l'espacement minimal qu'il doit y avoir entre les noeuds
     */
    private static final int ESPACEMENT = 45;
    
    /**
     * La largeur de la map
     */
    private final int WIDTH_MAP         = 1000;
    
    /**
     * La hauteur de la map
     */
    private final int HEIGHT_MAP        = 740;
    
    /**
     * La dimension de la map
     */
    private final Dimension dimension;
    
    /**
     * Diamètre des noeuds
     */
    private static final int DIAMETER_NOEUD = 30;
    
    /**
     * Rayon des noeuds
     */
    private static final int RAYON_NOEUD    = DIAMETER_NOEUD / 2;
    
    /**
     * Pour savoir si un noeud est cliqué
     */
    boolean isNodeClicked = false;
    
    /**
     * Pour savoir si un lien est cliqué
     */
    boolean isLinkClicked = false;
    
    
    /**
     * Liste de String contenant les types de noeuds qu'on a sélectionné dans l'interface graphique
     */
    private static final ArrayList<String> listeSelectedTypeNoeud = new ArrayList<>();
    
    /**
     * Liste de String contenant les types de liens qu'on a sélectionné dans l'interface graphique
     */
    private static final ArrayList<String> listeSelectedTypeLien = new ArrayList<>();
    
    /**
     * mouseListener pour gérer les Click and Drag
     */
    private java.awt.event.MouseAdapter mouseListener;
    

    //private MapDesigner designerListener;
    
    
//    private ArrayList<Noeud> listeNoeud = new ArrayList<>();
//    private ArrayList<Lien> listeLien   = new ArrayList<>();
    
    /**
     * Liste des noeuds à dessiner
     */
    private ArrayList<GraphNoeud> listeGraphNoeud  = new ArrayList<>();
    
    /**
     * Liste des liens à dessiner
     */
    private ArrayList<GraphLien> listeGraphLien    = new ArrayList<>();
    
    /***  Noeuds et Liens de Test ***/
    Noeud noeud1 = new Noeud("V", "Villeurbanne");
    Noeud noeud2 = new Noeud("R", "MacDonald's");
    Noeud noeud3 = new Noeud("V", "Vénissieux");
    Noeud noeud4 = new Noeud("L", "Aquarium de Lyon");
    
    Lien lien1 = new Lien( 5, 'D', noeud1, noeud2);
    Lien lien2 = new Lien( 5, 'D', noeud2, noeud1);
    Lien lien3 = new Lien(20, 'A', noeud1, noeud3);
    Lien lien4 = new Lien(20, 'A', noeud3, noeud1);
    Lien lien5 = new Lien(15, 'N', noeud3, noeud4);
    Lien lien6 = new Lien(15, 'N', noeud4, noeud3);
    Lien lien7 = new Lien(10, 'N', noeud2, noeud3);
    Lien lien8 = new Lien(10, 'N', noeud3, noeud2);
    
   /**
    * Une coordonnée x aléatoire
    */
    private final Random posX = new Random();
    
    /**
     * Une coordonnée y aléatoire
     */
    private final Random posY = new Random();
    
    
    
    
    /* ====    Constructeur    ==== */
    /**
     * Crée le panel Map de dessin
     */
    public Map() {
        super();
        this.dimension = new Dimension(WIDTH_MAP, HEIGHT_MAP);
        super.setSize(this.dimension);
        super.setPreferredSize(this.dimension);
        super.setMinimumSize(this.dimension);
        super.setMaximumSize(this.dimension);
        
        MouseHandler mh = new MouseHandler();
        addMouseListener(mh);
        addMouseMotionListener(mh);
    }
    
    
    

    /* ============================= */
    /* ====  Méthodes de bases  ==== */
    /* ============================= */
    /**
     * Ajoute un type de noeud à la liste de tpye de noeuds sélectionnés{@link #listeSelectedTypeNoeud}
     * @param type 
     */
    public void addTypeNoeud(String type) {
        Map.listeSelectedTypeNoeud.add(type);
    }
    
    /**
     * Retire un type de noeud à la liste de type de noeuds sélectionnés
     * @param type 
     */
    public void removeTypeNoeud(String type){
        Map.listeSelectedTypeNoeud.remove(type);
    }
    
    /**
     * Ajoute un type de lien à la liste de type de liens sélectionnés{@link #listeSelectedTypeLien}
     * @param type 
     */
    public void addTypeLien(String type) {
        Map.listeSelectedTypeLien.add(type);
    }
    
    /**
     * Retire un type de liens à la liste de type de noeuds sélectionnés
     * @param type 
     */
    public void removeTypeLien(String type){
        Map.listeSelectedTypeLien.remove(type);
    }
    
    /**
     * Renvoie le noeud sélectionné dans la map
     * @return un noeud s'il y en a un qui est sélectionné, sinon null
     */
    public GraphNoeud getSelectedNode(){
        for (GraphNoeud noeud : listeGraphNoeud){
            if (noeud.isSelected())
                return noeud;
        }
        return null;
    }
    
    /**
     * Renvoie le lien sélectionné dans la map
     * @return un lien s'il y en a un qui est sélectionné, sinon null
     */
    public GraphLien getSelectedLink(){
        for (GraphLien lien : listeGraphLien){
            if (lien.isSelected())
                return lien;
        }
        return null;
    }
    
    /**
     * Paint tous les éléments du graphe dans la map
     * @param g étant un graphique
     */
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (java.awt.Graphics2D) g;

        g2d.setRenderingHint(
                java.awt.RenderingHints.KEY_ANTIALIASING,
                java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(
                java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
                java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        if (listeSelectedTypeNoeud.isEmpty() && listeSelectedTypeLien.isEmpty()){
            paintAllLiens(g2d);
            paintAllNoeuds(g2d);
        } else {
            paintLiensTypee(g2d);
            paintNoeudsTypee(g2d);
        }
    }
    
    
    /* ============================================= */
    /* ====    Méthodes de dessins du Graphe    ==== */
    /* ============================================= */
    /**
     * Rénitialise les données (noeuds et liens) du graphe
     */
    public final void reset(){
        this.listeGraphNoeud  = new ArrayList<>();
        this.listeGraphLien   = new ArrayList<>();
    }
    
    /**
     * Permet de dessiner tous les liens du graphe dans la map
     * @param g2d 
     */
    private void paintAllLiens(Graphics2D g2d){
        for (GraphLien lien : listeGraphLien){
            paintLien(g2d, lien);
        }
    }
    
    /**
     * Permet de dessiner uniquement les liens dans le type a été sélectionné
     * @param g2d
     */
    private void paintLiensTypee(Graphics2D g2d){
        for (GraphLien lien : listeGraphLien){
            GraphNoeud noeudDep = rechercheGraphNoeud(lien.getLien().getDepartNoeud());
            GraphNoeud noeudArr = rechercheGraphNoeud(lien.getLien().getArriveNoeud());
            if (listeSelectedTypeLien.contains(String.valueOf(lien.getLien().getTypeRoute())) && !listeSelectedTypeNoeud.isEmpty()){

                if (listeSelectedTypeNoeud.contains(noeudDep.getTypeLieu()) && listeSelectedTypeNoeud.contains(noeudArr.getTypeLieu())){
                    paintNoeud(g2d, noeudDep);
                    paintNoeud(g2d, noeudArr);
                    paintLien(g2d, lien);
                }
            } else if (listeSelectedTypeLien.contains(String.valueOf(lien.getLien().getTypeRoute())) && listeSelectedTypeNoeud.isEmpty()){
                paintNoeud(g2d, noeudDep);
                paintNoeud(g2d, noeudArr);
                paintLien(g2d, lien);
            }
        }
    }
    
    /**
     * Permet de dessiner uniquement le lien entré en paramètre
     * @param g2d
     * @param lien étant un lien à dessiner dont on connait les coordonnées du noeud de départ et celui d'arrivée
     */
    private void paintLien(Graphics2D g2d, GraphLien lien){
        GraphNoeud noeudDep = rechercheGraphNoeud(lien.getLien().getDepartNoeud());
        GraphNoeud noeudArr = rechercheGraphNoeud(lien.getLien().getArriveNoeud());
        
        GradientPaint gradient = new GradientPaint(lien.getPosXDeb(), lien.getPosYDeb(), noeudDep.couleur, 
                                                        lien.getPosXFin(), lien.getPosYFin(), noeudArr.couleur);
        g2d.setPaint(gradient);

        g2d.drawLine(lien.getPosXDeb(), lien.getPosYDeb(), lien.getPosXFin(), lien.getPosYFin());
        paintLabel(g2d, lien, noeudDep, noeudArr);
    }
    
    /**
     * Permet de dessiner tous les noeuds
     * @param g2d 
     */
    private void paintAllNoeuds(Graphics2D g2d){
        for (GraphNoeud noeud : listeGraphNoeud){
            paintNoeud(g2d, noeud);
        }
    }
    
    /**
     * Permet de dessiner uniquement les noeuds dont le type a été sélectionné
     * @param g2d 
     */
    private void paintNoeudsTypee(Graphics2D g2d){
        for (GraphNoeud noeud : listeGraphNoeud){
            
            if (listeSelectedTypeNoeud.contains(noeud.getTypeLieu())){
                paintNoeud(g2d, noeud);
            }
        }
    }
    
    /**
     * Permet de dessiner uniquement le noeud passé en paramètre
     * @param g2d
     * @param noeud étant un noeud à dessiner dont les coordonnées ont été initialisées
     */
    private void paintNoeud(Graphics2D g2d, GraphNoeud noeud){
        g2d.setColor(noeud.getCouleur());
        g2d.fillOval(noeud.getPosX(), noeud.getPosY(), 30, 30);

        
        if (noeud.isSelected()){
            g2d.setColor(Color.BLUE);
            g2d.setStroke(new BasicStroke(2.0f));
        }else{
            g2d.setColor(Color.DARK_GRAY);
            g2d.setStroke(new BasicStroke(1.0f));
        }
        
        g2d.drawOval(noeud.getPosX(), noeud.getPosY(), 30, 30);

        g2d.setColor(Color.BLACK); 

        java.awt.FontMetrics metrics = g2d.getFontMetrics(new java.awt.Font("Copperplate", java.awt.Font.BOLD, 12));
        int w = metrics.stringWidth(noeud.getNomLieu());
        int h = metrics.getHeight();
        g2d.setFont(new Font("Copperplate", Font.BOLD, 12));
        g2d.drawString(noeud.getNomLieu(), noeud.getPosX() + RAYON_NOEUD - w/2, noeud.getPosY() - h/2);

        w = metrics.stringWidth(noeud.getTypeLieu());
        g2d.drawString(noeud.getTypeLieu(), noeud.getPosX() + RAYON_NOEUD - w/2, 
                                               noeud.getPosY() + RAYON_NOEUD + h/4);
    }
    
    /**
     * Permet de dessiner le texte qui affiche le type et la pondération d'un lien
     * @param g2d
     * @param lien étant le lien concerné
     * @param noeudDep étant le noeud de départ pour connaître sa couleur
     * @param noeudArr  étant le noeud d'arrivée pour connaître sa couleur
     */
    private void paintLabel(Graphics2D g2d, GraphLien lien, GraphNoeud noeudDep, GraphNoeud noeudArr){
        String label = lien.getDonnees();
        
        java.awt.FontMetrics metrics = g2d.getFontMetrics(new java.awt.Font("Copperplate", java.awt.Font.BOLD, 12));
        int w = metrics.stringWidth(label);
        int h = metrics.getHeight();
        
        
        int labelX = (lien.getPosXDeb() + lien.getPosXFin())/2;
        int labelY = (lien.getPosYDeb() + lien.getPosYFin())/2;
        
        GradientPaint gradient = new GradientPaint(labelX, labelY + h/2, noeudDep.couleur, 
                                                        labelX + w/2, labelY + h/2, noeudArr.couleur);
        g2d.setPaint(gradient);
            
        g2d.fillRoundRect(labelX - w/2, labelY - h/2, w + 5, h + 5, 15, 15);
        
        if (lien.isSelected()){
            g2d.setColor(Color.BLUE);
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.drawRoundRect(labelX - w/2, labelY - h/2, w + 5, h + 5, 15, 15);
        }
        
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(1.0f));
        g2d.setFont(new Font("Copperplate", Font.BOLD, 12));
        g2d.drawString(label, labelX - w/2 + 2, labelY + h/2 - 2);
    }
       
    
    /* ======================================================= */
    /* ===== Méthodes de test: remplir une liste de test ===== */
    /* ======================================================= */
    @Deprecated
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
//        
//        listeNoeud = graphe.getListeNoeud();
//        listeLien = graphe.getListeLien();
    }
    
    
    
    /* =============================================== */
    /* ==== Méthodes de génération de coordonnées ==== */
    /* =============================================== */
    
    /**
     * Génère la liste des noeuds à dessiner avec leurs coordonnées selon le graphe à exploiter
     * @param noeuds étant la liste des noeuds dont les coordonnées doivent être générées
     */
    public void generateGraphNoeud(List<Noeud> noeuds){
        List<Noeud> listeNoeud = new ArrayList<>(noeuds);
        
        int x = posX.nextInt(WIDTH_MAP - PADDING) + PADDING;
        int y = posY.nextInt(HEIGHT_MAP - PADDING) + PADDING;
        
        for (Noeud noeud : listeNoeud){
            
            while (!verifCoord(x, y)){
                x = posX.nextInt(WIDTH_MAP - PADDING) + PADDING;
                y = posY.nextInt(HEIGHT_MAP - PADDING) + PADDING;
            }
            
            listeGraphNoeud.add(new GraphNoeud(noeud, x, y));
        }
    }
    
    /**
     * Génère la liste des liens à dessiner avec leurs coordonnées selon le graphe à exploiter
     * @param liens étant la liste des liens dont les coordonnées doivent être générées selon ceux du noeud de départ et celui d'arrivée
     */
    public void generateGraphLien(List<Lien> liens){
        List<Lien> listeLien = new ArrayList<>(liens);
        boolean dejaDessine;
        
        GraphNoeud noeudDepart;
        GraphNoeud noeudArrive;
        for (Lien lien : listeLien){
            dejaDessine = false;
            
            noeudDepart = rechercheGraphNoeud(lien.getDepartNoeud());
            noeudArrive = rechercheGraphNoeud(lien.getArriveNoeud());
            
            for (GraphLien graphlien : listeGraphLien){
                if ((graphlien.getNoeudArrivee().getNomLieu()).equals(noeudDepart.getNomLieu()) &&
                    (graphlien.getNoeudDepart().getNomLieu()).equals(noeudArrive.getNomLieu())){
                    dejaDessine = true;
                }
            }
            
            if (!dejaDessine){
                    listeGraphLien.add(new GraphLien(lien, noeudDepart.getPosX() + RAYON_NOEUD, noeudDepart.getPosY() + RAYON_NOEUD, 
                                                   noeudArrive.getPosX() + RAYON_NOEUD, noeudArrive.getPosY() + RAYON_NOEUD));
            }
        }
    }
    
    /**
     * Permet de vérifier si les coordonnées entrées en paramètre sont valides
     * @param posX étant la coordonnée x
     * @param posY étant la coordonnée y
     * @return un boolean de confirmation
     */
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
    
    
    /**
     * Permet de comparer les coordonnées d'un noeud et celles entrées en paramètre pour voir si elles sont assez éloignées
     * @param noeud étant le noeud de référence
     * @param otherPosX étant la coordonnée x à comparer par rapport celle du noeud
     * @param otherPosY étant la coordonnée y à comparer par rapport à celle du noeud
     * @return 
     */
    public boolean compareCoord(GraphNoeud noeud, int otherPosX, int otherPosY){
        return (   (noeud.getPosX() + ESPACEMENT <= otherPosX 
                ||  noeud.getPosX() - ESPACEMENT >= otherPosX)
                || 
                   (noeud.getPosY() + ESPACEMENT <= otherPosY
                ||  noeud.getPosY() - ESPACEMENT >= otherPosY ));
    }
    
    
    
    /* ============================================== */
    /* =======     Autres méthodes utiles     ======= */
    /* ============================================== */
    /**
     * Permet de retrouver un noeud du graphe dans la liste des noeuds à dessiner
     * @param noeudRecherche étant le noeud à rechercher
     * @return le noeud à dessiner correspondant au noeud du graphe entré en paramètre
     */
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
    
    /**
     * Désélectionne tous les noeuds
     */
    public void unselectAllNodes(){
        for (GraphNoeud noeud : listeGraphNoeud){
            noeud.setSelected(false);
        }
    }
    
    /**
     * Désélectionne tous les liens
     */
    public void unselectAllLinks(){
        for (GraphLien lien : listeGraphLien){
            lien.setSelected(false);
        }
    }
    
    
    
    
    /* ============================================== */
    /* =======       Adapter & Listener       ======= */
    /* ============================================== */
    
    /**
     * Cette classe permet de gérer les actions effectuées par l'utilisateur via la souris
     */
    private class MouseHandler extends MouseAdapter implements MouseMotionListener {

        /**
         * Correspond à la réaction de la map lorsque la souris est cliquée, permettant ainsi de sélectionner un noeud ou un lien
         * @param me 
         */
        @Override
        public void mousePressed(MouseEvent me){
            GraphNoeud node;
            int i = 0;
            
            while (!isNodeClicked && i < listeGraphNoeud.size()){
                node = listeGraphNoeud.get(i);
                
                isNodeClicked = (me.getX() > node.getPosX() && me.getX() < node.getPosX() + DIAMETER_NOEUD &&
                             me.getY() > node.getPosY() && me.getY() < node.getPosY() + DIAMETER_NOEUD);
                
                if (isNodeClicked){
                    unselectAllNodes();
                    node.setSelected(true);
                }
                
                i++;
            }
            
            GraphLien link;

            i = 0;
            while (!isLinkClicked && i < listeGraphLien.size()){
                link = listeGraphLien.get(i);
                
                java.awt.FontMetrics metrics = getFontMetrics(new java.awt.Font("Copperplate", java.awt.Font.BOLD, 12));
                int w = metrics.stringWidth(link.getDonnees());
                int h = metrics.getHeight();
                
                int labelX = (link.getPosXDeb() + link.getPosXFin())/2 - w/2;
                int labelY = (link.getPosYDeb() + link.getPosYFin())/2 - h/2;
                
                isLinkClicked = (me.getX() >= labelX && me.getY() >= labelY &&
                             me.getX() <= labelX + w + 5 && me.getY() <= labelY + h + 5);
                
                if (isLinkClicked){
                    unselectAllLinks();
                    link.setSelected(true);
                }
                
                i++;
            }
            
            getParent().repaint(); 
        }
        
        
        /**
         * Correspond à la réaction de la map lorsque la souris est cliquée et maintenue, permettant ici de pouvoir déplacer un noeud
         * @param me 
         */
        @Override
        public void mouseDragged(MouseEvent me) {
            super.mouseDragged(me);
            
            GraphNoeud node = null;
            
            for (GraphNoeud nodes : listeGraphNoeud){
                if (nodes.isSelected())
                    node = nodes;
            }
            
            if (isNodeClicked && node != null){
                int NewX = me.getX();
                int newY = me.getY();
                node.setPosX(NewX - RAYON_NOEUD);
                node.setPosY(newY - RAYON_NOEUD);
                
                for (GraphLien link : listeGraphLien){
                    if (link.getNoeudDepart().getNomLieu().equals(node.getNomLieu())){
                        link.setPosXDeb(NewX);
                        link.setPosYDeb(newY);
                    }
                    
                    if (link.getNoeudArrivee().getNomLieu().equals(node.getNomLieu())){
                        link.setPosXFin(NewX);
                        link.setPosYFin(newY);
                    }
                }
                
                getParent().repaint();
            }
        }

        
        /**
         * Correspond à la réaction de la map lorsque le clique de la souris est relachée après avoir été maintenue
         * @param me 
         */
        @Override
        public void mouseReleased(MouseEvent me) {
            super.mouseReleased(me);
            isNodeClicked = false;
            isLinkClicked = false;
        }  
    }
}
