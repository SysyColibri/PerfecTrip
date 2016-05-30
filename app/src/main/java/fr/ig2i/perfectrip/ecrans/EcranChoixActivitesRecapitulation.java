package fr.ig2i.perfectrip.ecrans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.adapters.AdapterEcranActivitesRecapitulation;
import fr.ig2i.perfectrip.utils.FilesUtils;

import static android.support.v4.app.ActivityCompat.startActivity;

public class EcranChoixActivitesRecapitulation extends AppCompatActivity {

    protected Button mButtonAccueil;
    protected Button mButtonRecapitulation;
    FilesUtils f = new FilesUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_choix_activites_recapitulation);

        ListView listview;
        GlobalState gs = new GlobalState();

        setContentView(R.layout.activity_ecran_choix_activites_recapitulation);

        mButtonAccueil = (Button) findViewById(R.id.buttonAccueil);
        mButtonRecapitulation = (Button) findViewById(R.id.buttonRecapitulation);

        listview = (ListView) findViewById(R.id.listViewActivites);//Récupération de la ListView
        listview.setAdapter(new AdapterEcranActivitesRecapitulation(this, gs.activites));

        mButtonAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcranChoixActivitesRecapitulation.this, EcranDaccueil.class));
                finish();
            }
        });

        mButtonRecapitulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcranChoixActivitesRecapitulation.this, EcranChoixActivitesEdition.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {}
}
