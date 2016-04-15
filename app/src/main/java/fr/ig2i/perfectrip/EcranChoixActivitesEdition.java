package fr.ig2i.perfectrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ListView;

public class EcranChoixActivitesEdition extends AppCompatActivity {

    ListView listview;
    GlobalState gs;
    ImageButton add;
    String[] romantiqueAmisFamille = new String[]{"Cadeau", "Repas", "Sortie", "Hébergement", "Autres"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ecran_choix_activites_edition);

        listview = (ListView) findViewById(R.id.listViewActivites);//Récupération de la ListView

        /* Association de la ListView avec un Adapter :
        * 1er paramètre : le contexte
        * 2ème paramètre : un tableau de données qui va représenter le contenu de la ListView
        */
        listview.setAdapter(new AdapterEcranActivitesEdition(this, romantiqueAmisFamille));

        gs = new GlobalState();

        //Toast.makeText(getApplicationContext(),gs.typeSortie,Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(),gs.typeLocomotion,Toast.LENGTH_LONG).show();
    }

    /*public void addListenerOnButton() {

        add = (ImageButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(),"t'as cliqué ptdr",Toast.LENGTH_LONG).show();
            }
        });
    }*/
}