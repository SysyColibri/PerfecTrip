package fr.ig2i.perfectrip.models;

import java.util.ArrayList;

import fr.ig2i.perfectrip.models.lieu.Lieu;

public class LieuContainer {
    private ArrayList<Lieu> results;

    public LieuContainer() {
    }

    public LieuContainer(ArrayList<Lieu> results) {
        this.results = results;
    }

    public ArrayList<Lieu> getResults() {
        return results;
    }

    public void setResults(ArrayList<Lieu> results) {
        this.results = results;
    }
}
