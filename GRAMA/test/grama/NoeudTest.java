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
public class NoeudTest {
    
    public NoeudTest() {
    }

    /**
     * Test of getTypeLieu method, of class Noeud.
     */
    @Test
    public void testGetTypeLieu() {
        System.out.println("getTypeLieu");
        Noeud instance = null;
        String expResult = "";
        String result = instance.getTypeLieu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomLieu method, of class Noeud.
     */
    @Test
    public void testGetNomLieu() {
        System.out.println("getNomLieu");
        Noeud instance = null;
        String expResult = "";
        String result = instance.getNomLieu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListeLien method, of class Noeud.
     */
    @Test
    public void testGetListeLien() {
        System.out.println("getListeLien");
        Noeud instance = null;
        ArrayList<Lien> expResult = null;
        ArrayList<Lien> result = instance.getListeLien();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of addLien method, of class Noeud.
     */
    @Test
    public void testAddLien() {
        System.out.println("addLien");
        Lien lien = null;
        Noeud instance = null;
        instance.addLien(lien);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherRoute method, of class Noeud.
     */
    @Test
    public void testAfficherRoute() {
        System.out.println("afficherRoute");
        Noeud instance = null;
        instance.afficherRoute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVoisin method, of class Noeud.
     */
    @Test
    public void testGetVoisin() {
        System.out.println("getVoisin");
        Noeud instance = null;
        ArrayList<Noeud> expResult = null;
        ArrayList<Noeud> result = instance.getVoisin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherVoisin method, of class Noeud.
     */
    @Test
    public void testAfficherVoisin_0args() {
        System.out.println("afficherVoisin");
        Noeud instance = null;
        instance.afficherVoisin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherVoisin method, of class Noeud.
     */
    @Test
    public void testAfficherVoisin_String() {
        System.out.println("afficherVoisin");
        String type = "";
        Noeud instance = null;
        instance.afficherVoisin(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Noeud.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Noeud instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Noeud.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Noeud instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Noeud.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Noeud instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
