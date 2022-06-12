/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grama;

import java.io.*;
import java.util.ArrayList;

/**
 * Cette classe correspond au graphe à étudier et ses composants
 * @author Steve Pennec
 */
public class Graph {
    
    /**
     * String servant à récuperer le fichier du graphe
     */
    String recupGraphe = "";
    
    
    /**
     * Correspond à la liste des noeuds du graphe
     */
    private final ArrayList<Noeud> listeNoeud = new ArrayList<>();
    
    /**
     * Correspond à la liste des liens du graphe
     */
    private final ArrayList<Lien> listeLien   = new ArrayList<>();

    /**
     * Correspond à la liste des noeuds de type Villes du graphe
     */
    private final ArrayList<Noeud> listeVilles      = new ArrayList<>();
    
    /**
     * Correspond à la liste des noeuds de type Restaurants du graphe
     */
    private final ArrayList<Noeud> listeRestaurants = new ArrayList<>();
    
    /**
     * Correspond à la liste des noeuds de type Centres de loisir du graphe
     */
    private final ArrayList<Noeud> listeLoisirs     = new ArrayList<>();
    
    /**
     * Correspond à la liste des liens de type Autoroutes du graphe
     */
    private final ArrayList<Lien> listeAutoroutes   = new ArrayList<>();
    
    /**
     * Correspond à la liste des liens de type Routes nationales du graphe
     */
    private final ArrayList<Lien> listeRouteNat     = new ArrayList<>();
    
    /**
     * Correspond à la liste des liens de type Route départementales du graphe
     */
    private final ArrayList<Lien> listeRouteDep     = new ArrayList<>();
    
    //Constructeur
    /**
     * Instancie le graphe
     */
    public Graph() {
        super();
    }
    
    
    
    /* ================================================= */
    /* ===             Méthodes de bases             === */
    /* ================================================= */
    /**
     * Renvoie l'ordre du graphe, soit le nombre de noeuds
     * @return la taille de la liste de noeuds du graphe
     */
    public int ordreGraphe(){
        return this.listeNoeud.size();
    }
    
    /**
     * Renvoie la taille du graphe, soit le nombre de liens
     * @return la taille de la liste de liens du graphe
     */
    public int tailleGraphe(){
        return this.listeLien.size();
    }

    /**
     * Renvoie la liste de noeuds du graphe
     * @return la liste de noeuds
     */
    public ArrayList<Noeud> getListeNoeud() {
        return listeNoeud;
    }

    /**
     * Renvoie la liste de liens du graphe
     * @return la liste de liens
     */
    public ArrayList<Lien> getListeLien() {
        return listeLien;
    }  
    
    /**
     * Renvoie parmis la liste de noeud le noeud qui correspond au nom entré au paramètre
     * @param nom étant le nom du noeud à rechercher
     * @return le noeud recherché, sinon null si pas trouvé
     */
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
     * Lis un fichier et récupère les données de celui-ci
     * @param fichier
     * @return les données du fichier sous format String
     * @throws FileNotFoundException si le fichier n'a pas été trouvé
     * @throws IOException si les données sont incorrects pour être lu
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
     * Permet de créer un noeud
     * @param noeud étant les données du noeud à créer
     * @return un noeud créé selon les données entrées en paramètre
     */
    public Noeud creationNoeud(String noeud){
        String[] donneeNoeud = noeud.split(",");
        Noeud nouvNoeud = new Noeud(donneeNoeud[0].replace("\n", "").replace("\r", ""), donneeNoeud[1]);
        
        return nouvNoeud;
    }
    
    
    /* === Création d'un lien === */
    /**
     * Permet de créer un lien à partir d'un noeud de départ
     * @param noeudDepart étant le noeud de départ des liens
     * @param lien étant les données du lien à créer partant du noeud de départ
     * @return un lien créé selon les données entrées en paramètre
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
     * Permet de créer la liste des noeuds et des liens selon un String reprenant le contenu d'un fichier lu
     * @param listeFichierNoeud étant le String contenant les données d'un fichier
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
     * Permet de créer les listes correspondant à chaque type de noeuds et de liens existants
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
     * affiche tous les noeuds de la liste de noeuds
     */
    @Deprecated
    public void afficherListeNoeud(){
        for (Noeud noeud : listeNoeud){
            System.out.println(noeud);
        }
    }
    
    /**
     * affiche tous les liens de la liste de liens
     */
    @Deprecated
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
     * Permet d'avoir la liste de noeuds ou de liens selon le type entré en paramètre en utilisant la liste correspondante {@link #afficherListe(java.util.ArrayList, java.lang.String)}
     * @param type étant le type de noeud ou de lien voulu
     * @return la liste de noeuds ou de lien selon le type voulu
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
     * Permet d'avoir la liste de noeuds ou de liens selon la liste typée utilisée en paramètre
     * @param liste étant soit une liste de noeuds typée, soit une liste de liens typée
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
     * Renvoie le nombre de noeuds ou de liens selon un type choisi
     * @param categorie étant un type de noeud ou de lien
     * @return le nombre de noeuds ou de liens selon le type choisi
     */
    public String getNombre(String categorie){
        switch(categorie){
            case "Villes":
                return String.valueOf(listeVilles.size());
            default:
                return "";
        }
    }
    
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
     * Permet d'afficher les voisins à un saut d'un nom
     * @param nomNoeud étant le nom du noeud dont on souhaite savoir ses voisins
     */
    @Deprecated
    public void afficherVoisinUnSaut(String nomNoeud){
        Noeud noeud = recherche(nomNoeud);
        noeud.afficherVoisin();
    }

    /**
     * Permet de parcourir les voisins d'un noeud donné
     * @param noeud
     */
    @Deprecated
    public void parcoursVoisin(Noeud noeud){
        for (Lien lien : noeud.getListeLien()){
            lien.getArriveNoeud();
        }
    }
    
    
    /*---------------------------------------------------------*/
    /* === Analyser les éléments du graphe (2 - distances) === */
    /*---------------------------------------------------------*/
    
    /* === Vérification si deux noeuds donnés sont bien à deux distance === */
    /**
     * Permet de savoir si deux noeuds sont à deux distances ou pas, autrement dit qu'il sont réliés en passant par deux liens
     * @param noeud1 étant le premier noeud
     * @param noeud2 étant le second noeud
     * @return true s'ils sont à deux distances, false sinon
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
     * Permet de savoir si une noeud a plus de villes, restaurants et centres de loisirs à de deux distances par rapport à un autre, en utilisant la méthode {@link #compteDeuxDistances(grama.Noeud, grama.Noeud, java.util.ArrayList) }
     * @param noeud1
     * @param noeud2
     * @return une tableau de boolean où chaque indice correspond respectivement au type [villes, restaurants, centres de loisir]
     */
    public boolean[] compareNoeuds(Noeud noeud1, Noeud noeud2){
        
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
     * Permet de savoir si un noeud a plus de deux distances par rapport à un autre selon une liste typée en utilisant la méthode {@link #deuxDistance(grama.Noeud, grama.Noeud) }
     * @param noeud1 étant le premier noeud
     * @param noeud2 étant le second noeud à comparer par rapport au premier
     * @param liste étant une liste typée contenant les noeuds dont on doit savoir s'ils sont à deux distances
     * @return true si le premier noeud a plus de deux distances, sinon false
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
     * Permet de rechercher un noeud à partir d'un nom de noeud
     * @param nomNoeud étant le nom du noeud à rechercher
     * @return le noeud recherché, sinon null si pas trouvé
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
     * Permet de retrouver un lien à partir d'un noeud de départ et d'arrivée
     * @param depart étant le nom du noeud de départ
     * @param arrive étant le nom du noeud d'arrivée
     * @return le lien recherché, sinon null si pas trouvé
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
