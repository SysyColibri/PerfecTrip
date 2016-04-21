package fr.ig2i.perfectrip.models;

import java.util.ArrayList;
import java.util.List;

import fr.ig2i.perfectrip.models.Lieu;

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
