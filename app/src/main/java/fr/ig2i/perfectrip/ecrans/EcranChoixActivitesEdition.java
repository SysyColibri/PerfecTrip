package fr.ig2i.perfectrip.ecrans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.adapters.AdapterEcranActivitesEdition;

public class EcranChoixActivitesEdition extends AppCompatActivity {

    ListView listview;
    EcranChoixActivitesRecapitulation switchRecapitulation = new EcranChoixActivitesRecapitulation();
    ImageButton add;
    String[] romantiqueAmisFamille = new String[]{"Cadeau", "Repas", "Sortie", "Hébergement", "Autres"};

    protected Button mButtonAccueil;
    protected Button mButtonEdition;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_activites_edition);

        mButtonAccueil = (Button) findViewById(R.id.buttonAccueil);
        mButtonEdition = (Button) findViewById(R.id.buttonEdition);

        listview = (ListView) findViewById(R.id.listViewActivites);//Récupération de la ListView

        /* Association de la ListView avec un Adapter :
        * 1er paramètre : le contexte
        * 2ème paramètre : un tableau de données qui va représenter le contenu de la ListView
        */
        listview.setAdapter(new AdapterEcranActivitesEdition(this, romantiqueAmisFamille));

        mButtonAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranDaccueil.class));
            }
        });

        mButtonEdition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixActivitesRecapitulation.class));
            }
        });
    }
}