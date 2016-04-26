package fr.ig2i.perfectrip;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesRecapitulation;

public class GoogleMap extends AppCompatActivity {
    GlobalState gs = new GlobalState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(GoogleMap.this, EcranChoixActivitesRecapitulation.class));
        startGoogleMap();

        }

    public void startGoogleMap() {
        //String url = "https://www.google.fr/maps/dir/" +gs.latitude+ "," +gs.longitude+"/47.1827615,5.0622634/";
        //gs.activites
        Bundle extras = getIntent().getExtras();
        Integer id = extras.getInt("ID");
        Log.i("ID",id.toString());

        Double latDestination = gs.activites.get(id).getLieu().getGeometry().getLocation().getLat();
        Double lngDestination = gs.activites.get(id).getLieu().getGeometry().getLocation().getLng();

        String url = "https://www.google.fr/maps/dir/" +gs.latitude+ "," +gs.longitude+"/"+latDestination+","+lngDestination;
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
        startActivity(intent);
    }
}