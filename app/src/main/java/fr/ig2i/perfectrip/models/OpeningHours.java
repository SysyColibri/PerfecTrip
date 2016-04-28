package fr.ig2i.perfectrip.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpeningHours {

    private Boolean openNow;
    private List<Object> weekdayText = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public OpeningHours() {}

    public OpeningHours(Boolean openNow, Map<String, Object> additionalProperties, List<Object> weekdayText) {
        this.openNow = openNow;
        this.additionalProperties = additionalProperties;
        this.weekdayText = weekdayText;
    }

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public List<Object> getWeekdayText() {
        return weekdayText;
    }

    public void setWeekdayText(List<Object> weekdayText) {
        this.weekdayText = weekdayText;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
