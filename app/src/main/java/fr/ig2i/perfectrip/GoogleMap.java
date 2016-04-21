package fr.ig2i.perfectrip;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesRecapitulation;

public class GoogleMap extends AppCompatActivity {
    GlobalState gs = new GlobalState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(GoogleMap.this, EcranChoixActivitesRecapitulation.class));
        startGoogleMap();

        gs.peuplerTest();
        gs.activites.get(0).lieu.getLatitude();
    }

    public void startGoogleMap() {
        System.out.println("START GOOGLE MAP");
        String url = "https://www.google.fr/maps/dir/50.4351469,2.8235145/47.1827615,5.0622634/";

        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
        startActivity(intent);
    }
}