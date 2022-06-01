/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Noeud;

/**
 *
 * @author Steve Pennec
 */
public class GraphNoeud extends Noeud{
    
    private final int PADDING = 20;
    
    public int posX;
    public int posY;

    public GraphNoeud( String typeLieu, String nomLieu, int posX, int posY) {
        super(typeLieu, nomLieu);
        this.posX = posX;
        this.posY = posY;
    }

    
    
//    public GraphNoeud(int posX, int posY) {
//        this.noeud = noeud;
//        this.posX = posX;
//        this.posY = posY;
//    }

//    public Noeud getNoeud() {
//        return noeud;
//    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    
    
}
