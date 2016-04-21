package fr.ig2i.perfectrip;


import android.widget.Switch;

import java.util.List;

public class GlobalState {
    //Ecran de chargement
    public static double latitude;
    public static double longitude;

    //Ecran d'accueil
    public static String typeLocomotion;
    public static String typeSortie;

    //Ecran choix activités edition
    public static String activitesEnCours;


    public static List<Activite> activites;
    public static String[] activites2 = {"Thibault", "Pierre", "Pierre-Hugues", "Guillaume", "Martin", "Sylvain"};
    public static Switch mSwitchEditionRecapitulation;

    //Ecran choix type de lieux
    public static String lieuEnCours;

    //Call
    public static String corespondantTelephonique;

    public GlobalState() {
    }

    public void peuplerTest() {
        Activite a;
        a = new Activite("Dijon", new Lieu("nom", 100.0, 3.0, 10.1, 20.1, "06486744242"), "Bucheron");
        activites.add(a);
        a = new Activite("Dijon", new Lieu("nom", 100.0, 3.0, 10.1, 20.1, "06486744242"), "Bucheron");
        activites.add(a);
    }
}
