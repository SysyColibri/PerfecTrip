package fr.ig2i.perfectrip.ecrans;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.adapters.AdapterEcranActivitesRecapitulation;

public class EcranChoixActivitesRecapitulation extends AppCompatActivity {

    protected Button mButtonAccueil;
    protected Button mButtonRecapitulation;
    protected GlobalState gs = new GlobalState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_activites_recapitulation);

        ListView listview;
        GlobalState gs = new GlobalState();

        mButtonAccueil = (Button) findViewById(R.id.buttonAccueil);
        mButtonRecapitulation = (Button) findViewById(R.id.buttonRecapitulation);

        listview = (ListView) findViewById(R.id.listViewActivites);//Récupération de la ListView
        listview.setAdapter(new AdapterEcranActivitesRecapitulation(this,gs.activites));

        mButtonAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcranChoixActivitesRecapitulation.this, EcranDaccueil.class));
                finish();
            }
        });

        mButtonRecapitulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcranChoixActivitesRecapitulation.this, EcranChoixActivitesEdition.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( keyCode == KeyEvent.KEYCODE_MENU ) {
            startActivity(new Intent(EcranChoixActivitesRecapitulation.this, APropos.class));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
