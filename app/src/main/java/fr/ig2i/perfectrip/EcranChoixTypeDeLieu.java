package fr.ig2i.perfectrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

            String intentTypeSortieRetour = extras.getString("clefTypeSortie");

            if (intentTypeSortieRetour.equals("romantique")) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueCadeau);
                mListView.setAdapter(adapter);
            } else if (intentTypeSortieRetour.equals("autres")) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(EcranChoixTypeDeLieu.this, android.R.layout.simple_list_item_1, romantiqueRepas);
                mListView.setAdapter(adapter);
            } else {
                Toast.makeText(getBaseContext(), "Erreur", Toast.LENGTH_SHORT).show();
            }
        }

        /*
        permet d'éviter un crash lors d'un retour arrière depuis la liste d'activités
         */
        else{
            startActivity(new Intent(EcranChoixTypeDeLieu.this, MainActivity.class));
        }
    }
}

