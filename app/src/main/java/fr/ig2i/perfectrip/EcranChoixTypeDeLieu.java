package fr.ig2i.perfectrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

    String[] amisCadeau = new String[]{
            "Agence de voyages",
            "Bijouterie",
            "Boulangerie",
            "Epicerie ou supermarché",
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
            "Magasin de vélo",
            "Magasin de vêtements",
            "Parc d'attractions",
            "Salon de beauté",
            "Spa",
            "Stade",
            "Supérette"};

    String[] amisRepas = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] amisSortie = new String[]{
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

    String[] amisHebergement = new String[]{
            "Camping",
            "Hébergement"};

    String[] familleCadeau = new String[]{
            "Agence de voyages",
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
            "Magasin de vélo",
            "Magasin de vêtements",
            "Parc d'attractions",
            "Salon de beauté",
            "Spa",
            "Stade"};

    String[] familleRepas = new String[]{
            "Bar",
            "Boulangerie",
            "Café",
            "Casino",
            "Repas à emporter",
            "Restaurant"};

    String[] familleSortie = new String[]{
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

    String[] familleHebergement = new String[]{
            "Camping",
            "Hébergement"};

    String[] autres = new String[]{
            "Aéroport",
            "Agence de voyages",
            "Banque",
            "Bar",
            "Bibliothèque",
            "Bijouterie",
            "Blanchisserie",
            "Boite de nuit",
            "Boulangerie",
            "Bowling",
            "Bureau de poste",
            "Café",
            "Camping",
            "Casino",
            "Cinéma",
            "Distributeur d’argent",
            "Emplacement camping car",
            "Epicerie ou supermarché",
            "Fleuriste",
            "Galerie d’art",
            "Galerie marchande",
            "Hôpital",
            "Institut de beauté",
            "Lavage de voiture",
            "Librairie",
            "Livraison de repas",
            "Location de films",
            "Location de voiture",
            "Magasin",
            "Magasin d’alcool",
            "Magasin d’électronique",
            "Magasin de chaussure",
            "Magasin de meubles",
            "Magasin de produit de maison",
            "Magasin de vélo",
            "Magasin de vêtements",
            "Musée",
            "Parc",
            "Parc d'attractions",
            "Parking",
            "Pharmacie",
            "Police",
            "Repas à emporter",
            "Restaurant",
            "Salon de beauté",
            "Spa",
            "Stade",
            "Station de bus",
            "Station de métro",
            "Station de train",
            "Station de transit",
            "Station de vélo",
            "Station-essence",
            "Supérette",
            "Supermarché",
            "Zoo"};

    ListView mListView;
    String typeActivites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ecran_choix_type_de_lieu);
        mListView = (ListView) findViewById(R.id.listViewActivites);

        typeActivites = recuperationValeurFichier("typeActivite.txt");

        switch (typeActivites) {
            case "cadeau":
                ArrayAdapter<String> adapterRomantiqueCadeau = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueCadeau);
                mListView.setAdapter(adapterRomantiqueCadeau);
                break;
            case "repas":
                ArrayAdapter<String> adapterRomantiqueRepas = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueRepas);
                mListView.setAdapter(adapterRomantiqueRepas);
                break;
            case "sortie":
                ArrayAdapter<String> adapterRomantiqueSortie = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueSortie);
                mListView.setAdapter(adapterRomantiqueSortie);
                break;
            case "hebergement":
                ArrayAdapter<String> adapterRomantiqueHebergement = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueHebergement);
                mListView.setAdapter(adapterRomantiqueHebergement);
                break;
            case "adresse":
                ArrayAdapter<String> adapterRomantiqueAdresse = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueCadeau);
                mListView.setAdapter(adapterRomantiqueAdresse);
                break;
            default:
                ArrayAdapter<String> adapterRomantiqueAutres = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueCadeau);
                mListView.setAdapter(adapterRomantiqueAutres);
                break;
        }
    }

    private String recuperationValeurFichier(String fichier){
        String retour = null;
        try
        {
            //On ouvre le .txt
            InputStream instream = openFileInput(fichier);
            //prepare le .txt pour lecture
            InputStreamReader inputreader = new InputStreamReader(instream);
            BufferedReader br = new BufferedReader (inputreader);

            try
            {
                //On écrit la valeur de la première ligne dans le String
                retour = br.readLine();
                br.close();
                inputreader.close();
            }
            catch (IOException exception)
            {
                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("Le fichier n'a pas été trouvé");
        }
        return retour;
    }
}

