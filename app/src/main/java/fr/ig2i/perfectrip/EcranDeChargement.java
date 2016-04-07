package fr.ig2i.perfectrip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

public class EcranDeChargement extends Activity {
//public class EcranDeChargement extends AppCompatActivity {

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
            //Toast.make
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
            if(isConnected) {
                Intent i = new Intent(EcranDeChargement.this, EcranDaccueil.class);
                startActivity(i);
            }
            else {
                finish();
            }
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
