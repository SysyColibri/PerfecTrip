package fr.ig2i.perfectrip;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesEdition;

public class Localisation extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener, LocationListener {
    protected static final String TAG = "location-updates-sample";
    protected static final String REQUESTING_LOCATION_UPDATES_KEY = "requesting-location-updates-key";
    protected static final String LOCATION_KEY = "location-key";

    protected View mLayout;
    Button mButtonCheckPermission = null;
    GlobalState gs = new GlobalState();

    protected static final int REQUEST_LOCATION = 1;
    protected static String[] PERMISSIONS_LOCATION = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    protected GoogleApiClient mGoogleApiClient;
    protected LocationRequest mLocationRequest;
    public android.location.Location mCurrentLocation;
    protected Boolean mRequestingLocationUpdates;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ecran_de_chargement);

        System.out.println("---------- 2 ----------");
        buildGoogleApiClient();
    }

    /**
     * DEUXIEME ETAPE
     */
    protected synchronized void buildGoogleApiClient() {
        System.out.println("---------- 8 ----------");
        Log.i(TAG, "Building GoogleApiClient");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        createLocationRequest();
    }

    /*
     * TROISIEME ETAPE
     */
    protected void createLocationRequest() {
        System.out.println("---------- 9 ----------");
        mLocationRequest = new LocationRequest();
    }

    /*
    QUATRIEME ETAPE
     */
    @Override
    protected void onStart() {
        System.out.println("---------- 18 ----------");
        super.onStart();
        mGoogleApiClient.connect();
    }

    /*
    CINQUIEME ETAPE
     */
    @Override
    public void onResume() {
        System.out.println("---------- 19 ----------");
        super.onResume();
    }

    /*
     * SIXIEME ETAPE
     */
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onConnected(Bundle connectionHint) {

        System.out.println("---------- 24 ----------");
        Log.i(TAG, "Connected to GoogleApiClient");
        if (mCurrentLocation == null) {
            System.out.println("---------- 25 ----------");
            System.out.println("Manifest.permission.ACCESS_FINE_LOCATION: " + Manifest.permission.ACCESS_FINE_LOCATION);
            System.out.println("PackageManager.PERMISSION_GRANTED: " + PackageManager.PERMISSION_GRANTED);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
        }

        System.out.println("mCurrentLocation" + mCurrentLocation);
        mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        System.out.println("mCurrentLocation" + mCurrentLocation);
        updateGlobalState();
    }

    /*
    SEPTIEME ETAPE
    ONZIEME ETAPE
     */
    public void updateGlobalState() {
        System.out.println("---------- 16 ----------");
        gs.latitude = mCurrentLocation.getLatitude();
        gs.longitude = mCurrentLocation.getLongitude();
    }

    /**
     * HUITIEME ETAPE
     * Handles the Start Updates button and requests start of location updates. Does nothing if updates have already been requested.
     */
    public void startUpdates(View view) {
        System.out.println("---------- 10 ----------");
        if (!mRequestingLocationUpdates) {
            System.out.println("---------- 11 ----------");
            mRequestingLocationUpdates = true;
            startLocationUpdates();
        }
    }

    /**
     * NEUVIEME ETAPE
     * Requests location updates from the FusedLocationApi.
     */
    @TargetApi(Build.VERSION_CODES.M)
    protected void startLocationUpdates() {
        System.out.println("---------- 14 ----------");
        System.out.println("Manifest.permission.ACCESS_FINE_LOCATION: " + Manifest.permission.ACCESS_FINE_LOCATION);
        System.out.println("PackageManager.PERMISSION_GRANTED: " + PackageManager.PERMISSION_GRANTED);

        /*
        while(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, PERMISSIONS_LOCATION, REQUEST_LOCATION);
        }
        */

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
        else{
            startActivity(new Intent(Localisation.this, EcranChoixActivitesEdition.class));
            ActivityCompat.requestPermissions(this, PERMISSIONS_LOCATION, REQUEST_LOCATION);
        }

    }

    /**
     * DIXIEME ETAPE
     * Callback that fires when the location changes.
     */
    @Override
    public void onLocationChanged(android.location.Location location) {
        System.out.println("---------- 28 ----------");
        mCurrentLocation = location;
        System.out.println("mCurrentLocation: " +mCurrentLocation);
        updateGlobalState();
    }

    /**
     * DOUZIEME ETAPE
     * Handles the Stop Updates button, and requests removal of location updates. Does nothing if
     * updates were not previously requested.
     */
    public void stopUpdates(View view) {
        System.out.println("---------- 12 ----------");
        if (mRequestingLocationUpdates) {
            System.out.println("---------- 13 ----------");
            mRequestingLocationUpdates = false;
            stopLocationUpdates();
        }
    }

    /**
     * TREIZIEME ETAPE
     * QUINZIEME ETAPE
     * Removes location updates from the FusedLocationApi.
     */
    protected void stopLocationUpdates() {
        System.out.println("---------- 17 ----------");
        // It is a good practice to remove location requests when the activity is in a paused or
        // stopped state. Doing so helps battery performance and is especially
        // recommended in applications that request frequent location updates.

        // The final argument to {@code requestLocationUpdates()} is a LocationListener
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    }

    /*
    QUATORZIEME ETAPE
     */
    @Override
    protected void onPause() {
        System.out.println("---------- 21 ----------");
        super.onPause();
        // Stop location updates to save battery, but don't disconnect the GoogleApiClient object.
        if (mGoogleApiClient.isConnected()) {
            System.out.println("---------- 22 ----------");
            stopLocationUpdates();
        }
    }

    /**
     * SEIZIEME ETAPE
     * Stores activity data in the Bundle.
     */
    public void onSaveInstanceState(Bundle savedInstanceState) {
        System.out.println("---------- 31 ----------");
        //savedInstanceState.putBoolean(REQUESTING_LOCATION_UPDATES_KEY, mRequestingLocationUpdates);
        savedInstanceState.putParcelable(LOCATION_KEY, mCurrentLocation);
        super.onSaveInstanceState(savedInstanceState);
    }

    /*
    DIX-SEPTIEME ETAPE
     */
    @Override
    protected void onStop() {
        System.out.println("---------- 23 ----------");
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    /*
    OBLIGATOIRE
     */
    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    /*
    OBLIGATOIRE
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
        // onConnectionFailed.
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }
/*
    public void requestLocationPermissions() {
        boolean requestPermission = Permission.requestPermissions(this);
        if (requestPermission == true){
            Log.i(TAG,
                    "Displaying contacts permission rationale to provide additional context.");
            // Display a SnackBar with an explanation and a button to trigger the request.
            Snackbar.make(mLayout, "R.string.permission_contacts_rationale",
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction("ok", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat
                                    .requestPermissions(Localisation.this, mPermission,
                                            REQUEST_PERMISSION);
                        }
                    })
                    .show();
        }
        else {
            ActivityCompat.requestPermissions(this, mPermission, REQUEST_PERMISSION);
        }
    }*/
/*
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        if (requestCode == REQUEST_PERMISSION) {
            Log.i(TAG, "Received response for contact permissions request.");

            // We have requested multiple permissions for contacts, so all of them need to be
            // checked.
            if (Permission.verifyPermissions(grantResults)) {
                // All required permissions have been granted, display contacts fragment.
                Snackbar.make(mLayout, "R.string.permision_available_contacts",
                        Snackbar.LENGTH_LONG)
                        .show();
            } else {
                Log.i(TAG, "Contacts permissions were NOT granted.");
                Snackbar.make(mLayout, "R.string.permissions_not_granted",
                        Snackbar.LENGTH_LONG)
                        .show();
            }

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }*/
}