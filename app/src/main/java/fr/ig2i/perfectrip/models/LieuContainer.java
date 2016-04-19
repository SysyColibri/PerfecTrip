package fr.ig2i.perfectrip.models;

import java.util.List;

import fr.ig2i.perfectrip.models.Lieu;

/**
 * Created by 10082892 on 19/04/2016.
 */
public class LieuContainer {
    private List<Lieu> results;

    public LieuContainer() {
    }

    public LieuContainer(List<Lieu> results) {
        this.results = results;
    }

    public List<Lieu> getResults() {
        return results;
    }

    public void setResults(List<Lieu> results) {
        this.results = results;
    }
}
