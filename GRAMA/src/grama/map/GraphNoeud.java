/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Lien;
import grama.Noeud;
import java.awt.Color;

/**
 * Cette classe représente les noeuds qui seront à dessiner sur les graphes, liés intrinsèquement à la classe Noeud {@link #noeud} du graphe.
 * @author Steve Pennec
 */
public class GraphNoeud{
    
    /**
     * Si le noeud est sélectionné dans le graphe
     */
    private boolean isSelected;
    
    /**
     * Le lien lié au noeud à dessiner
     */
    public Noeud noeud;
    
    /**
     * La coordonnée x du noeud à dessiner
     */
    private int posX;
    
    /**
     * La coordonnée y du noeud à dessiner
     */
    private int posY;
    
    /**
     * La couleur du noeud à dessiner selon son type
     */
    public Color couleur;

    
    
    /*** Constructeur ***/
    /**
     * Constructeur
     * @param noeud un noeud du graphe qu'il faudra dessiner sur l'interface graphique
     * @param posX une position x du noeud
     * @param posY une position y du noeud
     */
    public GraphNoeud( Noeud noeud, int posX, int posY) {
        this.noeud = noeud;
        this.posX = posX;
        this.posY = posY;
        this.isSelected = false;
        
        switch(noeud.getTypeLieu()){
            case "V":
                couleur = Color.RED;
                break;
                    
            case "R":
                couleur = Color.GREEN;
                break;
                    
            case "L":
                couleur = Color.YELLOW;
                break;
                    
            default:
                break;
        }
    }

    /* ============================== */
    /* ===   Getters et Setters   === */
    /* ============================== */
    
    /**
     * Renvoie la position x du noeud à dessiner
     * @return retourne la position y
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Renvoie la position y du noeud à dessiner
     * @return retourne la position y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Renvoie la couleur du noeud
     * @return retourne la couleur du noeud
     */
    public Color getCouleur() {
        return couleur;
    }
    
    /**
     * Renvoie le nom du noeud à dessiner
     * @return le nom du noeud à dessiner
     */
    public String getNomLieu(){
        return noeud.getNomLieu();
    }
    
    /**
     * Renvoie le type du noeud à dessiner
     * @return 
     */
    public String getTypeLieu(){
        return noeud.getTypeLieu();
    }
    
    /**
     * Modifie la position x du noeud à dessiner
     * @param posX une position x
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Modifie la position y du noeud à dessiner
     * @param posY une position y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Permet de savoir si le noeud est sélectionné
     * @return un boolean si le noeud est sélectionné
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * Modifie la sélection du noeud
     * @param isSelected un boolean pour modifier la sélection du noeud
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }  

    
    //Autre méthode
    /**
     * Permet d'afficher tous les voisins de ce noeud à dessiner
     * @param type un type de voisins à dessiner
     * @return un String reprenant la liste des voisins du noeud
     */
    public String afficherVoisins(String type){
        String text = "";
        
        for (Lien lien: this.noeud.getListeLien()){
            Noeud noeud = lien.getArriveNoeud();
            if (type.equals("")){
                text += noeud.getTypeLieu() + ": " + noeud.getNomLieu() + "\n";
            }else{
                if (noeud.getTypeLieu().equals(type)){
                text += noeud.getTypeLieu() + ": " + noeud.getNomLieu() + "\n";
                }
            }
        }
        return text;
    }
    
    
    /**
     * Avoir le noeud à dessiner sous format String en donnant son type et son nom
     * @return une chaîne de caractère String reprenant les données du lien
     */
    @Override
    public String toString() {
        return this.getTypeLieu() + ": " + this.getNomLieu();
    }
    
    
}
