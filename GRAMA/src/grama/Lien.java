/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama;

import java.util.Objects;

/**
 *
 * @author Steve Pennec
 */
public class Lien {
    private final int ponderation;
    private final char typeRoute;
    private final Noeud DepartNoeud;
    private final Noeud ArriveNoeud;

    public Lien(int ponderation, char typeRoute, Noeud DepartNoeud, Noeud ArriveNoeud) {
        this.ponderation = ponderation;
        this.typeRoute = typeRoute;
        this.DepartNoeud = DepartNoeud;
        this.ArriveNoeud = ArriveNoeud;
    }

    public int getPonderation() {
        return ponderation;
    }

    public char getTypeRoute() {
        return typeRoute;
    }

    public Noeud getDepartNoeud() {
        return DepartNoeud;
    }

    public Noeud getArriveNoeud() {
        return ArriveNoeud;
    }
    
    public void afficherSommets(){
        System.out.println("Départ: " + DepartNoeud + " --> Arrivé: " + ArriveNoeud);
    }
    
    @Override
    public String toString(){
        return "Lien {Type: " + typeRoute + " - Valeur: " + ponderation + 
               " - Depart: " + DepartNoeud.getNomLieu() + " - Arrivee: " + ArriveNoeud.getNomLieu() +  "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

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
