package fr.ig2i.perfectrip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class EcranListePossibilites extends AppCompatActivity {

    Data data = new Data();
    GlobalState gs = new GlobalState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_liste_possibilites);

        Toast.makeText(getBaseContext(), "Mot clef lieu: " +data.getLieu(gs.lieuEnCours), Toast.LENGTH_SHORT).show();
        Toast.makeText(getBaseContext(), "Rayon: " +data.getRadius(gs.typeLocomotion), Toast.LENGTH_SHORT).show();

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
