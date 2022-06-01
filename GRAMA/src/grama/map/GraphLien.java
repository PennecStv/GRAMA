/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama.map;

import grama.Lien;
import grama.Noeud;

/**
 *
 * @author Steve Pennec
 */
public class GraphLien{
    
    private Lien lien;
    
    private int posXDeb;
    private int posYDeb;
    private int posXFin;
    private int posYFin;

    public GraphLien(Lien lien, int posXDeb, int posYDeb, int posXFin, int posYFin) {
        this.lien = lien;
        this.posXDeb = posXDeb;
        this.posYDeb = posYDeb;
        this.posXFin = posXFin;
        this.posYFin = posYFin;
    }

    public Lien getLien() {
        return lien;
    }

    public int getPosXDeb() {
        return posXDeb;
    }

    public int getPosYDeb() {
        return posYDeb;
    }

    public int getPosXFin() {
        return posXFin;
    }

    public int getPosYFin() {
        return posYFin;
    }
    
    
    public boolean compareCoord(){
        return true;
    }
}
