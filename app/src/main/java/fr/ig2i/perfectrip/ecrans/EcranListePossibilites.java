package fr.ig2i.perfectrip.ecrans;

import android.app.ListActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.ig2i.perfectrip.Data;
import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.PerfectripApp;
import fr.ig2i.perfectrip.adapters.AdapterEcranListePossibilites;
import fr.ig2i.perfectrip.interfaces.Call2;
import fr.ig2i.perfectrip.models.Lieu;
import fr.ig2i.perfectrip.PlacesService;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.models.LieuContainer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EcranListePossibilites extends ListActivity {

    Data data = new Data();
    GlobalState gs = new GlobalState();
    ArrayList<Lieu> lieuxPossible;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chargerLieux();
        /*
        EXEMPLE DE REQUETTE API POUR INFO
        FLEURISTE - 1000m - IG2I
        https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=50.4329004,2.8189604&radius=1000&type=florist&key=AIzaSyC7hRH7RnYQcYCPlMbnIXeMCZ7LgVX134U

        location    : OK - gs.latitude & gs.longitude
        radius      : OK - getRadius()
        type        : OK - getLieu()
        clef API    : OK - AIzaSyC7hRH7RnYQcYCPlMbnIXeMCZ7LgVX134U
         */
    }

    private void chargerLieux(){
        Call2 service = ((PerfectripApp) getApplicationContext()).getRetrofitService();
        Call<LieuContainer> call = service.getLieux(gs.latitude+","+gs.longitude, "1000", "food", "AIzaSyC7hRH7RnYQcYCPlMbnIXeMCZ7LgVX134U");

        call.enqueue(new Callback<LieuContainer>() {
            @Override
            public void onResponse(Call<LieuContainer> call, Response<LieuContainer> response) {
                lieuxPossible = response.body().getResults();
                /*for (Lieu l : lieuxPossible) {
                    Log.i("TEST",l.getName());
                }*/
                listView = getListView();
                AdapterEcranListePossibilites adapter = new AdapterEcranListePossibilites(getApplicationContext(), lieuxPossible);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<LieuContainer> call, Throwable t) {
                //Si l'appel http a merdé
                Log.i("HELLO", "HELLO KO");
            }
        });


    }
}
