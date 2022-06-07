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
     * Test of ouvrirGraphe method, of class Graph.
     */
    @Test
    public void testOuvrirGraphe() throws Exception {
        System.out.println("ouvrirGraphe");
        Graph instance = new Graph();
        String expResult = "";
        String result = instance.ouvrirGraphe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creationNoeud method, of class Graph.
     */
    @Test
    public void testCreationNoeud() {
        System.out.println("creationNoeud");
        String noeud = "";
        Graph instance = new Graph();
        Noeud expResult = null;
        Noeud result = instance.creationNoeud(noeud);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creationLien method, of class Graph.
     */
    @Test
    public void testCreationLien() {
        System.out.println("creationLien");
        Noeud noeudDepart = null;
        String lien = "";
        Graph instance = new Graph();
        Lien expResult = null;
        Lien result = instance.creationLien(noeudDepart, lien);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        String result = instance.afficherNombre(categorie);
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
        boolean result = instance.deuxDistance(nomNoeud1, nomNoeud2);
        assertEquals(expResult, result);
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
    
}
