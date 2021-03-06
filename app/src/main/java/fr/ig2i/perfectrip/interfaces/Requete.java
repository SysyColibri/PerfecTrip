package fr.ig2i.perfectrip.interfaces;

import fr.ig2i.perfectrip.models.DetailsContainer;
import fr.ig2i.perfectrip.models.LieuContainer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Requete {
    @GET("/maps/api/place/nearbysearch/json")
    Call<LieuContainer> getLieux(@Query("location") String latlng, @Query("radius")String radius, @Query("types") String type, @Query("key")String key);

    @GET("/maps/api/place/details/")
    Call<DetailsContainer> getDetails(@Query("placeid") String id, @Query("key")String key);
}