package fr.ig2i.perfectrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;

public class EcranChoixActivitesEdition extends AppCompatActivity {

    ListView listview;
    GlobalState gs = new GlobalState();
    ImageButton add;
    String[] romantiqueAmisFamille = new String[]{"Cadeau", "Repas", "Sortie", "Hébergement", "Autres"};

    protected Switch mSwitchRecapitulation;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_activites_edition);

        mSwitchRecapitulation = (Switch) findViewById(R.id.switchRecapitulation);

        listview = (ListView) findViewById(R.id.listViewActivites);//Récupération de la ListView

        /* Association de la ListView avec un Adapter :
        * 1er paramètre : le contexte
        * 2ème paramètre : un tableau de données qui va représenter le contenu de la ListView
        */
        listview.setAdapter(new AdapterEcranActivitesEdition(this, romantiqueAmisFamille));

        //Toast.makeText(getApplicationContext(),gs.typeSortie,Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(),gs.typeLocomotion,Toast.LENGTH_LONG).show();

        mSwitchRecapitulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixActivitesRecapitulation.class));
            }
        });
    }

    /*
    Verrouillage du switch
     
    private void setButtonsEnabledState() {
        if (moyenDeplacementPieton) {
            mPieton.setEnabled(false);
            mVelo.setEnabled(true);
            mVoiture.setEnabled(true);
        } else if (moyenDeplacementVelo){
            mPieton.setEnabled(true);
            mVelo.setEnabled(false);
            mVoiture.setEnabled(true);
        }else if (moyenDeplacementVoiture){
            mPieton.setEnabled(true);
            mVelo.setEnabled(true);
            mVoiture.setEnabled(false);
        }else {
            mPieton.setEnabled(true);
            mVelo.setEnabled(true);
            mVoiture.setEnabled(true);
        }
    }
    */

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