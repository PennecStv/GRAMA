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
     * Lorsque le graphe n'est pas initialisé
     */
    public void graphNotinitialized();
    
    /**
     * Lorsque les informations d'un noeud doivent être affiché
     * @param noeud du noeud dont on souhaite savoir les informations
     */
    public void noeudAffiche(GraphNoeud noeud);
    
    /**
     * Lorsque qu'on sélectionne un premier noeud
     */
    public void selectionPremierNoeud();
    
    /**
     * Lorsque qu'on sélectionne un deuxième noeud
     */
    public void selectionDeuxiemeNoeud();
    
    /**
     * Lorsque qu'on annule une sélection
     */
    public void selectionAnnule();
}
