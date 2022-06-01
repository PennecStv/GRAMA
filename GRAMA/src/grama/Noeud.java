/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Steve Pennec
 */
public class Noeud {
    private String typeLieu;
    private String nomLieu;
    private final ArrayList<Lien> listeLien = new ArrayList<>();

    public Noeud(String typeLieu, String nomLieu) {
        this.typeLieu = typeLieu;
        this.nomLieu = nomLieu;
    }

    public String getTypeLieu() {
        return typeLieu;
    }

    public String getNomLieu() {
        return nomLieu;
    }

    public ArrayList<Lien> getListeLien() {
        return listeLien;
    }

    public void setTypeLieu(String typeLieu) {
        this.typeLieu = typeLieu;
    }
    
    public void setNomLien(String nomLieu) {
        this.nomLieu = nomLieu;
    }
    
    
    
    public void addLien(Lien lien){
        if (lien != null && lien.getDepartNoeud().equals(this) && !this.listeLien.contains(lien)){
            this.listeLien.add(lien); 
        }
    }
    
    
    public void afficherRoute() {
        System.out.println(nomLieu + " - Liste des voisins à 1-saut:");
        for (Lien lien : listeLien){
            System.out.println(lien);
        }
    }
    
    
    public ArrayList<Noeud> getVoisin(){
        ArrayList<Noeud> listeVoisin = new ArrayList<>();
      
        for (Lien lien : listeLien){
            listeVoisin.add(lien.getArriveNoeud());
        }
        
        return listeVoisin;
    }
    
    
    public void afficherVoisin() {
        System.out.println(nomLieu + " - Liste des voisins à 1-saut:");
        for (Noeud noeud: this.getVoisin()){
            System.out.println(noeud);
        }
    }
    
    public void afficherVoisin(String type){
        switch(type){
            case "V":
                System.out.println(nomLieu + " - Liste des villes à 1-saut:");
                break;
                
            case "R":
                System.out.println(nomLieu + " - Liste des restaurants à 1-saut:");
                break;
                
            case "L":
                System.out.println(nomLieu + " - Liste des lieux de loisirs à 1-saut:");
                break;
                
            default:
                System.out.println("Type de noeud non reconnu...");
                break;
        }
        for (Noeud noeud: this.getVoisin()){
            if (noeud.getTypeLieu().equals(type))
                System.out.println(noeud);
        }
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.typeLieu);
        hash = 13 * hash + Objects.hashCode(this.nomLieu);
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
        final Noeud other = (Noeud) obj;
        if (!Objects.equals(this.typeLieu, other.typeLieu)) {
            return false;
        }
        return Objects.equals(this.nomLieu, other.nomLieu);
    }

    @Override
    public String toString() {
        return "Noeud {typeLieu: " + typeLieu + " - nomLieu: " + nomLieu + "}";
    }
    
    
}
