package fr.ig2i.perfectrip;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EcranListePossibilites extends AppCompatActivity {

    Data data = new Data();
    GlobalState gs = new GlobalState();
    List<Lieu> lieuxPossible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_liste_possibilites);
        PlacesService p = new PlacesService(gs.latitude, gs.longitude, data.getRadius(gs.typeLocomotion), gs.typeSortie, this, new PlacesService.AsyncResponse() {
            @Override
            public void processFinishCallBack(List<Lieu> lieux) {
                // On récupère les données de l'asyntask ici
                lieuxPossible = lieux;
                System.out.println("nb lieux process:"+lieuxPossible.size());
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
        p.execute();

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
}
