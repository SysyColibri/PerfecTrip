package fr.ig2i.perfectrip.ecrans;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import fr.ig2i.perfectrip.Data;
import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.adapters.AdapterEcranChoixTypeDeLieu;

public class EcranChoixTypeDeLieu extends AppCompatActivity {

    ListView mListView;
    GlobalState gs = new GlobalState();
    Data data = new Data();

    Localisation local = new Localisation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_ecran_choix_type_de_lieu);
            mListView = (ListView) findViewById(R.id.listViewActivites);

            switch (gs.typeSortie+gs.activitesEnCours) {
                case "romantiqueCadeau":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.romantiqueCadeau));
                    break;
                case "romantiqueRepas":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.romantiqueRepas));
                    break;
                case "romantiqueSortie":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.romantiqueSortie));
                    break;
                case "romantiqueHébergement":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.romantiqueHébergement));
                    break;
                case "amisCadeau":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.amisCadeau));
                    break;
                case "amisRepas":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.amisRepas));
                    break;
                case "amisSortie":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.amisSortie));
                    break;
                case "amisHébergement":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.amisHébergement));
                    break;
                case "familleCadeau":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.familleCadeau));
                    break;
                case "familleRepas":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.familleRepas));
                    break;
                case "familleSortie":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.familleSortie));
                    break;
                case "familleHébergement":
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.familleHébergement));
                    break;
                default:
                    mListView.setAdapter(new AdapterEcranChoixTypeDeLieu(this, data.autres));
                    break;
            }
        }
}