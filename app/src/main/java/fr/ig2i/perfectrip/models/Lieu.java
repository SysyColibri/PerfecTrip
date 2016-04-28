package fr.ig2i.perfectrip.models;

import java.util.ArrayList;
import java.util.List;

public class Lieu {

    private Geometry geometry;
    private String icon;
    private String id;
    private String name;
    private List<Photo> photos = new ArrayList<Photo>();
    private String placeId;
    private String reference;
    private String scope;
    private List<String> types = new ArrayList<String>();
    private String vicinity;
    private OpeningHours openingHours;
    private Double rating;
    private Integer priceLevel;
    private String numTel = "0648674242";

    public Lieu() {}

    public Lieu(Geometry geometry, String id, String icon, String name, List<Photo> photos, String placeId, String reference, String scope, String vicinity, OpeningHours openingHours, List<String> types, Double rating, Integer priceLevel) {
        this.geometry = geometry;
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.photos = photos;
        this.placeId = placeId;
        this.reference = reference;
        this.scope = scope;
        this.vicinity = vicinity;
        this.openingHours = openingHours;
        this.types = types;
        this.rating = rating;
        this.priceLevel = priceLevel;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(Integer priceLevel) {
        this.priceLevel = priceLevel;
    }
}