package fr.ig2i.perfectrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EcranChoixTypeDeLieu extends AppCompatActivity {

    String[] romantiqueCadeau = new String[]{
            "Agence de voyages",
            "Animalerie",
            "Bijouterie",
            "Boulangerie",
            "Fleuriste",
            "Galerie marchande",
            "Institut de beauté",
            "Librairie",
            "Magasin",
            "Magasin d’alcool",
            "Magasin d’électronique",
            "Magasin de chaussure",
            "Magasin de meubles",
            "Magasin de produit de maison",
            "Magasin de vêtements",
            "Parc d'attractions",
            "Salon de beauté",
            "Spa"};

    String[] romantiqueRepas = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] romantiqueSortie = new String[]{
            "Bar",
            "Boite de nuit",
            "Bowling",
            "Casino",
            "Cinéma",
            "Galerie d’art",
            "Galerie marchande",
            "Magasin d’électronique",
            "Magasin de vêtements",
            "Musée",
            "Parc",
            "Parc d'attractions",
            "Stade",
            "Zoo"};

    String[] romantiqueHebergement = new String[]{
            "Camping",
            "Hébergement"};

    /*String[] amisCadeau = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] amisRepas = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] amisSortie = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] amisHebergement = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] familleCadeau = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] familleRepas = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] familleSortie = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] familleHebergement = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] autres = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};*/

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            setContentView(R.layout.activity_ecran_choix_type_de_lieu);
            mListView = (ListView) findViewById(R.id.listViewActivites);

            final String intentTypeActivite = extras.getString("clefTypeActivite");

            switch (intentTypeActivite) {
                case "romantiqueCadeau":
                    ArrayAdapter<String> adapterRomantiqueCadeau = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueCadeau);
                    mListView.setAdapter(adapterRomantiqueCadeau);
                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            if(position==0){
                                // try opening the myfilename.txt
                                try {
                                    InputStream instream = openFileInput("myfilename.txt");

                                    // if file the available for reading
                                    if (instream != null) {
                                        InputStreamReader inputreader = new InputStreamReader(instream);
                                        BufferedReader buffreader = new BufferedReader(inputreader);

                                        System.out.println(buffreader.readLine());

                                        String line = "voiture";

                                        while (( line.equals(buffreader.readLine()))) {
                                            Toast.makeText(getBaseContext(), "TROUVE!", Toast.LENGTH_SHORT).show();
                                        }

                                    }

                                    // close the file again
                                    instream.close();
                                } catch (java.io.FileNotFoundException e) {
                                    Toast.makeText(getBaseContext(), "Fichier introuvable", Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    break;
                case "romantiqueRepas":
                    ArrayAdapter<String> adapterRomantiqueRepas = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueRepas);
                    mListView.setAdapter(adapterRomantiqueRepas);
                    break;
                case "romantiqueSortie":
                    ArrayAdapter<String> adapterRomantiqueSortie = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueSortie);
                    mListView.setAdapter(adapterRomantiqueSortie);
                    break;
                case "romantiqueHebergement":
                    ArrayAdapter<String> adapterRomantiqueHebergement = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueHebergement);
                    mListView.setAdapter(adapterRomantiqueHebergement);
                    break;
                case "romantiqueAdresse":
                    ArrayAdapter<String> adapterRomantiqueAdresse = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueCadeau);
                    mListView.setAdapter(adapterRomantiqueAdresse);
                    break;
                default:
                    ArrayAdapter<String> adapterRomantiqueAutres = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueCadeau);
                    mListView.setAdapter(adapterRomantiqueAutres);
                    break;
            }
        }
    }
}

