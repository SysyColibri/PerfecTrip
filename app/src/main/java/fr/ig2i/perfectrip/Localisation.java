package fr.ig2i.perfectrip;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class Localisation extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener, LocationListener {

    //public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;//The desired interval for location updates. Inexact. Updates may be more or less frequent.
    //public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;

    protected static final String TAG = "location-updates-sample";
    protected static final String REQUESTING_LOCATION_UPDATES_KEY = "requesting-location-updates-key";//Keys for storing activity state in the Bundle
    protected static final String LOCATION_KEY = "location-key";

    protected GoogleApiClient mGoogleApiClient;//Provides the entry point to Google Play services
    protected LocationRequest mLocationRequest;//Stores parameters for requests to the FusedLocationProviderApi
    public Location mCurrentLocation;//Localisation géographique
    protected Boolean mRequestingLocationUpdates;//Tracks the status of the location updates request. Value changes when the user presses the Start Updates and Stop Updates buttons

    protected GlobalState gs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRequestingLocationUpdates = false; //SUPPRESSION?

        // Update values using data stored in the Bundle.
        System.out.println("---------- 1 ----------");
        updateValuesFromBundle(savedInstanceState);

        // Kick off the process of building a GoogleApiClient and requesting the LocationServices
        // API.
        System.out.println("---------- 2 ----------");
        buildGoogleApiClient();
    }

    /**
     * PREMIERE ETAPE
     * Updates fields based on data stored in the bundle.
     * @param savedInstanceState The activity state saved in the Bundle.
     */
    private void updateValuesFromBundle(Bundle savedInstanceState) {
        System.out.println("---------- 3 ----------" );
        Log.i(TAG, "Updating values from bundle");
        /*if (savedInstanceState != null) {
            System.out.println("---------- 4 ----------");
            // Update the value of mRequestingLocationUpdates from the Bundle, and make sure that
            // the Start Updates and Stop Updates buttons are correctly enabled or disabled.
            if (savedInstanceState.keySet().contains(REQUESTING_LOCATION_UPDATES_KEY)) {
                System.out.println("---------- 5 ----------");
                mRequestingLocationUpdates = savedInstanceState.getBoolean(REQUESTING_LOCATION_UPDATES_KEY);
                setButtonsEnabledState();
            }

            // Update the value of mCurrentLocation from the Bundle and update the UI to show the
            // correct latitude and longitude.
            if (savedInstanceState.keySet().contains(LOCATION_KEY)) {
                System.out.println("---------- 6 ----------" );
                // Since LOCATION_KEY was found in the Bundle, we can be sure that mCurrentLocation
                // is not null.
                mCurrentLocation = savedInstanceState.getParcelable(LOCATION_KEY);
            }

            // Update the value of mLastUpdateTime from the Bundle and update the UI.
            if (savedInstanceState.keySet().contains(LAST_UPDATED_TIME_STRING_KEY)) {
                System.out.println("---------- 7 ----------" );
                mLastUpdateTime = savedInstanceState.getString(LAST_UPDATED_TIME_STRING_KEY);
            }
            updateUI();
        }*/
    }

    /**
     * DEUXIEME ETAPE
     * Builds a GoogleApiClient. Uses the {@code #addApi} method to request the LocationServices API.
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

    /**
     * TROISIEME ETAPE
     * Sets up the location request. Android has two location request settings:
     * {@code ACCESS_COARSE_LOCATION} and {@code ACCESS_FINE_LOCATION}. These settings control
     * the accuracy of the current location. This sample uses ACCESS_FINE_LOCATION, as defined in the AndroidManifest.xml.
     * <p/>
     * When the ACCESS_FINE_LOCATION setting is specified, combined with a fast update
     * interval (5 seconds), the Fused Location Provider API returns location updates that are accurate to within a few feet.
     * <p/>
     * These settings are appropriate for mapping applications that show real-time location updates.
     */
    protected void createLocationRequest() {
        System.out.println("---------- 9 ----------");
        mLocationRequest = new LocationRequest();

        /* SUPPRESSION?
        // Sets the desired interval for active location updates. This interval is
        // inexact. You may not receive updates at all if no location sources are available, or
        // you may receive them slower than requested. You may also receive updates faster than
        // requested if other applications are requesting location at a faster interval.
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);

        // Sets the fastest rate for active location updates. This interval is exact, and your
        // application will never receive updates faster than this value.
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);

        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        */
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
        // Within {@code onPause()}, we pause location updates, but leave the
        // connection to GoogleApiClient intact.  Here, we resume receiving
        // location updates if the user has requested them.

        /* SUPPRESSION?
        if (mGoogleApiClient.isConnected() && mRequestingLocationUpdates) {
            System.out.println("---------- 20 ----------");
            startLocationUpdates();
        }
        */
    }

    /**
     * SIXIEME ETAPE
     * Runs when a GoogleApiClient object successfully connects.
     */
    @Override
    public void onConnected(Bundle connectionHint) {
        System.out.println("---------- 24 ----------");
        Log.i(TAG, "Connected to GoogleApiClient");

        // If the initial location was never previously requested, we use
        // FusedLocationApi.getLastLocation() to get it. If it was previously requested, we store
        // its value in the Bundle and check for it in onCreate(). We
        // do not request it again unless the user specifically requests location updates by pressing
        // the Start Updates button.
        //
        // Because we cache the value of the initial location in the Bundle, it means that if the
        // user launches the activity,
        // moves to a new location, and then changes the device orientation, the original location
        // is displayed as the activity is re-created.
        if (mCurrentLocation == null) {
            System.out.println("---------- 25 ----------");
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                System.out.println("---------- 26 ----------");
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            updateGlobalState();
        }

        /* SUPPRESSION?
        // If the user presses the Start Updates button before GoogleApiClient connects, we set
        // mRequestingLocationUpdates to true (see startUpdatesButtonHandler()). Here, we check
        // the value of mRequestingLocationUpdates and if it is true, we start location updates.
        if (mRequestingLocationUpdates) {
            System.out.println("---------- 27 ----------");
            startLocationUpdates();
        }
        */
    }

    /*
    SEPTIEME ETAPE
    ONZIEME ETAPE
     */
    private void updateGlobalState() {
        System.out.println("---------- 16 ----------");
        gs.latitude = mCurrentLocation.getLatitude();
        gs.longitude = mCurrentLocation.getLongitude();
    }

    /**
     * HUITIEME ETAPE
     * Handles the Start Updates button and requests start of location updates. Does nothing if updates have already been requested.
     */
    public void startUpdates(View view) {
        System.out.println("---------- 10 ----------" );
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
    protected void startLocationUpdates() {
        System.out.println("---------- 14 ----------");
        // The final argument to {@code requestLocationUpdates()} is a LocationListener
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("---------- 15 ----------" );
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    /**
     * DIXIEME ETAPE
     * Callback that fires when the location changes.
     */
    @Override
    public void onLocationChanged(Location location) {
        System.out.println("---------- 28 ----------");
        mCurrentLocation = location;
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
        savedInstanceState.putBoolean(REQUESTING_LOCATION_UPDATES_KEY, mRequestingLocationUpdates);
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
}