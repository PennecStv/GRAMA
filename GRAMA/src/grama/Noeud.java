/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama;

import java.util.ArrayList;
import java.util.Objects;
import grama.type.typeNoeud;

/**
 * Cette classe représente un noeud et toutes les informations qu'elle possèdera auprès d'un graphe
 * @author Steve Pennec
 */
public class Noeud {
    
    /**
     * Correspond à son type listé dans l'énumération {@link #typeNoeud}
     */
    private String typeLieu;
    
    /**
     * Correspond au nom de noeud
     */
    private String nomLieu;
    
    /**
     * Correspond à une liste de tous les liens ayant pour point de départ ce noeud
     */
    private final ArrayList<Lien> listeLien = new ArrayList<>();

    /**
     * Constructeur du noeud
     * @param typeLieu le type du noeud du graphe
     * @param nomLieu  le nom du noeud du graphe
     */
    public Noeud(String typeLieu, String nomLieu) {
        this.typeLieu = typeLieu;
        this.nomLieu = nomLieu;
    }

    
    /**
     * Renvoie le type du noeud
     * @return retourne le type du noeud
     */
    public String getTypeLieu() {
        return typeLieu;
    }

    /**
     * Renvoie le nom du noeud
     * @return retourne le nom du noeud
     */
    public String getNomLieu() {
        return nomLieu;
    }

    /**
     * Renvoie la liste de liens attachés au noeud
     * @return retourne la liste de liens ayant pour noeud de départ celui-ci
     */
    public ArrayList<Lien> getListeLien() {
        return listeLien;
    }

    /**
     * Modifie le type du noeud
     * @param typeLieu le type de noeud qui remplacera le précédent
     */
    public void setTypeLieu(String typeLieu) {
        this.typeLieu = typeLieu;
    }
    
    /**
     * Modifie le nom du noeud
     * @param nomLieu  le nom du noeud qui remplacera le précédent
     */
    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }
    
    
    /**
     * Ajoute un lien à la liste des liens débutant par ce noeud
     * @param lien le lien à ajouter
     */
    public void addLien(Lien lien){
        if (lien != null && lien.getDepartNoeud().equals(this) && !this.listeLien.contains(lien)){
            this.listeLien.add(lien); 
        }
    }
    
    /**
     * Affiche tous les liens de sa liste de liens commançant par ce noeud
     * @deprecated 
     */
    @Deprecated
    public void afficherRoute() {
        System.out.println(nomLieu + " - Liste des voisins à 1-saut:");
        for (Lien lien : listeLien){
            System.out.println(lien);
        }
    }
    
    /**
     * Renvoie la liste des voisins du noeud
     * @return retourne une ArrayList de noeuds voisins du noeud
     */
    public ArrayList<Noeud> getVoisin(){
        ArrayList<Noeud> listeVoisin = new ArrayList<>();
      
        for (Lien lien : listeLien){
            listeVoisin.add(lien.getArriveNoeud());
        }
        
        return listeVoisin;
    }
    
    /**
     * Affiche tous les voisins à un saut du noeud en passant par tous ses liens rattachés à lui
     * @deprecated 
     */
    @Deprecated
    public void afficherVoisin() {
        System.out.println(nomLieu + " - Liste des voisins à 1-saut:");
        for (Noeud noeud: this.getVoisin()){
            System.out.println(noeud);
        }
    }
    
    /**
     * Affiche tous les voisins à un saut du noeud en passant par tous ses liens rattachés à lui selon le type choisi
     * @param type le type de noeud à afficher
     * @deprecated 
     */
    @Deprecated
    public void afficherVoisin(typeNoeud type){
        switch(type){
            case V:
                System.out.println(nomLieu + " - Liste des villes à 1-saut:");
                break;
                
            case R:
                System.out.println(nomLieu + " - Liste des restaurants à 1-saut:");
                break;
                
            case L:
                System.out.println(nomLieu + " - Liste des lieux de loisirs à 1-saut:");
                break;
                
            default:
                System.out.println("Type de noeud non reconnu...");
                break;
        }
        for (Noeud noeud: this.getVoisin()){
            if (noeud.getTypeLieu().equals(type.toString()))
                System.out.println(noeud);
        }
    }
    
    
    /**
     * Renvoie un hashCode du noeud
     * @return retourne un hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.typeLieu);
        hash = 13 * hash + Objects.hashCode(this.nomLieu);
        return hash;
    }

    /**
     * Renvoie un boolean pour vérifier si ce noeud est égal à un autre
     * @param obj un objet principalement de type Noeud
     * @return retourne un boolean
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
        final Noeud other = (Noeud) obj;
        if (!Objects.equals(this.typeLieu, other.typeLieu)) {
            return false;
        }
        return Objects.equals(this.nomLieu, other.nomLieu);
    }

    /**
     * Convertis le noeud en chaîne de caractères String
     * @return un String montrant les données du noeud
     */
    @Override
    public String toString() {
        return typeLieu + ": " + nomLieu;
    }
    
    
}
