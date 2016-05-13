package fr.ig2i.perfectrip.ecrans;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

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
        System.out.println("---------- Thib 1 ----------");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        createLocationRequest();
    }

    protected void createLocationRequest() {
        System.out.println("---------- Thib 2 ----------");
        mLocationRequest = new LocationRequest();
    }

    @Override
    protected void onStart() {
        System.out.println("---------- Thib 3 ----------");
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onResume() {
        System.out.println("---------- Thib 4 ----------");
        super.onResume();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        System.out.println("---------- Thib 5 ----------");
        if (mCurrentLocation == null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            System.out.println("---------- Thib 6 ----------");
            System.out.println("mCurrentLocation: " + mCurrentLocation);
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            System.out.println("mCurrentLocation: " + mCurrentLocation);
            updateGlobalState();
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
        System.out.println("---------- Thib 7 ----------");
        gs.latitude = mCurrentLocation.getLatitude();
        gs.longitude = mCurrentLocation.getLongitude();
        System.out.println("Latitude: " +gs.latitude);
    }
}