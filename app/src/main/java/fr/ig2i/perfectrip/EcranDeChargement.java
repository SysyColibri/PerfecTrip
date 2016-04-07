package fr.ig2i.perfectrip;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class EcranDeChargement extends Activity {

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
        if(isNetworkAvailable())
            splashHandler.postDelayed(r, 2000);
        else {
            Intent brain2 = new Intent(EcranDeChargement.this, EcranPasDeReseau.class);
            startActivity(brain2);
        }
    }

    public void onResume(Bundle savedInstanceState){
        super.onResume();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}
