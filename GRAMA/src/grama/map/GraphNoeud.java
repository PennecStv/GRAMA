/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Noeud;
import java.awt.Color;

/**
 *
 * @author Steve Pennec
 */
public class GraphNoeud extends Noeud{
    
    private boolean isSelected;
    
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
}
