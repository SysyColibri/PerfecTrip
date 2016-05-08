package fr.ig2i.perfectrip.models.details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Review {

    private List<Aspect> aspects = new ArrayList<Aspect>();
    private String authorName;
    private String authorUrl;
    private String language;
    private Integer rating;
    private String text;
    private Integer time;
    private String profilePhotoUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Review() {
    }

    public Review(List<Aspect> aspects, String authorName, String authorUrl, String language, Integer rating, String text, Integer time, String profilePhotoUrl) {
        this.aspects = aspects;
        this.authorName = authorName;
        this.authorUrl = authorUrl;
        this.language = language;
        this.rating = rating;
        this.text = text;
        this.time = time;
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public List<Aspect> getAspects() {
        return aspects;
    }

    public void setAspects(List<Aspect> aspects) {
        this.aspects = aspects;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
