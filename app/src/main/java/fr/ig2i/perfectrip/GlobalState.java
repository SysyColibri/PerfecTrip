package fr.ig2i.perfectrip;


import android.widget.Switch;

import java.util.ArrayList;

import fr.ig2i.perfectrip.models.Activite;

public class GlobalState {
    //Ecran de chargement
    public static double latitude;
    public static double longitude;
    public static double altitude;
    public static double accuracy;

    //Ecran d'accueil
    public static String typeLocomotion;
    public static String typeSortie;

    //Ecran choix activités edition
    public static String activitesEnCours;
    public static ArrayList<Activite> activites = new ArrayList<>();

    public static Switch mSwitchEditionRecapitulation;

    //Ecran choix type de lieux
    public static String lieuEnCours;

    public GlobalState() {
    }
}
