package fr.ig2i.perfectrip.models;

import fr.ig2i.perfectrip.models.details.Details;


public class DetailsContainer {
    private Details result;

    public DetailsContainer() {
    }

    public DetailsContainer(Details result) {
        this.result = result;
    }

    public Details getResults() {
        return result;
    }

    public void setResults(Details result) {
        this.result = result;
    }
}

