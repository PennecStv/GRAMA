/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grama.interfaces;

import grama.map.GraphNoeud;
import javax.swing.JLabel;

/**
 *
 * @author Steve Pennec
 */
public interface ecranListener {
    
    public void graphNotinitialized();
    
    
    public void typeNoeudAffiche(GraphNoeud noeud);
    
    
    public void selectionPremierNoeud();
    
    
    public void selectionDeuxiemeNoeud();
    
    
    public void selectionAnnule();
}
