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
     * 
     */
    private Lien lien;
    
    
    /**
     * 
     */
    private int posXDeb;
    
    /**
     * 
     */
    private int posYDeb;
    
    /**
     * 
     */
    private int posXFin;
    
    /**
     * 
     */
    private int posYFin;
    
    /**
     * 
     */
    private boolean isSelected;

    
    
    /*** Constructeur ***/
    /**
     * Constructeur
     * @param lien
     * @param posXDeb
     * @param posYDeb
     * @param posXFin
     * @param posYFin 
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
     * 
     * @return 
     */
    public Lien getLien() {
        return lien;
    }

    /**
     * 
     * @return 
     */
    public int getPosXDeb() {
        return posXDeb;
    }

    /**
     * 
     * @return 
     */
    public int getPosYDeb() {
        return posYDeb;
    }

    /**
     * 
     * @return 
     */
    public int getPosXFin() {
        return posXFin;
    }

    /**
     * 
     * @return 
     */
    public int getPosYFin() {
        return posYFin;
    }

    /**
     * 
     * @return 
     */
    public Noeud getNoeudDepart() {
        return this.getLien().getDepartNoeud();
    }
    
    /**
     * 
     * @return 
     */
    public Noeud getNoeudArrivee() {
        return this.getLien().getArriveNoeud();
    }
    
    /**
     * 
     * @return 
     */
    public String getDonnees(){
        return this.lien.getTypeRoute() + ", " + this.lien.getPonderation();
    }
    
    
    
    
    /**
     * 
     * @param posXDeb 
     */
    public void setPosXDeb(int posXDeb) {
        this.posXDeb = posXDeb;
    }

    /**
     * 
     * @param posYDeb 
     */
    public void setPosYDeb(int posYDeb) {
        this.posYDeb = posYDeb;
    }

    /**
     * 
     * @param posXFin 
     */
    public void setPosXFin(int posXFin) {
        this.posXFin = posXFin;
    }

    /**
     * 
     * @param posYFin 
     */
    public void setPosYFin(int posYFin) {
        this.posYFin = posYFin;
    }

    /**
     * 
     * @return 
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * 
     * @param isSelected 
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
