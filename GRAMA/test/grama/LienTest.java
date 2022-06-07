/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package grama;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Steve Pennec
 */
public class LienTest {
    
    public LienTest() {
    }

    /**
     * Test of getPonderation method, of class Lien.
     */
    @Test
    public void testGetPonderation() {
        System.out.println("getPonderation");
        Lien instance = null;
        int expResult = 0;
        int result = instance.getPonderation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeRoute method, of class Lien.
     */
    @Test
    public void testGetTypeRoute() {
        System.out.println("getTypeRoute");
        Lien instance = null;
        char expResult = ' ';
        char result = instance.getTypeRoute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartNoeud method, of class Lien.
     */
    @Test
    public void testGetDepartNoeud() {
        System.out.println("getDepartNoeud");
        Lien instance = null;
        Noeud expResult = null;
        Noeud result = instance.getDepartNoeud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArriveNoeud method, of class Lien.
     */
    @Test
    public void testGetArriveNoeud() {
        System.out.println("getArriveNoeud");
        Lien instance = null;
        Noeud expResult = null;
        Noeud result = instance.getArriveNoeud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherSommets method, of class Lien.
     */
    @Test
    public void testAfficherSommets() {
        System.out.println("afficherSommets");
        Lien instance = null;
        instance.afficherSommets();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Lien.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Lien instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
