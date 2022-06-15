/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Lien;
import grama.Noeud;

/**
 * Cette classe représente les liens qui seront à dessiner sur les graphes, liés intrinséquement à la classe Lien {@link #lien} du graphe.
 * @author Steve Pennec
 */
public class GraphLien{
    
    /**
     * Le lien lié à ce lien à dessiner
     */
    private Lien lien;
    
    
    /**
     * Position x du début du lien
     */
    private int posXDeb;
    
    /**
     * Position y du début du lien
     */
    private int posYDeb;
    
    /**
     * Position x de la fin du lien
     */
    private int posXFin;
    
    /**
     * Position y de la fin du lien
     */
    private int posYFin;
    
    /**
     * Si ce lien est sélectionné
     */
    private boolean isSelected;

    
    
    /*** Constructeur ***/
    /**
     * Constructeur du lien à dessiner sur le graphe
     * @param lien le lien correspond à ce dessin
     * @param posXDeb une position x de début
     * @param posYDeb une position y de début
     * @param posXFin une position x de fin
     * @param posYFin une position y de fin
     */
    public GraphLien(Lien lien, int posXDeb, int posYDeb, int posXFin, int posYFin) {
        this.lien = lien;
        this.posXDeb = posXDeb;
        this.posYDeb = posYDeb;
        this.posXFin = posXFin;
        this.posYFin = posYFin;
    }

    
    /* ============================== */
    /* ===   Getters et Setters   === */
    /* ============================== */
    /**
     * Renvoie le lien correspondant au lien à dessiner
     * @return un lien
     */
    public Lien getLien() {
        return lien;
    }

    /**
     * Renvoie la position x du début du lien à dessiner
     * @return retourne une position x
     */
    public int getPosXDeb() {
        return posXDeb;
    }

    /**
     * Renvoie la position y du début du lien à dessiner
     * @return retourne une position y
     */
    public int getPosYDeb() {
        return posYDeb;
    }

    /**
     * Renvoie la position x de la fin du lien à dessiner
     * @return retourne une position x
     */
    public int getPosXFin() {
        return posXFin;
    }

    /**
     * Renvoie la position y de la fin du lien à dessiner
     * @return retourne une position y
     */
    public int getPosYFin() {
        return posYFin;
    }

    /**
     * Renvoie le noeud de départ du lien à dessiner
     * @return retourne un lien
     */
    public Noeud getNoeudDepart() {
        return this.getLien().getDepartNoeud();
    }
    
    /**
     * Renvoie le noeud d'arrivée du lien à dessiner
     * @return retourne un lien
     */
    public Noeud getNoeudArrivee() {
        return this.getLien().getArriveNoeud();
    }
    
    /**
     * Renvoie les données du lien à dessiner, c'est-à-dire son type et sa pondération
     * @return retourne un type de lien et une valeur de kilométrage
     */
    public String getDonnees(){
        return this.lien.getTypeRoute() + ", " + this.lien.getPonderation();
    }
    
    
    
    
    /**
     * Modifie la position x du début du lien
     * @param posXDeb une position x
     */
    public void setPosXDeb(int posXDeb) {
        this.posXDeb = posXDeb;
    }

    /**
     * Modifie la position y du début du lien
     * @param posYDeb une position y
     */
    public void setPosYDeb(int posYDeb) {
        this.posYDeb = posYDeb;
    }

    /**
     * Modifie la position x de la fin du lien
     * @param posXFin une position x
     */
    public void setPosXFin(int posXFin) {
        this.posXFin = posXFin;
    }

    /**
     * Modifie la position y de la fin du lien
     * @param posYFin une position y
     */
    public void setPosYFin(int posYFin) {
        this.posYFin = posYFin;
    }

    /**
     * Permet de savoir si lien est sélectionné
     * @return retourne un boolean pour savoir si le lien est sélectionné
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * Permet de rendre ce lien sélectionné
     * @param isSelected un boolean où true si sélectionné, false sinon
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    /**
     * Mettre le lien à dessiner sous format String en donnant le type et la pondération
     * @return un string
     */
    @Override
    public String toString() {
        return this.getDonnees();
    }
    
    
}
