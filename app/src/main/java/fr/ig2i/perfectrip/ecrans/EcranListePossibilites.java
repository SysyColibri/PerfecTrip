package fr.ig2i.perfectrip.ecrans;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fr.ig2i.perfectrip.Data;
import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.PerfectripApp;
import fr.ig2i.perfectrip.interfaces.Call2;
import fr.ig2i.perfectrip.models.Lieu;
import fr.ig2i.perfectrip.PlacesService;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.models.LieuContainer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EcranListePossibilites extends AppCompatActivity {

    Data data = new Data();
    GlobalState gs = new GlobalState();
    List<Lieu> lieuxPossible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_liste_possibilites);

        chargerLieux();
       /*
        PlacesService p = new PlacesService(gs.latitude, gs.longitude, data.getRadius(gs.typeLocomotion), gs.typeSortie, this, new PlacesService.AsyncResponse() {
            @Override
            public void processFinishCallBack(List<Lieu> lieux) {
                // On récupère les données de l'asyntask ici
                lieuxPossible = lieux;
                //System.out.println("nb lieux process:"+lieuxPossible.size());
                LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                setContentView(linearLayout);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                for(Lieu l : lieuxPossible) {
                    TextView textView = new TextView(getApplicationContext());
                    textView.setText(l.getNom());
                    textView.setTextColor(Color.parseColor("#000000"));
                    linearLayout.addView(textView);
                }
            }
        });
        p.execute();*/

        //System.out.println("nb lieux after:"+lieuxPossible.size());
        /*LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for( int i = 0; i < lieuxPossible.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(lieuxPossible.get(i).getNom());
            linearLayout.addView(textView);
        }*/

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
                Log.i("HELLO", "HELLO");
                response.body().getResults();

            }

            @Override
            public void onFailure(Call<LieuContainer> call, Throwable t) {
                Log.i("HELLO", "HELLO KO");
            }
        });


    }
}
