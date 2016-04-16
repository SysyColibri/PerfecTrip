package fr.ig2i.perfectrip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class EcranListePossibilites extends AppCompatActivity {

    DataListePossibilites data = new DataListePossibilites();
    GlobalState gs = new GlobalState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_liste_possibilites);

        Toast.makeText(getBaseContext(), "Mot clef lieu: " +data.getLieu(gs.lieuEnCours), Toast.LENGTH_SHORT).show();
    }
}
