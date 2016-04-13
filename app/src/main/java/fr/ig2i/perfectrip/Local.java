package fr.ig2i.perfectrip;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

public class Local {

    protected static final String TAG = "location-updates-sample";
    protected static final String REQUESTING_LOCATION_UPDATES_KEY = "requesting-location-updates-key";//Keys for storing activity state in the Bundle
    protected static final String LOCATION_KEY = "location-key";

    private static GoogleApiClient mGoogleApiClient;//Provides the entry point to Google Play services
    protected LocationRequest mLocationRequest;//Stores parameters for requests to the FusedLocationProviderApi
    private static Location mCurrentLocation;//Localisation géographique
    protected Boolean mRequestingLocationUpdates;

    private static GlobalState gs = new GlobalState();

    public Local() {
    }

    public static List<Double> getLocalisation(Context context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        }

        return new ArrayList<Double>() {{
            add(mCurrentLocation.getLatitude());
            add(mCurrentLocation.getLongitude());
        }};
    }

    public static void getLocalisationInGlobalState(Context context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            gs.latitude = mCurrentLocation.getLatitude();
            gs.longitude = mCurrentLocation.getLongitude();
        }
    }
}
