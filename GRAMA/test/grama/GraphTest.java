/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package grama;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Steve Pennec
 */
public class GraphTest {
    
    public GraphTest() {
    }


    /**
     * Test of ouvrirGraphe method, of class Graph.
     */
    @Test
    public void testOuvrirGraphe() throws Exception {
        System.out.println("ouvrirGraphe");
        Graph instance = new Graph();
        String expResult =  "V,Lyon:D,9::V,Villeurbanne;N,20::R,Les Echets;N,18::L,We are sports;;\n" +
                            "L,Musée des Confluences:D,6::R,Chamas Tacos;D,2::L,Aquarium de Lyon;D,5::V,Oullins;N,29::R,McDo-Décines;;\n" +
                            "R,McDo-Décines:N,15::L,Parc de la tête d'Or;A,80::V,Mâcon;N,29::L,Musée des Confluences;N,22::V,Ecully;N,21::L,France Aventures Lyon Fourvière;N,22::V,Champagne-au-Mont-d'Or;;\n" +
                            "R,Chamas Tacos:A,8::L,Aquarium de Lyon;D,4::L,Centre commercial Westfield Part-Dieu;N,16::V,Dardilly;D,6::L,Musée des Confluences;D,3::L,UGC Ciné Cité Part-Dieu;N,11::V,Chassieu;A,77::V,Mâcon;N,19::V,Pierre-Bénite;;\n" +
                            "L,Parc de la Tête d'Or:D,3::R,Le bistrot d'Alexis;N,11::V,Ecully;D,7::L,France Aventures Lyon Fourvière;N,15::R,McDo-Décines;A,17::R,Les Echets;N,14::V,Dardilly;N,14::V,Chassieu;;\n" +
                            "V,Villeurbanne:N,13::V,Vénissieux;D,2::R,La Tamtamerie;D,9::L,Royal Kids Chassieu;D,9::V,Lyon;N,13::V,Meyzieu;D,5::R,Engimono;N,14::R,McDo-Tassin-la-Demi-Lune;N,19::V,Sainte-Foy-lès-Lyon;;\n" +
                            "R,Les Echets:N,31::V,Feyzin;A,17::L,Parc de la Tête d'Or;A,13::V,Vaulx-en-Velin;N,20::V,Lyon;N,25::V,Saint-Fons;;\n" +
                            "L,We are sports:A,17::R,Le caveau des gourmands;N,10::V,Pierre-Bénite;N,8::R,La Tamtamerie;N,18::V,Lyon;A,20::V,Ecully;A,86::V,Mâcon;D,16::V,Caluire-et-Cuire;;\n" +
                            "L,Royal Kids Chassieu:D,7::R,La Tamtamerie;D,35::V,Francheville;N,28::V,Collonges-au-Mont-d'Or;D,9::V,Villeurbanne;N,14::V,Saint-Fons;N,19::V,Sainte-Foy-lès-Lyon;;\n" +
                            "V,Meyzieu:N,13::V,Villeurbanne;N,23::V,Tassin-la-Demi-Lune;N,29::L,Aquarium de Lyon;;\n" +
                            "V,Bron:N,14::L,Aquarium de Lyon;N,15::V,La Mulatière;A,83::V,Mâcon;D,6::V,Vénissieux;D,20::V,Saint-Romain-au-Mont-d'Or;N,19::V,Saint-Didier-Au-Mont-D'or;D,13::V,Caluire-et-Cuire;A,22::L,France Aventures Lyon Fourvière;D,15::R,Le caveau des gourmands;;\n" +
                            "V,Oullins:A,15::V,Dardilly;D,10::R,Le Bistrot D'Alexis;A,10::L,France Aventures Lyon Fourvière;D,5::L,Musée des Confluences;D,2::L,Aquarium de Lyon;;\n" +
                            "L,Centre commercial Westfield Part-Dieu:A,13::V,Dardilly;D,7::V,Vaulx-en-Velin;D,4::R,Chamas Tacos;D,3::R,Le caveau des gourmands;;\n" +
                            "V,Feyzin:A,23::V,Saint-Didier-Au-Mont-D'or;A,18::V,Ecully;A,15::L,UGC Ciné Cité Part-Dieu;N,31::R,Les Echets;;\n" +
                            "V,Ecully:N,22::R,McDo-Décines;A,20::L,We are sports;D,5::L,France Aventures Lyon Fourvière;N,11::L,Parc de la Tête d'Or;A,18::V,Feyzin;N,16::R,Le Bistrot D'Alexis;A,8::R,Engimono;;\n" +
                            "R,Le Bistrot D'Alexis:N,16::V,Ecully;D,4::R,Engimono;N,20::V,Dardilly;D,3::L,Parc de la Tête d'Or;D,10::V,Oullins;A,9::V,La Mulatière;;\n" +
                            "V,Francheville:N,28::V,Chassieu;D,16::L,UGC Ciné Cité Part-Dieu;A,19::V,Saint-Fons;D,35::L,Royal Kids Chassieu;D,17::V,Collonges-au-Mont-d'Or;;\n" +
                            "R,Engimono:D,5::V,Villeurbanne;A,8::V,Ecully;D,2::R,Le caveau des gourmands;D,4::R,Le Bistrot D'Alexis;D,10::V,Rillieux-la-Pape;;\n" +
                            "V,Saint-Fons:N,25::R,Les Echets;D,3::V,Vénissieux;N,14::L,Royal Kids Chassieu;A,19::V,Francheville;A,16::V,Tassin-la-Demi-Lune;;\n" +
                            "V,Vénissieux:D,9::L,UGC Ciné Cité Part-Dieu;A,25::V,Dardilly;D,6::V,Bron;N,13::V,Villeurbanne;D,3::V,Saint-Fons;A,22::R,McDo-Tassin-la-Demi-Lune;N,22::V,Saint-Didier-Au-Mont-D'or;A,20::L,France Aventures Lyon Fourvière;N,12::V,Vaulx-en-Velin;;\n" +
                            "L,UGC Ciné Cité Part-Dieu:D,3::R,Chamas Tacos;A,74::V,Mâcon;D,6::L,Aquarium de Lyon;A,15::V,Feyzin;D,16::V,Francheville;D,9::V,Vénissieux;;\n" +
                            "R,McDo-Tassin-la-Demi-Lune:A,10::L,Aquarium de Lyon;N,14::V,Villeurbanne;A,22::V,Vénissieux;N,12::V,Caluire-et-Cuire;;\n" +
                            "V,Dardilly:A,25::V,Vénissieux;N,19::R,La Tamtamerie;N,14::L,Parc de la tête d'Or;N,16::R,Chamas Tacos;A,15::V,Oullins;A,13::L,Centre commercial Westfield Part-Dieu;N,20::R,Le Bistrot D'Alexis;A,13::L,Aquarium de Lyon;D,11::V,Collonges-au-Mont-d'Or;;\n" +
                            "V,Chassieu:N,14::L,Parc de la tête d'Or;N,11::R,Chamas Tacos;N,22::V,Saint-Romain-au-Mont-d'Or;N,28::V,Francheville;D,8::R,La Tamtamerie;;\n" +
                            "V,Saint-Romain-au-Mont-d'Or:A,17::L,Aquarium De Lyon;D,20::V,Bron;N,18::R,La Tamtamerie;N,22::V,Chassieu;;\n" +
                            "L,Aquarium de Lyon:N,29::V,Meyzieu;D,2::V,Oullins;A,13::V,Dardilly;D,2::L,Musée des Confluences;A,8::R,Chamas Tacos;N,14::V,Bron;D,6::L,UGC Ciné Cité Part-Dieu;A,10::R,McDo-Tassin-la-Demi-Lune;A,7::V,Tassin-la-Demi-Lune;A,17::V,Saint-Romain-au-Mont-d'Or;N,20::V,Rillieux-la-Pape;N,20::V,Vaulx-en-Velin;;\n" +
                            "V,Collonges-au-Mont-d'Or:D,11::V,Dardilly;A,15::V,La Mulatière;D,17::V,Francheville;N,28::L,Royal Kids Chassieu;;\n" +
                            "V,Mâcon:A,77::R,Chamas Tacos;A,86::L,We are sports;A,83::V,Bron;A,80::R,McDo-Décines;A,74::L,UGC Ciné Cité Part-Dieu;A,74::V,La Mulatière;A,72::R,Le caveau des gourmands;;\n" +
                            "V,Saint-Didier-Au-Mont-D'or:N,19::V,Bron;N,22::V,Vénissieux;D,7::R,Le caveau des gourmands;A,23::V,Feyzin;;\n" +
                            "R,La Tamtamerie:D,8::V,Chassieu;N,19::V,Dardilly;D,7::L,Royal Kids Chassieu;D,2::V,Villeurbanne;N,8::L,We are sports;N,18::V,Saint-Romain-au-Mont-d'Or;D,10::V,Rillieux-la-Pape;D,4::V,Vaulx-en-Velin;N,16::V,Sainte-Foy-lès-Lyon;;\n" +
                            "V,Rillieux-la-Pape:D,10::R,La Tamtamerie;N,20::L,Aquarium de Lyon;D,10::R,Engimono;D,14::V,La Mulatière;;\n" +
                            "V,Caluire-et-Cuire:D,13::V,Bron;N,12::R,McDo-Tassin-la-Demi-Lune;D,16::L,We are sports;A,14::V,Pierre-Bénite;;\n" +
                            "L,France Aventures Lyon Fourvière:N,21::R,Mcdo-Décines;A,20::V,Vénissieux;A,22::V,Bron;D,7::L,Parc de la Tête d'Or;A,10::V,Oullins;D,5::V,Ecully;;\n" +
                            "V,Pierre-Bénite:D,3::V,La Mulatière;N,19::R,Chamas Tacos;A,14::V,Caluire-et-Cuire;N,10::L,We are sports;;\n" +
                            "V,La Mulatière:D,14::V,Rillieux-La-Pape;A,74::V,Mâcon;A,9::R,Le Bistrot D'Alexis;N,15::V,Bron;A,15::V,Collonges-au-Mont-d'Or;D,3::V,Pierre-Bénite;A,9::V,Tassin-la-Demi-Lune;A,12::V,Champagne-au-Mont-d'Or;;\n" +
                            "V,Tassin-la-Demi-Lune:A,16::V,Saint-Fons;A,9::V,La Mulatière;A,7::L,Aquarium de Lyon;N,23::V,Meyzieu;;\n" +
                            "V,Vaulx-en-Velin:N,20::L,Aquarium de Lyon;D,4::R,La Tamtamerie;N,12::V,Vénissieux;A,13::R,Les Echets;D,7::L,Centre commercial Westfield Part-Dieu;;\n" +
                            "R,Le caveau des gourmands:A,72::V,Mâcon;D,15::V,Bron;D,3::L,Centre commercial Westfield Part-Dieu;A,17::L,We are sports;D,2::R,Engimono;D,7::V,Saint-Didier-Au-Mont-D'or;D,7::V,Champagne-au-Mont-d'Or;;\n" +
                            "V,Champagne-au-Mont-d'Or:D,7::R,Le caveau des gourmands;A,12::V,La Mulatière;N,22::R,McDo-Décines;;\n" +
                            "V,Sainte-Foy-lès-Lyon:N,19::V,Villeurbanne;N,19::L,Royal Kids Chassieu;N,16::R,La Tamtamerie;;";
        String result = instance.ouvrirGraphe("Graphe.csv");
        
        assertEquals(expResult, result);
    }

    /**
     * Test of creationNoeud method, of class Graph.
     */
    @Test
    public void testCreationNoeud() {
        System.out.println("creationNoeud");
        String noeud = "V,Lyon:D,9::V,Villeurbanne;N,20::R,Les Echets;N,18::L,We are sports;;";
        Graph instance = new Graph();
        Noeud expResult = new Noeud("V", "Lyon");
        Noeud result = instance.creationNoeud(noeud);
        assertEquals(expResult, result);
    }

    /**
     * Test of creationLien method, of class Graph.
     */
    @Test
    public void testCreationLien() {
        System.out.println("creationLien");
        Noeud noeudDepart = new Noeud("V", "Lyon");
        Noeud noeudArrive = new Noeud("V", "Villeurbanne");
        String lien = "D,9::V,Villeurbanne";
        Graph instance = new Graph();
        Lien expResult = new Lien(9, 'D', noeudDepart, noeudArrive);
        Lien result = instance.creationLien(noeudDepart, lien);
        assertEquals(expResult, result);
    }

    /**
     * Test of creationListe method, of class Graph.
     */
    @Test
    public void testCreationListe() {
        System.out.println("creationListe");
        String listeFichierNoeud = "";
        Graph instance = new Graph();
        instance.creationListe(listeFichierNoeud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creationListeTypee method, of class Graph.
     */
    @Test
    public void testCreationListeTypee() {
        System.out.println("creationListeTypee");
        Graph instance = new Graph();
        instance.creationListeTypee();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of listerCategorie method, of class Graph.
     */
    @Test
    public void testListerCategorie() {
        System.out.println("listerCategorie");
        String type = "";
        Graph instance = new Graph();
        String expResult = "";
        String result = instance.listerCategorie(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherListe method, of class Graph.
     */
    @Test
    public void testAfficherListe() {
        System.out.println("afficherListe");
        ArrayList liste = null;
        String texte = "";
        Graph instance = new Graph();
        String expResult = "";
        String result = instance.afficherListe(liste, texte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherNombre method, of class Graph.
     */
    @Test
    public void testAfficherNombre() {
        System.out.println("afficherNombre");
        String categorie = "";
        Graph instance = new Graph();
        String expResult = "";
        String result = instance.getNombre(categorie);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherVoisinUnSaut method, of class Graph.
     */
    @Test
    public void testAfficherVoisinUnSaut() {
        System.out.println("afficherVoisinUnSaut");
        String nomNoeud = "";
        Graph instance = new Graph();
        instance.afficherVoisinUnSaut(nomNoeud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deuxDistance method, of class Graph.
     */
    @Test
    public void testDeuxDistance() {
        System.out.println("deuxDistance");
        String nomNoeud1 = "";
        String nomNoeud2 = "";
        Graph instance = new Graph();
        boolean expResult = false;
        //boolean result = instance.deuxDistance(nomNoeud1, nomNoeud2);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parcoursVoisin method, of class Graph.
     */
    @Test
    public void testParcoursVoisin() {
        System.out.println("parcoursVoisin");
        Noeud noeud = null;
        Graph instance = new Graph();
        instance.parcoursVoisin(noeud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recherche method, of class Graph.
     */
    @Test
    public void testRecherche_String() {
        System.out.println("recherche");
        String nomNoeud = "";
        Graph instance = new Graph();
        Noeud expResult = null;
        Noeud result = instance.recherche(nomNoeud);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recherche method, of class Graph.
     */
    @Test
    public void testRecherche_String_String() {
        System.out.println("recherche");
        String depart = "";
        String arrive = "";
        Graph instance = new Graph();
        Lien expResult = null;
        Lien result = instance.recherche(depart, arrive);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareVilles method, of class Graph.
     */
    @Test
    public void testCompareVilles() {
        System.out.println("compareVilles");
        String nomNoeud1 = "";
        String nomNoeud2 = "";
        Graph instance = new Graph();
        instance.compareVilles(nomNoeud1, nomNoeud2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compteDeuxDistances method, of class Graph.
     */
    @Test
    public void testCompteDeuxDistances() {
        System.out.println("compteDeuxDistances");
        String nomNoeud1 = "";
        String nomNoeud2 = "";
        ArrayList<Noeud> liste = null;
        Graph instance = new Graph();
        boolean expResult = false;
        boolean result = instance.compteDeuxDistances(nomNoeud1, nomNoeud2, liste);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordreGraphe method, of class Graph.
     */
    @Test
    public void testOrdreGraphe() {
        System.out.println("ordreGraphe");
        Graph instance = new Graph();
        int expResult = 0;
        int result = instance.ordreGraphe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tailleGraphe method, of class Graph.
     */
    @Test
    public void testTailleGraphe() {
        System.out.println("tailleGraphe");
        Graph instance = new Graph();
        int expResult = 0;
        int result = instance.tailleGraphe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListeNoeud method, of class Graph.
     */
    @Test
    public void testGetListeNoeud() {
        System.out.println("getListeNoeud");
        Graph instance = new Graph();
        ArrayList<Noeud> expResult = null;
        ArrayList<Noeud> result = instance.getListeNoeud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListeLien method, of class Graph.
     */
    @Test
    public void testGetListeLien() {
        System.out.println("getListeLien");
        Graph instance = new Graph();
        ArrayList<Lien> expResult = null;
        ArrayList<Lien> result = instance.getListeLien();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNoeud method, of class Graph.
     */
    @Test
    public void testGetNoeud() {
        System.out.println("getNoeud");
        String nom = "";
        Graph instance = new Graph();
        Noeud expResult = null;
        Noeud result = instance.getNoeud(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherListeNoeud method, of class Graph.
     */
    @Test
    public void testAfficherListeNoeud() {
        System.out.println("afficherListeNoeud");
        Graph instance = new Graph();
        instance.afficherListeNoeud();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherListeLien method, of class Graph.
     */
    @Test
    public void testAfficherListeLien() {
        System.out.println("afficherListeLien");
        Graph instance = new Graph();
        instance.afficherListeLien();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
