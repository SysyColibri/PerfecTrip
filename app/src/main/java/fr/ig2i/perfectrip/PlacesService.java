package fr.ig2i.perfectrip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PlacesService {

    //Attention : quand on pushera, la clé sera visible publiquement sur Github
    private String API_KEY = "AIzaSyC7hRH7RnYQcYCPlMbnIXeMCZ7LgVX134U";

    private String getUrlContents(String u) {

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
        }catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
