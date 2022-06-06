/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grama.interfaces;

import grama.map.Map;

/**
 *
 * @author Steve Pennec
 */
public interface MapDesigner {
    
//METHODES PUBLICS
    /**
     * Peinds les champignons
     * @param g Correspond au graphique qui sera peint
     */
    public void paintNoeud(java.awt.Graphics g);

    /**
     * Peinds le nombre d'unité par champignons
     * @param g Correspond au graphique qui sera peint
     */
    public void paintLien(java.awt.Graphics g);

    
    public void paintLabel(java.awt.Graphics g);
    
    /**
     * Peinds la sélection d'un champignons
     * @param g Correspond au graphique qui sera peint
     */
    public void paintNoeudSelected(java.awt.Graphics g);

    
}
