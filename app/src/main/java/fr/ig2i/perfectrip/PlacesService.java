package fr.ig2i.perfectrip;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import fr.ig2i.perfectrip.models.Lieu;

public class PlacesService extends AsyncTask<Void,Integer,List<Lieu>> {

    //Attention : quand on pushera, la clé sera visible publiquement sur Github
    private String API_KEY = "AIzaSyC7hRH7RnYQcYCPlMbnIXeMCZ7LgVX134U";
    //Type food, 3500m autour de 2i, comporte des lieux avec prix et notes
    private String URLtest = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=50.4351469,2.8213258&radius=3500&types=food&key=AIzaSyC7hRH7RnYQcYCPlMbnIXeMCZ7LgVX134U";

    private Double lat;
    private Double lng;
    private Integer radius;
    private String type;
    private Context ctx;
    private View ui;

    private ProgressDialog pd;

    public interface AsyncResponse {
        void processFinishCallBack(List<Lieu> lieux);
    }

    public AsyncResponse delegate = null;

    public PlacesService(Double lat, Double lng, Integer radius, String type, Context ctx, AsyncResponse asyncResponse) {
        super();
        this.lat = lat;
        this.lng = lng;
        this.radius = radius;
        this.type = type;
        this.ctx = ctx;
        delegate = asyncResponse;
        this.ui = ui;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(ctx);
        pd.setTitle("Chargement");
        pd.setMessage("Récupérations des données...");
        pd.show();
    }

    @Override
    protected List<Lieu> doInBackground(Void... params) {
        String url = URLBuilder(lat, lng, radius, type);
        System.out.println(url);
        List<Lieu> lieux = null;
        try {
            lieux = parseJSON(getUrlContents(url));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i=0;i>100000000;i++) {}
        for(int i=0;i>100000000;i++) {}
        for(int i=0;i>100000000;i++) {}
        for(int i=0;i>100000000;i++) {}
        for(int i=0;i>100000000;i++) {}

        return lieux;
    }

    @Override
    protected void onPostExecute(List<Lieu> lieux) {
        super.onPostExecute(lieux);
        pd.dismiss();
        delegate.processFinishCallBack(lieux);
        //Faire l'UI ici ?
        //RelativeLayout comentariEditText = (RelativeLayout) ui.findViewById(R.id.activity_ecran_liste);

        /*for(Lieu l : lieux) {
            TextView tv=new TextView(ctx);
            tv.setText(l.getNom());
        }*/
        /*for(Lieu l : lieux) {
            System.out.println(l.getNom());
        }*/
    }

    public String URLBuilder(Double lat, Double lng, Integer radius, String type) {

        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" +
                lat.toString() +
                "," +
                lng.toString() +
                "&radius=" +
                radius.toString() +
                "&types=" +
                type +
                "&key=" +
                API_KEY;

        return url;
    }

    public String getUrlContents(String u) {

        String line;

        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(u);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()), 8);
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public List<Lieu> parseJSON(String json) throws JSONException {
        JSONObject jsonobj = new JSONObject(json);
        JSONArray resarray = jsonobj.getJSONArray("results");

        Double rating = null;
        Double price = null;

        Lieu l;
        List<Lieu> lieux = new ArrayList<Lieu>();

        if (resarray.length() == 0) {
            //Pas de résultats, cas a prévoir
        } else {
            int len = resarray.length();
            for (int j = 0; j < len; j++) {
                if(!resarray.getJSONObject(j).has("rating")) {
                    rating = null;
                } else {
                    rating = resarray.getJSONObject(j).getDouble("rating");
                }
                if(!resarray.getJSONObject(j).has("price")) {
                    price = null;
                } else {
                    rating = resarray.getJSONObject(j).getDouble("price");
                }

                l = new Lieu(
                        resarray.getJSONObject(j).getString("name"),
                        resarray.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lat"),
                        resarray.getJSONObject(j).getJSONObject("geometry").getJSONObject("location").getDouble("lng"),
                        rating,
                        price,
                        "06 10 29 28 17"
                        /*Pour avoir le N° de téléphone il faut faire une requête détails
                        Nuémro en dur pour l'instant
                         */

                );
                lieux.add(l);
            }
        }
        return lieux;
    }
}
