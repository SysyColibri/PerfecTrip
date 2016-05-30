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
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.utils.FilesUtils;

public class EcranDeChargement extends Activity {
    private Handler splashHandler = new Handler();

    protected FilesUtils f = new FilesUtils();
    protected GlobalState gs = new GlobalState();

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
                //Intent brain = new Intent(EcranDeChargement.this, APropos.class);
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
                            //f.seeAll(getApplicationContext());
                            gs.activites = f.getAll(getApplicationContext());
                            startActivity(new Intent(EcranDeChargement.this, EcranChoixActivitesRecapitulation.class));
                            Toast.makeText(EcranDeChargement.this, "TEEEEEST", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           FilesUtils.deleteAll(getApplicationContext());
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