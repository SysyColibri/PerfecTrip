package fr.ig2i.perfectrip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class EcranDeChargement extends Activity {

    String now_playing, earned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_de_chargement);
        VerifierReseau vf = new VerifierReseau();
        vf.execute();
    }

    /**
     * Async Task to make http call
     */
    private class VerifierReseau extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            /*ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
            if(isConnected == true) {
                Intent i = new Intent(EcranDeChargement.this, MainActivity.class);
                startActivity(i);
            }
            else {
                finish();
            }*/
            /*try {
                wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Intent i = new Intent(EcranDeChargement.this, EcranDaccueil.class);
            startActivity(i);

            // close this activity
            finish();
        }

    }

}
