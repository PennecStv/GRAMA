/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package grama.map;

import grama.Noeud;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Steve Pennec
 */
public class MapTest {
    
    public MapTest() {
    }

    /**
     * Test of addTypeNoeud method, of class Map.
     */
    @Test
    public void testAddTypeNoeud() {
        System.out.println("addTypeNoeud");
        String type = "";
        Map instance = new Map();
        instance.addTypeNoeud(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTypeNoeud method, of class Map.
     */
    @Test
    public void testRemoveTypeNoeud() {
        System.out.println("removeTypeNoeud");
        String type = "";
        Map instance = new Map();
        instance.removeTypeNoeud(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTypeLien method, of class Map.
     */
    @Test
    public void testAddTypeLien() {
        System.out.println("addTypeLien");
        String type = "";
        Map instance = new Map();
        instance.addTypeLien(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTypeLien method, of class Map.
     */
    @Test
    public void testRemoveTypeLien() {
        System.out.println("removeTypeLien");
        String type = "";
        Map instance = new Map();
        instance.removeTypeLien(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of compareCoord method, of class Map.
     */
    @Test
    public void testCompareCoord() {
        System.out.println("compareCoord");
        GraphNoeud noeud = null;
        int otherPosX = 0;
        int otherPosY = 0;
        Map instance = new Map();
        boolean expResult = false;
        boolean result = instance.compareCoord(noeud, otherPosX, otherPosY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechercheGraphNoeud method, of class Map.
     */
    @Test
    public void testRechercheGraphNoeud() {
        System.out.println("rechercheGraphNoeud");
        Noeud noeudRecherche = null;
        Map instance = new Map();
        GraphNoeud expResult = null;
        GraphNoeud result = instance.rechercheGraphNoeud(noeudRecherche);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
