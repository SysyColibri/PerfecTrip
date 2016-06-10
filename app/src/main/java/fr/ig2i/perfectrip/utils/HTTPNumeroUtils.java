package fr.ig2i.perfectrip.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import fr.ig2i.perfectrip.interfaces.AsyncResponseNumero;

public abstract class HTTPNumeroUtils extends AsyncTask<String, String, String> {

    private ProgressDialog pDialog;
    private String placeId;
    private String apiKey = "AIzaSyC7hRH7RnYQcYCPlMbnIXeMCZ7LgVX134U";
    private Activity activity;
    private AsyncResponseNumero callback;


    public HTTPNumeroUtils(String placeId, Activity activity) {
        super();
        this.placeId = placeId;
        this.activity = activity;
    }

    public abstract void onResponseReceived(Object result);


    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Veuillez patienter...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
    }

    @Override
    protected String doInBackground(String... args) {
        URL url = null;
        String result = null;
        String numero = null;
        try {
            url = new URL("https://maps.googleapis.com/maps/api/place/details/json?placeid="+placeId+"&key="+apiKey);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = sb.toString();
        JSONObject jObject = null;
        try {
            jObject = new JSONObject(result);
            numero = jObject.getJSONObject("result").getString("formatted_phone_number");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return numero;
    }
    @Override
    protected void onPostExecute(String numero) {
        pDialog.dismiss();
        onResponseReceived(numero);
    }
}