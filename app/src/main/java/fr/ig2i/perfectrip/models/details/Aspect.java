package fr.ig2i.perfectrip.models.details;


import java.util.HashMap;
import java.util.Map;


public class Aspect {

    private Integer rating;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Aspect() {
    }

    public Aspect(Integer rating, String type) {
        this.rating = rating;
        this.type = type;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
