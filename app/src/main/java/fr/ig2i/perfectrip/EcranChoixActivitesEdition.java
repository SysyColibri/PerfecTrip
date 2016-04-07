package fr.ig2i.perfectrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EcranChoixActivitesEdition extends AppCompatActivity {

    ListView mListView;
    String[] romantiqueAmisFamille = new String[]{"Cadeau", "Repas", "Sortie", "Hébergement", "Adresse particulière", "Autres"};
    String[] autres = new String[]{"Autres"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            setContentView(R.layout.activity_ecran_choix_activites_edition);
            mListView = (ListView) findViewById(R.id.listViewActivites);

            String intentTypeSortieRetour = extras.getString("clefTypeSortie");

            if (intentTypeSortieRetour.equals("romantiqueAmisFamille")) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, romantiqueAmisFamille);
                mListView.setAdapter(adapter);
            } else if (intentTypeSortieRetour.equals("autres")) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, autres);
                mListView.setAdapter(adapter);
            } else {
                Toast.makeText(getBaseContext(), "Erreur", Toast.LENGTH_SHORT).show();
            }
        }

        /*
        permet d'éviter un crash lors d'un retour arrière depuis la liste d'activités
         */
        else{
            startActivity(new Intent(EcranChoixActivitesEdition.this, MainActivity.class));
        }
    }
}
