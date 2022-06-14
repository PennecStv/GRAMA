/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package grama.map;

import grama.Graph;
import grama.Lien;
import grama.Noeud;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Steve Pennec
 */
public class MapTest {
    
    /*** La map de test ***/
    Map map = new Map();
    
    /*** Le graphe de test ***/
    Graph graphe = new Graph();
    
    
    /***  Noeuds et Liens de Test ***/
    Noeud noeud1 = new Noeud("V", "Villeurbanne");
    Noeud noeud2 = new Noeud("R", "MacDonald's");
    Noeud noeud3 = new Noeud("V", "Vénissieux");
    Noeud noeud4 = new Noeud("L", "Aquarium de Lyon");
    
    Lien lien1 = new Lien( 5, 'D', noeud1, noeud2);
    Lien lien2 = new Lien( 5, 'D', noeud2, noeud1);
    Lien lien3 = new Lien(20, 'A', noeud1, noeud3);
    Lien lien4 = new Lien(20, 'A', noeud3, noeud1);
    Lien lien5 = new Lien(15, 'N', noeud3, noeud4);
    Lien lien6 = new Lien(15, 'N', noeud4, noeud3);
    Lien lien7 = new Lien(10, 'N', noeud2, noeud3);
    Lien lien8 = new Lien(10, 'N', noeud3, noeud2);
    
    public MapTest() {
        remplirListe(graphe);
    }

    
    /* ======================================================= */
    /* ===== Méthodes de test: remplir une liste de test ===== */
    /* ======================================================= */
    private void remplirListe(Graph graphe){
        graphe.getListeNoeud().add(noeud1);
        graphe.getListeNoeud().add(noeud2);
        graphe.getListeNoeud().add(noeud3);
        graphe.getListeNoeud().add(noeud4);
        
        graphe.getListeLien().add(lien1);
        graphe.getListeLien().add(lien2);
        graphe.getListeLien().add(lien3);
        graphe.getListeLien().add(lien4);
        graphe.getListeLien().add(lien5);
        graphe.getListeLien().add(lien6);
        graphe.getListeLien().add(lien7);
        graphe.getListeLien().add(lien8);
    }


    /**
     * Test of generateGraphNoeud method, of class Map.
     */
    @Test
    public void testGenerateGraphNoeud() {
        map.generateGraphNoeud(graphe.getListeNoeud());
        
        assertEquals(map.getListeGraphNoeud().size(), graphe.getListeNoeud().size());
        for (int i = 0; i < graphe.getListeNoeud().size(); i++){
            assertEquals(map.getListeGraphNoeud().get(i).getNomLieu(), graphe.getListeNoeud().get(i).getNomLieu());
            assertEquals(map.getListeGraphNoeud().get(i).getTypeLieu(), graphe.getListeNoeud().get(i).getTypeLieu());
        }
    }

    /**
     * Test of generateGraphLien method, of class Map.
     */
    @Test
    public void testGenerateGraphLien() {
        map.generateGraphNoeud(graphe.getListeNoeud());
        map.generateGraphLien(graphe.getListeLien());
        
        boolean verif;
        for (GraphLien mapLien : map.getListeGraphLien()){
            verif = false;
            for (Lien lien : graphe.getListeLien()){
                if (mapLien.getLien().equals(lien))
                    verif = true;
            }
        assertTrue(verif);
        }
    }
    
    
    /**
     * Test of rechercheGraphNoeud method, of class Map.
     */
    @Test
    public void testRechercheGraphNoeud() {
        map.generateGraphNoeud(graphe.getListeNoeud());
        
        Noeud noeudRecherche1 = new Noeud("V", "Villeurbanne");
        Noeud noeudRecherche2 = new Noeud("L", "Aquarium de Lyon");
        Noeud noeudRecherche3 = new Noeud("R", "Burger King");
        
        GraphNoeud expResult1 = map.getListeGraphNoeud().get(0);
        GraphNoeud expResult2 = map.getListeGraphNoeud().get(map.getListeGraphNoeud().size() - 1);
        GraphNoeud expResult3 = null;
        
        GraphNoeud result1 = map.rechercheGraphNoeud(noeudRecherche1);
        GraphNoeud result2 = map.rechercheGraphNoeud(noeudRecherche2);
        GraphNoeud result3 = map.rechercheGraphNoeud(noeudRecherche3);
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }
    
    /**
     * Test of compareCoord method, of class Map.
     */
    @Test
    public void testCompareCoord() {
        map.generateGraphNoeud(graphe.getListeNoeud());
        
        GraphNoeud testNoeud1 = map.getListeGraphNoeud().get(0);
        GraphNoeud testNoeud2 = map.getListeGraphNoeud().get(1);
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        
        boolean result1 = map.compareCoord(testNoeud1, testNoeud2.getPosX(), testNoeud2.getPosY());
        boolean result2 = map.compareCoord(testNoeud2, testNoeud2.getPosX(), testNoeud2.getPosY());
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }
}
