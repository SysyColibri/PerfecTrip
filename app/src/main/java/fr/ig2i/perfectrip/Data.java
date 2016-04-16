package fr.ig2i.perfectrip;

import android.util.Log;

public class Data {
    GlobalState gs = new GlobalState();
    protected static final String TAG = "Data Liste Possibilités";

    public static String[] romantiqueCadeau = new String[]{
            "Agence de voyages",
            "Animalerie",
            "Bijouterie",
            "Boulangerie",
            "Fleuriste",
            "Galerie marchande",
            "Institut de beauté",
            "Librairie",
            "Magasin",
            "Magasin d’alcool",
            "Magasin d’électronique",
            "Magasin de chaussure",
            "Magasin de meubles",
            "Magasin de produit de maison",
            "Magasin de vêtements",
            "Parc d'attractions",
            "Salon de beauté",
            "Spa"};

    public static String[] romantiqueRepas = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    public static String[] romantiqueSortie = new String[]{
            "Bar",
            "Boite de nuit",
            "Bowling",
            "Casino",
            "Cinéma",
            "Galerie d’art",
            "Galerie marchande",
            "Magasin d’électronique",
            "Magasin de vêtements",
            "Musée",
            "Parc",
            "Parc d'attractions",
            "Stade",
            "Zoo"};

    public static String[] romantiqueHébergement = new String[]{
            "Camping",
            "Hébergement"};

    public static String[] amisCadeau = new String[]{
            "Agence de voyages",
            "Bijouterie",
            "Boulangerie",
            "Epicerie ou supermarché",
            "Fleuriste",
            "Galerie marchande",
            "Institut de beauté",
            "Librairie",
            "Magasin",
            "Magasin d’alcool",
            "Magasin d’électronique",
            "Magasin de chaussure",
            "Magasin de meubles",
            "Magasin de produit de maison",
            "Magasin de vélo",
            "Magasin de vêtements",
            "Parc d'attractions",
            "Salon de beauté",
            "Spa",
            "Stade",
            "Supérette"};

    public static String[] amisRepas = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    public static String[] amisSortie = new String[]{
            "Bar",
            "Boite de nuit",
            "Bowling",
            "Casino",
            "Cinéma",
            "Galerie d’art",
            "Galerie marchande",
            "Magasin d’électronique",
            "Magasin de vêtements",
            "Musée",
            "Parc",
            "Parc d'attractions",
            "Stade",
            "Zoo"};

    public static String[] amisHébergement = new String[]{
            "Camping",
            "Hébergement"};

    public static String[] familleCadeau = new String[]{
            "Agence de voyages",
            "Bijouterie",
            "Boulangerie",
            "Fleuriste",
            "Galerie marchande",
            "Institut de beauté",
            "Librairie",
            "Magasin",
            "Magasin d’alcool",
            "Magasin d’électronique",
            "Magasin de chaussure",
            "Magasin de meubles",
            "Magasin de produit de maison",
            "Magasin de vélo",
            "Magasin de vêtements",
            "Parc d'attractions",
            "Salon de beauté",
            "Spa",
            "Stade"};

    public static String[] familleRepas = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    public static String[] familleSortie = new String[]{
            "Bar",
            "Boite de nuit",
            "Bowling",
            "Casino",
            "Cinéma",
            "Galerie d’art",
            "Galerie marchande",
            "Magasin d’électronique",
            "Magasin de vêtements",
            "Musée",
            "Parc",
            "Parc d'attractions",
            "Stade",
            "Zoo"};

    public static String[] familleHébergement = new String[]{
            "Camping",
            "Hébergement"};

    public static String[] autres = new String[]{
            "Aéroport",
            "Agence de voyages",
            "Banque",
            "Bar",
            "Bibliothèque",
            "Bijouterie",
            "Blanchisserie",
            "Boite de nuit",
            "Boulangerie",
            "Bowling",
            "Bureau de poste",
            "Café",
            "Camping",
            "Casino",
            "Cinéma",
            "Distributeur d’argent",
            "Emplacement camping car",
            "Epicerie ou supermarché",
            "Fleuriste",
            "Galerie d’art",
            "Galerie marchande",
            "Hôpital",
            "Institut de beauté",
            "Lavage de voiture",
            "Librairie",
            "Livraison de repas",
            "Location de films",
            "Location de voiture",
            "Magasin",
            "Magasin d’alcool",
            "Magasin d’électronique",
            "Magasin de chaussure",
            "Magasin de meubles",
            "Magasin de produit de maison",
            "Magasin de vélo",
            "Magasin de vêtements",
            "Musée",
            "Parc",
            "Parc d'attractions",
            "Parking",
            "Pharmacie",
            "Police",
            "Repas à emporter",
            "Restaurant",
            "Salon de beauté",
            "Spa",
            "Stade",
            "Station de bus",
            "Station de métro",
            "Station de train",
            "Station de transit",
            "Station de vélo",
            "Station-essence",
            "Supérette",
            "Supermarché",
            "Zoo"};

    String lieuRequetteApi;
    public String getLieu(String lieuEnCours){
        switch (lieuEnCours){
            case "Aéroport":
                lieuRequetteApi = "airport";
                break;
            case "Agence d’assurance":
                lieuRequetteApi = "insurance_agency";
                break;
            case "Agence de voyages":
                lieuRequetteApi = "travel_agency";
                break;
            case "Agence imobilière":
                lieuRequetteApi = "real_estate_agency";
                break;
            case "Ambassade":
                lieuRequetteApi = "embassy";
                break;
            case "Animalerie":
                lieuRequetteApi = "pet_store";
                break;
            case "Aquarium":
                lieuRequetteApi = "aquarium";
                break;
            case "Banque":
                lieuRequetteApi = "bank";
                break;
            case "Bar":
                lieuRequetteApi = "bar";
                break;
            case "Bâtiment de l'administration public":
                lieuRequetteApi = "local_government_office";
                break;
            case "Bibliothèque":
                lieuRequetteApi = "library";
                break;
            case "Bijouterie":
                lieuRequetteApi = "jewelry_store";
                break;
            case "Blanchisserie":
                lieuRequetteApi = "laundry";
                break;
            case "Boite de nuit":
                lieuRequetteApi = "night_club";
                break;
            case "Boulangerie":
                lieuRequetteApi = "bakery";
                break;
            case "Bowling":
                lieuRequetteApi = "bowling_alley";
                break;
            case "Bureau de poste":
                lieuRequetteApi = "post_office";
                break;
            case "Cabinet d’avocat":
                lieuRequetteApi = "lawyer";
                break;
            case "Café":
                lieuRequetteApi = "cafe";
                break;
            case "Camping":
                lieuRequetteApi = "campground";
                break;
            case "Caserne de pompier":
                lieuRequetteApi = "fire_station";
                break;
            case "Casino":
                lieuRequetteApi = "casino";
                break;
            case "Cimetière":
                lieuRequetteApi = "cemetery";
                break;
            case "Cinéma":
                lieuRequetteApi = "movie_theater";
                break;
            case "Clinique vétérinaire":
                lieuRequetteApi = "veterinary_care";
                break;
            case "Comptable":
                lieuRequetteApi = "accounting";
                break;
            case "Concessionnaire":
                lieuRequetteApi = "car_dealer";
                break;
            case "Couvreur":
                lieuRequetteApi = "roofing_contractor";
                break;
            case "Dentiste":
                lieuRequetteApi = "dentist";
                break;
            case "Distributeur d’argent":
                lieuRequetteApi = "atm";
                break;
            case "Docteur":
                lieuRequetteApi = "doctor";
                break;
            case "Ecole":
                lieuRequetteApi = "school";
                break;
            case "Eglise":
                lieuRequetteApi = "church";
                break;
            case "Electricien":
                lieuRequetteApi = "electrician";
                break;
            case "Emplacement camping car":
                lieuRequetteApi = "rv_park";
                break;
            case "Entreprise de déménagement":
                lieuRequetteApi = "moving_company";
                break;
            case "Epicerie ou supermarché":
                lieuRequetteApi = "grocery_or_supermarket";
                break;
            case "Fleuriste":
                lieuRequetteApi = "florist";
                break;
            case "Galerie d’art":
                lieuRequetteApi = "art_gallery";
                break;
            case "Galerie marchande":
                lieuRequetteApi = "shopping_mall";
                break;
            case "Garage":
                lieuRequetteApi = "car_repair";
                break;
            case "Hébergement":
                lieuRequetteApi = "lodging";
                break;
            case "Hôpital":
                lieuRequetteApi = "hospital";
                break;
            case "Institut de beauté":
                lieuRequetteApi = "hair_care";
                break;
            case "Lavage de voiture":
                lieuRequetteApi = "car_wash";
                break;
            case "Librairie":
                lieuRequetteApi = "book_store";
                break;
            case "Lieux de stockage":
                lieuRequetteApi = "storage";
                break;
            case "Livraison de repas":
                lieuRequetteApi = "meal_delivery";
                break;
            case "Location de films":
                lieuRequetteApi = "movie_rental";
                break;
            case "Location de voiture":
                lieuRequetteApi = "car_rental";
                break;
            case "Magasin":
                lieuRequetteApi = "store";
                break;
            case "Magasin d’alcool":
                lieuRequetteApi = "liquor_store";
                break;
            case "Magasin d’électronique":
                lieuRequetteApi = "electronics_store";
                break;
            case "Magasin de chaussure":
                lieuRequetteApi = "shoe_store";
                break;
            case "Magasin de meubles":
                lieuRequetteApi = "furniture_store";
                break;
            case "Magasin de produit de maison":
                lieuRequetteApi = "home_goods_store";
                break;
            case "Magasin de vélo":
                lieuRequetteApi = "bicycle_store";
                break;
            case "Magasin de vêtements":
                lieuRequetteApi = "clothing_store";
                break;
            case "Mairie":
                lieuRequetteApi = "city_hall";
                break;
            case "Maison funéraire":
                lieuRequetteApi = "funeral_home";
                break;
            case "Mosqué":
                lieuRequetteApi = "mosque";
                break;
            case "Musée":
                lieuRequetteApi = "museum";
                break;
            case "Parc":
                lieuRequetteApi = "park";
                break;
            case "Parc d'attractions":
                lieuRequetteApi = "amusement_park";
                break;
            case "Parking":
                lieuRequetteApi = "parking";
                break;
            case "Peintre":
                lieuRequetteApi = "painter";
                break;
            case "Pharmacie":
                lieuRequetteApi = "pharmacy";
                break;
            case "Physiothérapeute":
                lieuRequetteApi = "physiotherapist";
                break;
            case "Plombier":
                lieuRequetteApi = "plumber";
                break;
            case "Police":
                lieuRequetteApi = "police";
                break;
            case "Quincaillerie":
                lieuRequetteApi = "hardware_store";
                break;
            case "Repas à emporter":
                lieuRequetteApi = "meal_takeaway";
                break;
            case "Restaurant":
                lieuRequetteApi = "restaurant";
                break;
            case "Salle de gymnastique":
                lieuRequetteApi = "gym";
                break;
            case "Salon de beauté":
                lieuRequetteApi = "beauty_salon";
                break;
            case "Serrurier":
                lieuRequetteApi = "locksmith";
                break;
            case "Spa":
                lieuRequetteApi = "spa";
                break;
            case "Stade":
                lieuRequetteApi = "stadium";
                break;
            case "Station de bus":
                lieuRequetteApi = "bus_station";
                break;
            case "Station de métro":
                lieuRequetteApi = "subway_station";
                break;
            case "Station de train":
                lieuRequetteApi = "train_station";
                break;
            case "Station de transit":
                lieuRequetteApi = "transit_station";
                break;
            case "Station de vélo":
                lieuRequetteApi = "taxi_stand";
                break;
            case "Station-essence":
                lieuRequetteApi = "gas_station";
                break;
            case "Supérette":
                lieuRequetteApi = "convenience_store";
                break;
            case "Supermarché":
                lieuRequetteApi = "department_store";
                break;
            case "Synagogue":
                lieuRequetteApi = "synagogue";
                break;
            case "Temple hindou":
                lieuRequetteApi = "hindu_temple";
                break;
            case "Tribunal":
                lieuRequetteApi = "courthouse";
                break;
            case "Université":
                lieuRequetteApi = "university";
                break;
            case "Zoo":
                lieuRequetteApi = "zoo";
                break;
            default:
                Log.i(TAG, "Mot clef inconnu");
                break;
        }
        return lieuRequetteApi;
    }

    int rayon;
    public int getRadius(String typeLocomotion){
        switch (typeLocomotion){
            case "pieton":
                rayon = 2500;
                break;
            case "velo":
                rayon = 750;
                break;
            case "voiture":
                rayon = 15000;
                break;
            default:
                Log.i(TAG, "Rayon inconnu");
                break;
        }
        return rayon;
    }
}
