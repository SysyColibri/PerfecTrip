package fr.ig2i.perfectrip;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EcranChoixActivitesEdition extends AppCompatActivity {

    ListView listview;
    ImageButton add;
    String[] romantiqueAmisFamille = new String[]{"Cadeau", "Repas", "Sortie", "Hébergement", "Adresse particulière", "Autres"};


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_activites_edition);
        listview = (ListView) findViewById(R.id.listViewActivites);
        listview.setAdapter(new Adapter(this, romantiqueAmisFamille));

    }

    public void addListenerOnButton() {

        add = (ImageButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Passage a l'activité suivante
                Toast.makeText(getApplicationContext(),"t'as cliqué ptdr",Toast.LENGTH_LONG).show();
            }

        });

    }
}