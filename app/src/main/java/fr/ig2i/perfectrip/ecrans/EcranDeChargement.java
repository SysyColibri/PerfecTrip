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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_de_chargement);

        final JSONObject save = new JSONObject();

        //------------------------------------------------------------------------------------------
        /*
        JSONObject save = new JSONObject();
        try {
            save.put("typeLocomotion", "");
            save.put("typeSortie", "");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
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
        else if(!FilesUtils.existsJson(this, save)) {
            new EcranAlerte(this, "Sauvegarde existante",
                    "Voulez-vous récupérez les données de la sortie précédente?",
                    "OUI",
                    "NON",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setContentView(R.layout.activity_ecran_choix_activites_recapitulation);
                        }
                    },
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                save.put("typeLocomotion", "");
                                save.put("typeSortie", "");
                            } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            splashHandler.postDelayed(r, 2000);
                        }
                    });
        }
        else {
            try {
                save.put("typeLocomotion", "");
                save.put("typeSortie", "");
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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

    @Override
    public void onBackPressed() {}
}