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
     * 
     */
    private boolean isSelected;
    
    /**
     * 
     */
    public Noeud noeud;
    
    /**
     * 
     */
    private int posX;
    
    /**
     * 
     */
    private int posY;
    
    /**
     * 
     */
    public Color couleur;

    
    
    /*** Constructeur ***/
    /**
     * 
     * @param noeud
     * @param posX
     * @param posY 
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
     * 
     * @return 
     */
    public int getPosX() {
        return posX;
    }

    /**
     * 
     * @return 
     */
    public int getPosY() {
        return posY;
    }

    /**
     * 
     * @return 
     */
    public Color getCouleur() {
        return couleur;
    }
    
    /**
     * 
     * @return 
     */
    public String getNomLieu(){
        return noeud.getNomLieu();
    }
    
    /**
     * 
     * @return 
     */
    public String getTypeLieu(){
        return noeud.getTypeLieu();
    }
    
    /**
     * 
     * @param posX 
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * 
     * @param posY 
     */
    public void setPosY(int posY) {
        this.posY = posY;
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

    
    //Autre méthode
    /**
     * 
     * @param type
     * @return 
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
     * 
     * @return 
     */
    @Override
    public String toString() {
        return this.getTypeLieu() + ": " + this.getNomLieu();
    }
    
    
}
