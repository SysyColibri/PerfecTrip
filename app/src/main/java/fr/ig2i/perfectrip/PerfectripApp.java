package fr.ig2i.perfectrip;

import android.app.Application;

import fr.ig2i.perfectrip.interfaces.Call2;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 10082892 on 19/04/2016.
 */
public class PerfectripApp extends Application{

    Call2 service;
    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(Call2.class);
    }

    public Call2 getRetrofitService() {
        return service;
    }

}
