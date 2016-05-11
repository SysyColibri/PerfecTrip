package fr.ig2i.perfectrip.models;

import fr.ig2i.perfectrip.models.lieu.Lieu;

public class Activite {

    private String typeActivite;
    private String typeLieu;
    private Lieu lieu;

    public Activite(String typeLieu, Lieu lieu, String typeActivite) {
        this.typeLieu = typeLieu;
        this.lieu = lieu;
        this.typeActivite = typeActivite;
    }

    public Lieu getLieu() { return lieu; }

    public void setLieu(Lieu lieu) { this.lieu = lieu; }

    public String getTypeLieu() {
        return typeLieu;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    public void setTypeLieu(String typeLieu) {
        this.typeLieu = typeLieu;
    }

}
