package fr.ig2i.perfectrip;

import java.util.ArrayList;

public class Activite {

    private String typeActivite;
    private String typeLieu;
    private String nom;
    private ArrayList<Double> localisation;

    public Activite(String typeLieu, String nom, ArrayList<Double> localisation, String typeActivite) {
        this.typeLieu = typeLieu;
        this.nom = nom;
        this.localisation = localisation;
        this.typeActivite = typeActivite;
    }

    public ArrayList<Double> getLocalisation() {
        return localisation;
    }

    public String getNom() {
        return nom;
    }

    public String getTypeLieu() {
        return typeLieu;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    public void setLocalisation(ArrayList<Double> localisation) {
        this.localisation = localisation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTypeLieu(String typeLieu) {
        this.typeLieu = typeLieu;
    }

}
