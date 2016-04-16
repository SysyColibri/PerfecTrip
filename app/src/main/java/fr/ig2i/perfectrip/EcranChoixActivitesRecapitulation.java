package fr.ig2i.perfectrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class EcranChoixActivitesRecapitulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_activites_recapitulation);

        ListView listview;
        GlobalState gs = new GlobalState();

        setContentView(R.layout.activity_ecran_choix_activites_recapitulation);

        listview = (ListView) findViewById(R.id.listViewActivites);//Récupération de la ListView
        listview.setAdapter(new AdapterEcranActivitesRecapitulation(this, gs.activites));
    }
}
