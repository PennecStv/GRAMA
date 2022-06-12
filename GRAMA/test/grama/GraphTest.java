/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package grama;

import java.util.ArrayList;
//import org.junit.jupiter.api.Test;*
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steve Pennec
 */
public class GraphTest {
    
    public GraphTest() {

    }


    /**
     * Test of ouvrirGraphe method, of class Graph.
     * Non fonctionnel car la lecture n'arrive pas à récuperer les caractères spéciaux
     */
    @Test
    @Deprecated
    public void testOuvrirGraphe() throws Exception {
        System.out.println("ouvrirGraphe");
        Graph instance = new Graph();
        String expResult =  """
                            V,Firminy:D,3.5::V,Chambon-Feugerolles;D,4.7::V,Unieux;D,2::R,La Mine Burgers;A,19.5::L,Geoffroy Guichard;;
                            V,Chambon-Feugerolles:D,11.1::V,St-Etienne;D,4.2::V,La Ricamarie;D,10.7::V,Roche-la-Molière;;
                            V,St-Etienne:N,12.5::V,Saint-Chamond;D,5.2::L,Parc Jean Marc;;
                            V,Saint-Chamond:A,14.6::V,Rive-de-Gier;;
                            V,Rive-de-Gier:A,15.5::V,Givors;D,9.1::L,Espace Pierre Bret;;
                            V,Givors:A,19.1::V,Saint-Fons;D,11.3::V,Brignais;;
                            V,Saint-Fons:D,12.2::V,Villeurbanne;D,7.7::L,Musée Lumière;D,6.5::V,Lyon 8e Arrondissement;;
                            V,Brignais:A,24.4::V,Villeurbanne;D,2.9::L,Cinéma;;
                            L,Cinéma:D,7.6::R,Intermarché SUPER;;
                            R,Intermarché SUPER:D,19.3::V,Villeurbanne;;
                            V,Unieux:D,3.1::R,Auberge Des Girards;;
                            V,La Ricamarie:D,5::L,Musée d'Art et d'Industrie;;
                            V,Roche-la-Molière:D,2.4::L,Roseraie du Berland;;
                            V,Villeurbanne:D,2.8::R,Le Studio;D,2.3::L,Institut d'art contemporain;D,9.6::V,Lyon 9e Arrondissement;D,2.9::L,Parc de la Tête d'Or;;
                            V,Lyon 8e Arrondissement:D,4.8::V,Villeurbanne;D,2.4::L,Parc Sergent Blandan;;
                            V,Lyon 9e Arrondissement:A,5.8::V,Lyon 2e Arrondissement;A,5.9::L,Confluence;;
                            V,Lyon 2e Arrondissement:A,14.8::V,Brignais;;""";
        String result = instance.ouvrirGraphe("graph_map.csv");
        
        System.out.println(expResult);
        System.out.println("====================");
        System.out.println(result);
        assertEquals(expResult, result);
    }
  
    /**
     * Test of creationNoeud method, of class Graph.
     */
    @Test
    public void testCreationNoeud() {
        System.out.println("creationNoeud");
        
        String noeud1 = "V,Lyon";
        String noeud2 = "R,Les Echets";
        String noeud3 = "L,France Aventures Lyon Fourvière";
        
        Graph instance = new Graph();
        Noeud expResult1 = new Noeud("V", "Lyon");
        Noeud expResult2 = new Noeud("R", "Les Echets");
        Noeud expResult3 = new Noeud("L", "France Aventures Lyon Fourvière");
        
        Noeud result1 = instance.creationNoeud(noeud1);
        Noeud result2 = instance.creationNoeud(noeud2);
        Noeud result3 = instance.creationNoeud(noeud3);
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of creationLien method, of class Graph.
     */
    @Test
    public void testCreationLien() {
        System.out.println("creationLien");
        Graph instance = new Graph();
        
        Noeud noeudDepart1 = new Noeud("V", "Lyon");
        Noeud noeudArrive1 = new Noeud("V", "Villeurbanne");
        String lien1 = "D,9::V,Villeurbanne";
        Lien expResult1 = new Lien(9, 'D', noeudDepart1, noeudArrive1);
        Lien result1 = instance.creationLien(noeudDepart1, lien1);
        
        
        Noeud noeudDepart2 = new Noeud("V", "Lyon");
        Noeud noeudArrive2 = new Noeud("R", "Chamas Tacos");
        String lien2 = "N,23::R,Chamas Tacos";
        Lien expResult2 = new Lien(23, 'N', noeudDepart2, noeudArrive2);
        Lien result2 = instance.creationLien(noeudDepart2, lien2);
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
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
        Graph instance = new Graph();
        Noeud noeud1 = new Noeud("V", "Lyon");
        Noeud noeud2 = new Noeud("R", "Les Echets");
        Noeud noeud3 = new Noeud("L", "France Aventures Lyon Fourvière");
        Noeud noeud4 = new Noeud("V", "Villeurbanne");
        
        noeud1.addLien(new Lien(1, 'D', noeud1, noeud2));
        noeud2.addLien(new Lien(1, 'D', noeud2, noeud1));
        noeud2.addLien(new Lien(1, 'D', noeud2, noeud3));
        noeud3.addLien(new Lien(1, 'D', noeud3, noeud2));
        noeud3.addLien(new Lien(1, 'D', noeud3, noeud4));
        noeud4.addLien(new Lien(1, 'D', noeud4, noeud3));
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean expResult3 = false;
        boolean result1 = instance.deuxDistance(noeud1, noeud3);
        boolean result2 = instance.deuxDistance(noeud1, noeud2);
        boolean result3 = instance.deuxDistance(noeud1, noeud4);
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }
}
