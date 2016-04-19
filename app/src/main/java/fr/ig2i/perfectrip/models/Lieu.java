package fr.ig2i.perfectrip.models;

public class Lieu {

    private String nom;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double note;
    private Double ordrePrix;
    private String numTel;

    public Lieu(String nom, Double ordrePrix, Double note, Double longitude, Double latitude, String numTel) {
        this.nom = nom;
        this.ordrePrix = ordrePrix;
        this.note = note;
        this.longitude = longitude;
        this.latitude = latitude;
        this.numTel = numTel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lieu() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public Double getOrdrePrix() {
        return ordrePrix;
    }

    public void setOrdrePrix(Double ordrePrix) {
        this.ordrePrix = ordrePrix;
    }

    //public String getNumTel() { return numTel; }
    public String getNumTel() { return "06 10 29 28 17"; }

    public void setNumTel(String numTel) { this.numTel = numTel; }
}