/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grama.interfaces;

import grama.map.Map;

/**
 * Cette interface n'est pas utilisé, elle avait pour but de contenir les méthodes de dessins de la map
 * @author Steve Pennec
 */
public interface MapDesigner {
    
//METHODES PUBLICS
    /**
     * Peind les noeuds du graphe
     * @param g Correspond au graphique qui sera peint
     */
    public void paintNoeud(java.awt.Graphics g);

    /**
     * Peind les liens du graphe
     * @param g Correspond au graphique qui sera peint
     */
    public void paintLien(java.awt.Graphics g);

    /**
     * Peind les données des liens du graphe
     * @param g 
     */
    public void paintLabel(java.awt.Graphics g);
    
    /**
     * Peind le noeud sélectionné
     * @param g Correspond au graphique qui sera peint
     */
    public void paintNoeudSelected(java.awt.Graphics g);

    
}
