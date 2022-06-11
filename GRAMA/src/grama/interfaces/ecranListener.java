/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grama.interfaces;

import grama.map.GraphNoeud;

/**
 * Cette interface stocke des méthodes utiles pour gérer l'interface graphique selon certaines manipulations
 * @author Steve Pennec
 */
public interface ecranListener {
    
    /**
     * 
     */
    public void graphNotinitialized();
    
    /**
     * 
     * @param noeud 
     */
    public void noeudAffiche(GraphNoeud noeud);
    
    /**
     * 
     */
    public void selectionPremierNoeud();
    
    /**
     * 
     */
    public void selectionDeuxiemeNoeud();
    
    /**
     * 
     */
    public void selectionAnnule();
}
