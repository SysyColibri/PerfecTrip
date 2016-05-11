package fr.ig2i.perfectrip.models.lieu;

import java.util.HashMap;
import java.util.Map;

public class Geometry {

    public Location location;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Geometry(Location location, Map<String, Object> additionalProperties) {
        this.location = location;
        this.additionalProperties = additionalProperties;
    }

    public Geometry() {}

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
