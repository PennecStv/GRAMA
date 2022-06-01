/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Steve Pennec
 */
public class Graph {
    
    String recupGraphe = "";
    
    private final ArrayList<Noeud> listeNoeud = new ArrayList<>();
    private final ArrayList<Lien> listeLien   = new ArrayList<>();

    private final ArrayList<Noeud> listeVilles      = new ArrayList<>();
    private final ArrayList<Noeud> listeRestaurants = new ArrayList<>();
    private final ArrayList<Noeud> listeLoisirs     = new ArrayList<>();
    private final ArrayList<Lien> listeAutoroutes   = new ArrayList<>();
    private final ArrayList<Lien> listeRouteNat     = new ArrayList<>();
    private final ArrayList<Lien> listeRouteDep     = new ArrayList<>();
    
    private final String[] typeNoeud = {"V", "R", "L"};
    private final char[] typeLien    = {'A', 'N', 'D'};
    
    //Constructeur
    public Graph(/*ArrayList<Noeud> listeNoeud*/) {
        super();
        //this.listeNoeud = listeNoeud;
    }
    
    
    
    /* ================================================= */
    /* ===             Méthodes de bases             === */
    /* ================================================= */
    public int ordreGraphe(){
        return this.listeNoeud.size();
    }
    
    
    public int tailleGraphe(){
        return this.listeLien.size();
    }

    public ArrayList<Noeud> getListeNoeud() {
        return listeNoeud;
    }

    public ArrayList<Lien> getListeLien() {
        return listeLien;
    }  
    
    public Noeud getNoeud(String nom){
        int i = 0;
        Noeud noeud = null;
        
        while (i < listeNoeud.size() && noeud == null){
            Noeud Testnoeud = listeNoeud.get(i);
            if (Testnoeud.getNomLieu().equals(nom)){
                noeud = Testnoeud;
            }
        }
        
        return noeud;
    }
    
    
    /* ================================================= */
    /* === Lecture du fichier et création des listes === */
    /* ================================================= */
    
    /* === Lecture d'un fichier CSV === */
    public String ouvrirGraphe() throws FileNotFoundException, IOException{
        File graphFile = new File("Graphe.csv");
        
        try (InputStream lecture = new FileInputStream(graphFile)) {
            int unsignedByte;
 
            if (graphFile.exists() && graphFile.isFile()) {
                while ((unsignedByte = lecture.read()) > -1){
                    recupGraphe += (char) unsignedByte;
                }
            }    
        } catch (IOException ex) {
            System.out.println("Erreur de lecture du fichier");
        }
        
        return recupGraphe;
    }
    
    
    /* === Création d'un noeud === */
    public Noeud creationNoeud(String noeud){
        String[] donneeNoeud = noeud.split(",");
        Noeud nouvNoeud = new Noeud(donneeNoeud[0].replace("\n", "").replace("\r", ""), donneeNoeud[1]);
        
        return nouvNoeud;
    }
    
    
    /* === Création d'un lien === */
    public Lien creationLien(Noeud noeudDepart, String lien){
        String[] lienEtArrive = lien.split("::");
        
        String[] donneeLien = lienEtArrive[0].split(",");
        
        char typeLien = donneeLien[0].charAt(0);
        int kilometrage = Integer.parseInt(donneeLien[1]);
        
        Noeud noeudArrivee = creationNoeud(lienEtArrive[1]);
        
        Lien nouvLien = new Lien(kilometrage, typeLien, noeudDepart, noeudArrivee);
        
        return nouvLien;
    }
    
    /* === Création de la liste de Noeud et de Lien selon le fichier CSV lu === */
    public void creationListe(String listeFichierNoeud){
        String[] sepLigne = listeFichierNoeud.split(";;");
        
        for (String s : sepLigne){
            String[] sepNoeudLien = s.split(":", 2);
            String stringNoeud = sepNoeudLien[0];
            String stringListeLien = sepNoeudLien[1];
            
            Noeud noeud = creationNoeud(stringNoeud);
            listeNoeud.add(noeud);
            
            String[] donneeLien = stringListeLien.split(";");
            for (String stringLien : donneeLien){
                Lien lien = creationLien(noeud, stringLien);
                listeLien.add(lien);
                noeud.addLien(lien);
            }
        }     
    }
    
    
    public void creationListeTypee(){
        String typeSommets;
        char typeRoute;
        
        for (Noeud noeud : listeNoeud){
            typeSommets = noeud.getTypeLieu();
            switch(typeSommets){
                case "V":
                    listeVilles.add(noeud);
                    break;
                case "R":
                    listeRestaurants.add(noeud);
                    break;
                case "L":
                    listeLoisirs.add(noeud);
                    break;
                default:
                    break;
            }
        }
        
        for (Lien lien : listeLien){
            typeRoute = lien.getTypeRoute();
            switch(typeRoute){
                case 'A':
                    listeAutoroutes.add(lien);
                    break;
                case 'N':
                    listeRouteNat.add(lien);
                    break;
                case 'D':
                    listeRouteDep.add(lien);
                    break;
                default:
                    break;
            }
        }
    }
    
    
    /*** === Affichage === ***/
    public void afficherListeNoeud(){
        for (Noeud noeud : listeNoeud){
            System.out.println(noeud);
        }
    }
    

    public void afficherListeLien(){
        for (Lien lien : listeLien){
            System.out.println(lien.toString());
        }
    }
    
    
    /* ================================================== */
    /* ======= Interroger le graphe-MAP: Méthodes ======= */
    /* ================================================== */

    
    /* === Analyser les éléments du graphe (0-distances) === */
    
    public void listerCategorie(String type){
        switch(type){
            case "V":
                System.out.println("\nCatégorie: Ville");
                afficherListe(listeVilles);
                break;
                
            case "R":
                System.out.println("\nCatégorie: Restaurant");
                afficherListe(listeRestaurants);
                break;
                
            case "L":
                System.out.println("\nCatégorie: Lieu de loisir");
                afficherListe(listeLoisirs);
                break;
                
            case "A":
                System.out.println("\nCatégorie: Autoroute");
                afficherListe(listeAutoroutes);
                break;
                
            case "N":
                System.out.println("\nCatégorie: Route nationale");
                afficherListe(listeRouteNat);
                break;
                
            case "D":
                System.out.println("\nCatégorie: Route départementale");
                afficherListe(listeRouteDep);
                break;
                
            default:
                System.out.println("Type non reconnu...");
                break;
        }
    }
    
    public void afficherListe(ArrayList<?> liste){
        for (int i = 0; i < liste.size(); i++){
            System.out.println(liste.get(i));
        }
    }
    
    public void afficherNombre(){
        System.out.println("Nombre de villes : " + listeVilles.size());
        System.out.println("\nNombre de restaurants : " + listeRestaurants.size());
        System.out.println("\nNombre de centres de loisir : " + listeLoisirs.size());
        System.out.println("\nNombre d'autoroutes : " + listeAutoroutes.size() / 2);
        System.out.println("\nNombre de routes nationales : " + listeRouteNat.size() / 2);
        System.out.println("\nNombre de routes départementales : " + listeRouteDep.size() / 2);
    }
    
    
    public void afficherVoisinUnSaut(String nomNoeud){
        Noeud noeud = recherche(nomNoeud);
        noeud.afficherVoisin();
    }
    
    public boolean deuxDistance(String nomNoeud1, String nomNoeud2){
        Noeud noeud1 = recherche(nomNoeud1);
        Noeud noeud2 = recherche(nomNoeud2);
        
        for (Noeud tempNoeud : noeud1.getVoisin()){
            if (noeud2.getVoisin().contains(tempNoeud)){
                //System.out.println(nomNoeud1 + " et " + nomNoeud2 + " sont à deux distance.");
                return true;
            }
        }
        //System.out.println(nomNoeud1 + " et " + nomNoeud2 + " ne sont pas à deux distance.");
        return false;
    }
    
    
    public void parcoursVoisin(Noeud noeud){
        for (Lien lien : noeud.getListeLien()){
            lien.getArriveNoeud();
        }
    }
    
    
    public Noeud recherche(String nomNoeud){
        boolean trouve = false;
        int i = 0;
        Noeud noeud = null;
        
        while (!trouve && i < listeNoeud.size()){
            noeud = listeNoeud.get(i);
            if (noeud.getNomLieu().toLowerCase().equals(nomNoeud.toLowerCase())){
                trouve = true;
            }
            i++;
        }
        
        if (trouve)
            return noeud;
        else
            return null;
    }
    
    public Lien recherche(String depart, String arrive){
        boolean trouve = false;
        int i = 0;
        Lien lien = null;
        
        while (!trouve && i < listeLien.size()){
            lien = listeLien.get(i);
            if (lien.getDepartNoeud().equals(recherche(depart)) && lien.getArriveNoeud().equals(recherche(arrive))){
                trouve = true;
            }
            i++;
        }
        
        if (trouve)
            return lien;
        else
            return null;
    }
    
    
    
    public void compareVilles(String nomNoeud1, String nomNoeud2){
        Noeud noeud1 = recherche(nomNoeud1);
        Noeud noeud2 = recherche(nomNoeud2);
        
        if (noeud1.getTypeLieu().equals("V") && noeud2.getTypeLieu().equals("V")){
            
            if (compteDeuxDistances(nomNoeud1, nomNoeud2, listeVilles)){
                System.out.println(nomNoeud1 + " est plus OUVERT que " + nomNoeud2);
            } else {
                System.out.println(nomNoeud1 + " est moins OUVERT que " + nomNoeud2);
            }
            
            if (compteDeuxDistances(nomNoeud1, nomNoeud2, listeRestaurants)){
                System.out.println(nomNoeud1 + " est plus GASTRONOMIQUE que " + nomNoeud2);
            } else {
                System.out.println(nomNoeud1 + " est moins GASTRONOMIQUE que " + nomNoeud2);
            }
            
            if (compteDeuxDistances(nomNoeud1, nomNoeud2, listeLoisirs)){
                System.out.println(nomNoeud1 + " est plus CULTURELLE que " + nomNoeud2);
            } else {
                System.out.println(nomNoeud1 + " est moins CULTURELLE que " + nomNoeud2);
            }    
        }
    }
    
    public boolean compteDeuxDistances(String nomNoeud1, String nomNoeud2, ArrayList<Noeud> liste){
        int nbNoeud1 = 0;
        int nbNoeud2 = 0;
        
        for (Noeud noeud : liste){
                if (deuxDistance(nomNoeud1, noeud.getNomLieu())){
                    nbNoeud1++;
                }
                if (deuxDistance(nomNoeud2, noeud.getNomLieu())){
                    nbNoeud2++;
                }
            }
        return (nbNoeud1 > nbNoeud2);
    }
}
