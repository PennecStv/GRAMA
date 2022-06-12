/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama;

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
        return "Type: " + typeRoute + " - Valeur: " + ponderation + 
               " - Depart: " + DepartNoeud.getNomLieu() + " - Arrivee: " + ArriveNoeud.getNomLieu();
    }
}
