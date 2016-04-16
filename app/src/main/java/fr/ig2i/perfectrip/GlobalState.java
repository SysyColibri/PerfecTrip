package fr.ig2i.perfectrip;


public class GlobalState {
    //Ecran de chargement
    public static double latitude;
    public static double longitude;

    //Ecran d'accueil
    public static String typeLocomotion;
    public static String typeSortie;

    //Ecran choix activités edition
    public static String activitesEnCours;
    //public static List<Activite> activites; JE PEUX REMPLACER LIST PAR STRING[] ?
    public static String[] activites = {"Thibault", "Pierre", "Pierre-Hugues", "Guillaume", "Martin", "Sylvain"};

    //Ecran choix type de lieux
    public static String lieuEnCours;

    public GlobalState() {//A QUOI CA SERT?
    }
}
