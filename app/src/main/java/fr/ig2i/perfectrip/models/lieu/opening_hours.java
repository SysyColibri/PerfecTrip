package fr.ig2i.perfectrip.models.lieu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class opening_hours {

    private Boolean open_now;
    private List<Object> weekdayText = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public opening_hours() {}

    public opening_hours(Boolean openNow, Map<String, Object> additionalProperties, List<Object> weekdayText) {
        this.open_now = openNow;
        this.additionalProperties = additionalProperties;
        this.weekdayText = weekdayText;
    }

    public Boolean getOpenNow() {
        return open_now;
    }

    public void setOpenNow(Boolean openNow) {
        this.open_now = openNow;
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
