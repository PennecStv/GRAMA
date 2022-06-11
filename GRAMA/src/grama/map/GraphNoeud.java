/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Lien;
import grama.Noeud;
import java.awt.Color;

/**
 *
 * @author Steve Pennec
 */
public class GraphNoeud{
    
    private boolean isSelected;
    
    public Noeud noeud;
    
    private int posX;
    private int posY;
    public Color couleur;

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

    
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Color getCouleur() {
        return couleur;
    }
    
    public String getNomLieu(){
        return noeud.getNomLieu();
    }
    
    public String getTypeLieu(){
        return noeud.getTypeLieu();
    }
    
    
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
    

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }  

    
    
    @Override
    public String toString() {
        return this.getTypeLieu() + ": " + this.getNomLieu();
    }
    
    
}
