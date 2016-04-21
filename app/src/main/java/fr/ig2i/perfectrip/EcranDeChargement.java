package fr.ig2i.perfectrip;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class EcranDeChargement extends Activity {
    private Handler splashHandler = new Handler();

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


/*
        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission[0])!= MockPackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(this, mPermission[1])!= MockPackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(this, mPermission[2])!= MockPackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this,mPermission, REQUEST_CODE_PERMISSION);
                // If any permission aboe not allowed by user, this condition will execute every tim, else your else part will work
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

        Runnable r = new Runnable(){
            public void run(){
                Intent brain = new Intent(EcranDeChargement.this, EcranDaccueil.class);
                startActivity(brain);
                finish();
            }
        };
        setContentView(R.layout.activity_ecran_de_chargement);

        if(!isOnline(this)) {
            new EcranAlerte(this, "Pas de réseau",
            "Aucune connexion internet n'a été trouvée, veuillez réessayer lorsque la connexion sera rétablie.",
            "OK",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
        } else if(!isGPSEnabled(this)){
            new EcranAlerte(this, "Pas de GPS",
                    "Vous n'avez pas activé la géolocalisation, veuillez réessayer lorsque la géolocalisation sera activée.",
                    "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
        } else {
            splashHandler.postDelayed(r, 2000);
            startActivity(new Intent(EcranDeChargement.this, Localisation.class));
        }
    }

    public static boolean isOnline(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static boolean isGPSEnabled(Context ctx)  {
        LocationManager lm = (LocationManager)ctx.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    /*
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e("Req Code", "" + requestCode);
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (grantResults.length == 4 &&
                    grantResults[0] == MockPackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == MockPackageManager.PERMISSION_GRANTED &&
                    grantResults[2] == MockPackageManager.PERMISSION_GRANTED) {

                // Success Stuff here

            }
        }

    }
    */

}