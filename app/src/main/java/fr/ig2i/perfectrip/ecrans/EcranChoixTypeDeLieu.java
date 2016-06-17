package fr.ig2i.perfectrip.ecrans;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import fr.ig2i.perfectrip.Data;
import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.adapters.AdapterEcranChoixTypeDeLieu;

public class EcranChoixTypeDeLieu extends Activity{

    ListView mListView;
    GlobalState gs = new GlobalState();
    Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_type_de_lieu);



        mListView = (ListView) findViewById(R.id.listViewActivites);

        switch (gs.typeSortie + gs.activitesEnCours) {
            case "romantiqueCadeau":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.romantiqueCadeau));
                break;
            case "romantiqueRepas":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.romantiqueRepas));
                break;
            case "romantiqueSortie":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.romantiqueSortie));
                break;
            case "romantiqueHébergement":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.romantiqueHébergement));
                break;
            case "amisCadeau":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.amisCadeau));
                break;
            case "amisRepas":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.amisRepas));
                break;
            case "amisSortie":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.amisSortie));
                break;
            case "amisHébergement":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.amisHébergement));
                break;
            case "familleCadeau":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.familleCadeau));
                break;
            case "familleRepas":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.familleRepas));
                break;
            case "familleSortie":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.familleSortie));
                break;
            case "familleHébergement":
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.familleHébergement));
                break;
            default:
                mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.autres));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(EcranChoixTypeDeLieu.this, EcranChoixActivitesEdition.class));
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( keyCode == KeyEvent.KEYCODE_MENU ) {
            startActivity(new Intent(EcranChoixTypeDeLieu.this, APropos.class));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}