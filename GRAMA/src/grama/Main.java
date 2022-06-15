/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grama;

import grama.type.typeNoeud;
import java.io.IOException;

/**
 * Cette classe Main a été utilisé pour afficher et contrôler les résultats
 * @author Steve Pennec
 */
public class Main {

    /**
     * 
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Graph grama = new Graph();
        
        /* === Ouverture de fichier === */
        String fichierGraphe = grama.ouvrirGraphe("test.csv");
        grama.creationListe(fichierGraphe);
        grama.creationListeTypee();
        
        /* === Afficher tous les noeuds et tous les liens === */
        grama.afficherListeNoeud();
        grama.afficherListeLien();
        
        System.out.print(grama.recherche("Parc de la tête d'Or"));
        /* === Lister les éléments du graphes par catégorie === */
        grama.listerCategorie("D");
        
        /* === Affichage du nombre de liens et de liens === */
        grama.getNombre("A");
        
        /* === Test sur un noeud === */
        Noeud testNoeud = grama.recherche("Villeurbanne");
        System.out.println(testNoeud);
        testNoeud.afficherVoisin();
        testNoeud.afficherVoisin(typeNoeud.V);
        
        Noeud testNoeud2 = grama.recherche("Vénissieux");
        System.out.println(testNoeud2.toString());
        testNoeud2.afficherVoisin();
        
        /* === Test sur un lien === */
        Lien testLien = grama.recherche("Villeurbanne", "Vénissieux");
        System.out.println("\n" + testLien);
        testLien.afficherSommets();
        
        
        grama.deuxDistance(grama.recherche("Villeurbanne"), grama.recherche("Mâcon"));
        
        grama.compareNoeuds(grama.recherche("ecully"), grama.recherche("La Mulatière"));
    }
    
}
