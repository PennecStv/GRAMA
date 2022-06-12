/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama;

import java.util.Objects;

/**
 * Cette classe permet de définir un lien du graphe
 * @author Steve Pennec
 */
public class Lien {
    /**
     * Correspond à la valeur d'un lien, soit dans notre contexte à un kilométrage
     */
    private final int ponderation;
    
    /**
     * Correspond au type de lien, étant soit une autoroutes, une route nationale ou une route départementale
     */
    private final char typeRoute;
    
    /**
     * Correspond au noeud de départ du lien
     */
    private final Noeud DepartNoeud;
    
    /**
     * Correspond au noeud d'arrivée du lien
     */
    private final Noeud ArriveNoeud;

    /**
     * Constructeur du lien
     * @param ponderation étant le kilométrage
     * @param typeRoute étant le type de la route
     * @param DepartNoeud étant le noeud de départ
     * @param ArriveNoeud étant le noeud d'arrivée
     */
    public Lien(int ponderation, char typeRoute, Noeud DepartNoeud, Noeud ArriveNoeud) {
        this.ponderation = ponderation;
        this.typeRoute = typeRoute;
        this.DepartNoeud = DepartNoeud;
        this.ArriveNoeud = ArriveNoeud;
    }

    /**
     * Renvoie la pondération du lien
     * @return la pondération
     */
    public int getPonderation() {
        return ponderation;
    }

    /**
     * Renvoie le type de la route
     * @return le type
     */
    public char getTypeRoute() {
        return typeRoute;
    }

    /**
     * Renvoie le noeud de départ
     * @return le noeud de départ
     */
    public Noeud getDepartNoeud() {
        return DepartNoeud;
    }

    /**
     * Renvoie le noeud d'arrivée
     * @return le noeud
     */
    public Noeud getArriveNoeud() {
        return ArriveNoeud;
    }
    
    /**
     * Affiche les extrémités du lien
     */
    public void afficherSommets(){
        System.out.println("Départ: " + DepartNoeud + " --> Arrivé: " + ArriveNoeud);
    }
    
    /**
     * Affiche le lien et ses informations
     * @return tous les attributs du liens ainsi que les noms de noeuds dans ses extrémités
     */
    @Override
    public String toString(){
        return "Type: " + typeRoute + " - Valeur: " + ponderation + 
               " - Depart: " + DepartNoeud.getNomLieu() + " - Arrivee: " + ArriveNoeud.getNomLieu();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    /**
     * Vérifie si deux liens sont égaux
     * @param obj
     * @return un boolean true s'ils sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lien other = (Lien) obj;
        if (this.ponderation != other.ponderation) {
            return false;
        }
        if (this.typeRoute != other.typeRoute) {
            return false;
        }
        if (!Objects.equals(this.DepartNoeud, other.DepartNoeud)) {
            return false;
        }
        return Objects.equals(this.ArriveNoeud, other.ArriveNoeud);
    }
    
    
}
