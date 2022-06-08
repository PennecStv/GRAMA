/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Lien;
import grama.Noeud;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Steve Pennec
 */
public class GraphNoeud extends Noeud{
    
    private boolean isSelected;
    
    private ArrayList<GraphLien> listeLien = new ArrayList<>();
    
    private int posX;
    private int posY;
    public Color couleur;

    public GraphNoeud( String typeLieu, String nomLieu, int posX, int posY) {
        super(typeLieu, nomLieu);
        this.posX = posX;
        this.posY = posY;
        this.isSelected = false;
        
        switch(typeLieu){
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
    
    public String afficherVoisins(String type){
        String text = "";
        
        for (GraphLien lien: this.listeLien){
            Noeud noeud = lien.getNoeudArrivee();
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
    
    
    public void addLien(GraphLien lien){
        this.listeLien.add(lien);
    }
}
