package fr.ig2i.perfectrip.ecrans;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.utils.FilesUtils;

public class EcranDeChargement extends Activity {
    private Handler splashHandler = new Handler();
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_de_chargement);

        String marcus1 = "file.txt";

        JSONObject marcus2 = new JSONObject();
        try {
            marcus2.put("id", "3");
            marcus2.put("name", "NAME OF STUDENT");
            marcus2.put("year", "3rd");
            marcus2.put("curriculum", "Arts");
            marcus2.put("birthday", "5/5/1993");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //------------------------------------------------------------------------------------------

        final Runnable r = new Runnable(){
            public void run(){
                Intent brain = new Intent(EcranDeChargement.this, EcranDaccueil.class);
                startActivity(brain);
                finish();
            }
        };

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
        else if(!FilesUtils.existsJson(this, marcus2)) {
            new EcranAlerte(this, "Sauvegarde existante",
                    "Voulez-vous récupérez les données de la sortie préscedente?",
                    "OUI",
                    "NON",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            splashHandler.postDelayed(r, 2000);
                        }
                    },
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            splashHandler.postDelayed(r, 2000);
                        }
                    });
        }
        else {
            splashHandler.postDelayed(r, 2000);
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