package fr.ig2i.perfectrip.models;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private Double lat;
    private Double lng;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Location() {}

    public Location(Double lat, Double lng, Map<String, Object> additionalProperties) {
        this.lat = lat;
        this.lng = lng;
        this.additionalProperties = additionalProperties;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
