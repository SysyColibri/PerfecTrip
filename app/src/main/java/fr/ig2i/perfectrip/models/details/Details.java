package fr.ig2i.perfectrip.models.details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Details {

    private List<address_components> addressComponents = new ArrayList<address_components>();
    private String adrAddress;
    private String formattedAddress;
    private String formattedPhoneNumber;
    private String icon;
    private String id;
    private String internationalPhoneNumber;
    private String name;
    private String placeId;
    private Double rating;
    private String reference;
    private List<Review> reviews = new ArrayList<Review>();
    private String scope;
    private List<String> types = new ArrayList<String>();
    private String url;
    private Integer userRatingsTotal;
    private Integer utcOffset;
    private String vicinity;
    private String website;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Details() {
    }

    public Details(List<address_components> addressComponents, String adrAddress, String formattedAddress, String formattedPhoneNumber, String icon, String id, String internationalPhoneNumber, String name, String placeId, Double rating, String reference, List<Review> reviews, String scope, List<String> types, String url, Integer userRatingsTotal, Integer utcOffset, String vicinity, String website) {
        this.addressComponents = addressComponents;
        this.adrAddress = adrAddress;
        this.formattedAddress = formattedAddress;
        this.formattedPhoneNumber = formattedPhoneNumber;
        this.icon = icon;
        this.id = id;
        this.internationalPhoneNumber = internationalPhoneNumber;
        this.name = name;
        this.placeId = placeId;
        this.rating = rating;
        this.reference = reference;
        this.reviews = reviews;
        this.scope = scope;
        this.types = types;
        this.url = url;
        this.userRatingsTotal = userRatingsTotal;
        this.utcOffset = utcOffset;
        this.vicinity = vicinity;
        this.website = website;
    }

    public List<address_components> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<address_components> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(String adrAddress) {
        this.adrAddress = adrAddress;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
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

    public String getInternationalPhoneNumber() {
        return internationalPhoneNumber;
    }

    public void setInternationalPhoneNumber(String internationalPhoneNumber) {
        this.internationalPhoneNumber = internationalPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUserRatingsTotal() {
        return userRatingsTotal;
    }

    public void setUserRatingsTotal(Integer userRatingsTotal) {
        this.userRatingsTotal = userRatingsTotal;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}