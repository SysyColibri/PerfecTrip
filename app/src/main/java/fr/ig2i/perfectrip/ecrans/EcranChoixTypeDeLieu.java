package fr.ig2i.perfectrip.ecrans;

import android.Manifest;
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

public class EcranChoixTypeDeLieu extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    ListView mListView;
    GlobalState gs = new GlobalState();
    Data data = new Data();

    protected GoogleApiClient mGoogleApiClient;
    protected LocationRequest mLocationRequest;
    public android.location.Location mCurrentLocation;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_type_de_lieu);

        mListView = (ListView) findViewById(R.id.listViewActivites);

        buildGoogleApiClient();

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

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(EcranChoixTypeDeLieu.this, "Veuillez autoriser la permission \"Position\" dans Paramètres/Applications/PerfecTrip/Autorisations.", Toast.LENGTH_LONG).show();
                //Cela signifie que la permission à déjà était demandé et l'utilisateur l'a refusé
                //Vous pouvez aussi expliquer à l'utilisateur pourquoi cette permission est nécessaire et la redemander
            } else {
                //Sinon demander la permission
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                return;
            }
        }

        mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        System.out.println("LOCATION 1: " +mCurrentLocation);

        if (mCurrentLocation != null) {
            updateGlobalState();
        }
        else{
            Toast.makeText(this, "Localisation impossible, vérifiez que la géolocalisation est activé.", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        updateGlobalState();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
    }

    public void updateGlobalState() {
        gs.latitude = mCurrentLocation.getLatitude();
        gs.longitude = mCurrentLocation.getLongitude();
        System.out.println("Latitude: " +gs.latitude+ " & Longitude: " +gs.longitude);
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