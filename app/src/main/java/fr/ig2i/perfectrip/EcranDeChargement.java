package fr.ig2i.perfectrip;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

public class EcranDeChargement extends Activity {
    protected GlobalState gs = new GlobalState();
    private Handler splashHandler = new Handler();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        }
        else if(!isGPSEnabled(this)){
            new EcranAlerte(this, "Pas de GPS",
                    "Vous n'avez pas activé la géolocalisation, veuillez réessayer lorsque la géolocalisation sera activée.",
                    "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
        }
        else {
            splashHandler.postDelayed(r, 2000);
            //startActivity(new Intent(EcranDeChargement.this, Localisation.class));
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
}