package fr.ig2i.perfectrip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

public class EcranChoixActivitesRecapitulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_activites_recapitulatif);

        ListView listview;
        GlobalState gs = new GlobalState();
        ImageButton add;
        String[] romantiqueAmisFamille = new String[]{"Cadeau", "Repas", "Sortie", "Hébergement", "Autres"};

        setContentView(R.layout.activity_ecran_choix_activites_edition);

        listview = (ListView) findViewById(R.id.listViewActivites);//Récupération de la ListView
        listview.setAdapter(new AdapterEcranActivitesEdition(this, romantiqueAmisFamille));
    }
}
