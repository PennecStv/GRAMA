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
    
    //Constructeur
    /**
     * 
     */
    public Graph() {
        super();
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
    /**
     * 
     * @param fichier
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public String ouvrirGraphe(String fichier) throws FileNotFoundException, IOException{
        File graphFile = new File(fichier);
        
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
    /**
     * 
     * @param noeud
     * @return 
     */
    public Noeud creationNoeud(String noeud){
        String[] donneeNoeud = noeud.split(",");
        Noeud nouvNoeud = new Noeud(donneeNoeud[0].replace("\n", "").replace("\r", ""), donneeNoeud[1]);
        
        return nouvNoeud;
    }
    
    
    /* === Création d'un lien === */
    /**
     * 
     * @param noeudDepart
     * @param lien
     * @return 
     */
    public Lien creationLien(Noeud noeudDepart, String lien){
        String[] lienEtArrive = lien.split("::");
        
        String[] donneeLien = lienEtArrive[0].split(",");
        
        char typeLien = donneeLien[0].charAt(0);
        int kilometrage = Float.valueOf(donneeLien[1]).intValue();
        
        Noeud noeudArrivee = creationNoeud(lienEtArrive[1]);
        
        Lien nouvLien = new Lien(kilometrage, typeLien, noeudDepart, noeudArrivee);
        
        return nouvLien;
    }
    
    /* === Création de la liste de Noeud et de Lien selon le fichier CSV lu === */
    /**
     * 
     * @param listeFichierNoeud 
     */
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
    
    
    /* === Création des listes des noeuds et des liens typés === */
    /**
     * 
     */
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
    /**
     * 
     */
    public void afficherListeNoeud(){
        for (Noeud noeud : listeNoeud){
            System.out.println(noeud);
        }
    }
    
    /**
     * 
     */
    public void afficherListeLien(){
        for (Lien lien : listeLien){
            System.out.println(lien.toString());
        }
    }
    
    
    
    /* ================================================== */
    /* ======= Interroger le graphe-MAP: Méthodes ======= */
    /* ================================================== */

    /*---------------------------------------------------------*/
    /* === Analyser les éléments du graphe (0 - distances) === */
    /*---------------------------------------------------------*/
    
    /* === Retourne un String contenant la liste de noeuds ou de liens selon la catégorie === */
    /**
     * 
     * @param type
     * @return 
     */
    public String listerCategorie(String type){
        String texteListe = "";
        
        switch(type){
            case "V":
                texteListe += "\nCatégorie: Ville \n" + afficherListe(listeVilles, texteListe);
                break;
                
            case "R":
                texteListe += "\nCatégorie: Restaurant \n" + afficherListe(listeRestaurants, texteListe);
                break;
                
            case "L":
                texteListe += "\nCatégorie: Lieu de loisir \n" + afficherListe(listeLoisirs, texteListe);
                break;
                
            case "A":
                texteListe += "\nCatégorie: Autoroute \n" + afficherListe(listeAutoroutes, texteListe);
                break;
                
            case "N":
                texteListe += "\nCatégorie: Route nationale \n" + afficherListe(listeRouteNat, texteListe);
                break;
                
            case "D":
                texteListe += "\nCatégorie: Route départementale \n" + afficherListe(listeRouteDep, texteListe);
                break;
                
            default:
                texteListe += "Type non reconnu...";
                break;
        }
        
        return texteListe;
    }
    
    
    /* === Parcours de la liste la renvoie sous format String === */
    /**
     * 
     * @param liste
     * @param texte
     * @return 
     */
    public String afficherListe(ArrayList<?> liste, String texte){
        for (int i = 0; i < liste.size(); i++){
            texte += liste.get(i) + "\n";
        }
        return texte;
    }
    
    
    /* === Renvoie la taille d'une liste selon la catégorie sous format String === */
    /**
     * 
     * @param categorie
     * @return 
     */
    public String afficherNombre(String categorie){
        switch(categorie){
            case "Villes":
                return String.valueOf(listeVilles.size());
                
            case "Restaurants":
                return String.valueOf(listeRestaurants.size());
                
            case "Centres de loisir":
                return String.valueOf(listeLoisirs.size());
            
            case "Tous les lieux":
                return String.valueOf(listeVilles.size() + listeRestaurants.size() + listeLoisirs.size());
                
            case "Autoroutes":
                return String.valueOf(listeAutoroutes.size() / 2);
                
            case "Routes nationales":
                return String.valueOf(listeRouteNat.size() / 2);
                
            case "Routes départementales":
                return String.valueOf(listeRouteDep.size() / 2);
            
            case "Toutes les routes":
                return String.valueOf((listeAutoroutes.size() + listeRouteNat.size() + listeRouteDep.size()) / 2);
                
            default:
                return "";
        }
    }
    
    
    
    /*---------------------------------------------------------*/
    /* === Analyser les éléments du graphe (1 - distances) === */
    /*---------------------------------------------------------*/
    /**
     * 
     * @param nomNoeud 
     */
    public void afficherVoisinUnSaut(String nomNoeud){
        Noeud noeud = recherche(nomNoeud);
        noeud.afficherVoisin();
    }
    
    
    
    /*---------------------------------------------------------*/
    /* === Analyser les éléments du graphe (2 - distances) === */
    /*---------------------------------------------------------*/
    
    /* === Vérification si deux noeuds donnés sont bien à deux distance === */
    /**
     * 
     * @param noeud1
     * @param noeud2
     * @return 
     */
    public boolean deuxDistance( Noeud noeud1, Noeud noeud2){
        
        for (Noeud tempNoeud : noeud1.getVoisin()){
            if (noeud2.getVoisin().contains(tempNoeud)){
                return true;
            }
        }
        return false;
    }
    
    
    
    /*-----------------------------------------------------------*/
    /* === Analyser les éléments du graphe (2>= - distances) === */
    /*-----------------------------------------------------------*/
    /**
     * 
     * @param noeud1
     * @param noeud2
     * @return 
     */
    public boolean[] compareVilles(Noeud noeud1, Noeud noeud2){
        
        boolean[] result = new boolean[3];
        
        //if (noeud1.getTypeLieu().equals("V") && noeud2.getTypeLieu().equals("V")){
            
            result[0] = compteDeuxDistances(noeud1, noeud2, listeVilles);
            
            result[1] = compteDeuxDistances(noeud1, noeud2, listeRestaurants);
            
            result[2] = compteDeuxDistances(noeud1, noeud2, listeLoisirs);
        //}
        
        return result;
    }
    
    
    /* === Compte le nombre de noeuds à distance des deux noeuds entrés en paramètre ===
       === et vérifie si le premier en a plus que le second                          === */
    /**
     * 
     * @param noeud1
     * @param noeud2
     * @param liste
     * @return 
     */
    public boolean compteDeuxDistances(Noeud noeud1, Noeud noeud2, ArrayList<Noeud> liste){
        int nbNoeud1 = 0;
        int nbNoeud2 = 0;
        
        for (Noeud noeud : liste){
                if (deuxDistance(noeud1, noeud)){
                    nbNoeud1++;
                }
                if (deuxDistance(noeud2, noeud)){
                    nbNoeud2++;
                }
            }
        return (nbNoeud1 > nbNoeud2);
    }
    
    
    
    
    /* ======================================================== */
    /* ======= Autres: Méthodes utiles à l'exploitation ======= */
    /* ======================================================== */
    /**
     * 
     * @param nomNoeud
     * @return 
     */
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
    
    /**
     * 
     * @param depart
     * @param arrive
     * @return 
     */
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
}
