package fr.ig2i.perfectrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EcranChoixActivitesEdition extends AppCompatActivity {

    String[] romantiqueAmisFamille = new String[]{"Cadeau", "Repas", "Sortie", "Hébergement", "Adresse particulière", "Autres"};
    String[] autres = new String[]{"Autres"};
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            setContentView(R.layout.activity_ecran_choix_activites_edition);
            mListView = (ListView) findViewById(R.id.listViewActivites);

            final String intentTypeSortieRetour = extras.getString("clefTypeSortie");

            switch (intentTypeSortieRetour) {
                case "romantique":
                    ArrayAdapter<String> adapterRomantique = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, romantiqueAmisFamille);
                    mListView.setAdapter(adapterRomantique);
                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            switch (position) {
                                case 0:
                                    Intent intentTypeSortieCadeau = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieCadeau.putExtra("clefTypeActivite", "romantiqueCadeau");
                                    startActivity(intentTypeSortieCadeau);
                                    break;
                                case 1:
                                    Intent intentTypeSortieRepas = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieRepas.putExtra("clefTypeActivite", "romantiqueRepas");
                                    startActivity(intentTypeSortieRepas);
                                    break;
                                case 2:
                                    Intent intentTypeSortieSortie = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieSortie.putExtra("clefTypeActivite", "romantiqueSortie");
                                    startActivity(intentTypeSortieSortie);
                                    break;
                                case 3:
                                    Intent intentTypeSortieHebergement = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieHebergement.putExtra("clefTypeActivite", "romantiqueHebergement");
                                    startActivity(intentTypeSortieHebergement);
                                    break;
                                case 4:
                                    Intent intentTypeSortieAdresse = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieAdresse.putExtra("clefTypeActivite", "romantiqueAdresse");
                                    startActivity(intentTypeSortieAdresse);
                                    break;
                                default:
                                    Intent intentTypeSortieAutres = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieAutres.putExtra("clefTypeActivite", "romantiqueAutres");
                                    startActivity(intentTypeSortieAutres);
                                    break;
                            }
                        }
                    });
                    break;
                case "amis":
                    ArrayAdapter<String> adapterAmis = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, romantiqueAmisFamille);
                    mListView.setAdapter(adapterAmis);
                    break;
                case "famille":
                    ArrayAdapter<String> adapterFamille = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, romantiqueAmisFamille);
                    mListView.setAdapter(adapterFamille);
                    break;
                default:
                    ArrayAdapter<String> adapterAutres = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, autres);
                    mListView.setAdapter(adapterAutres);
                    break;
            }

            /*mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (intentTypeSortieRetour) {
                        case "romantique":
                            switch (position) {
                                case 0:
                                    Intent intentTypeSortieCadeau = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieCadeau.putExtra("clefTypeActivite", "romantiqueCadeau");
                                    startActivity(intentTypeSortieCadeau);
                                    break;
                                case 1:
                                    Intent intentTypeSortieRepas = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieRepas.putExtra("clefTypeActivite", "romantiqueRepas");
                                    startActivity(intentTypeSortieRepas);
                                    break;
                                case 2:
                                    Intent intentTypeSortieSortie = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieSortie.putExtra("clefTypeActivite", "romantiqueSortie");
                                    startActivity(intentTypeSortieSortie);
                                    break;
                                case 3:
                                    Intent intentTypeSortieHebergement = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieHebergement.putExtra("clefTypeActivite", "romantiqueHebergement");
                                    startActivity(intentTypeSortieHebergement);
                                    break;
                                case 4:
                                    Intent intentTypeSortieAdresse = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieAdresse.putExtra("clefTypeActivite", "romantiqueAdresse");
                                    startActivity(intentTypeSortieAdresse);
                                    break;
                                default:
                                    Intent intentTypeSortieAutres = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieAutres.putExtra("clefTypeActivite", "romantiqueAutres");
                                    startActivity(intentTypeSortieAutres);
                                    break;
                            }
                        case "amis":
                            switch (position) {
                                case 0:
                                    Intent intentTypeSortieCadeau = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieCadeau.putExtra("clefTypeActivite", "amisCadeau");
                                    startActivity(intentTypeSortieCadeau);
                                    break;
                                case 1:
                                    Intent intentTypeSortieRepas = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieRepas.putExtra("clefTypeActivite", "amisRepas");
                                    startActivity(intentTypeSortieRepas);
                                    break;
                                case 2:
                                    Intent intentTypeSortieSortie = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieSortie.putExtra("clefTypeActivite", "amisSortie");
                                    startActivity(intentTypeSortieSortie);
                                    break;
                                case 3:
                                    Intent intentTypeSortieHebergement = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieHebergement.putExtra("clefTypeActivite", "amisHebergement");
                                    startActivity(intentTypeSortieHebergement);
                                    break;
                                case 4:
                                    Intent intentTypeSortieAdresse = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieAdresse.putExtra("clefTypeActivite", "amisAdresse");
                                    startActivity(intentTypeSortieAdresse);
                                    break;
                                default:
                                    Intent intentTypeSortieAutres = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieAutres.putExtra("clefTypeActivite", "amisAutres");
                                    startActivity(intentTypeSortieAutres);
                                    break;
                            }
                        case "famille":
                            switch (position) {
                                case 0:
                                    Intent intentTypeSortieCadeau = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieCadeau.putExtra("clefTypeActivite", "familleCadeau");
                                    startActivity(intentTypeSortieCadeau);
                                    break;
                                case 1:
                                    Intent intentTypeSortieRepas = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieRepas.putExtra("clefTypeActivite", "familleRepas");
                                    startActivity(intentTypeSortieRepas);
                                    break;
                                case 2:
                                    Intent intentTypeSortieSortie = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieSortie.putExtra("clefTypeActivite", "familleSortie");
                                    startActivity(intentTypeSortieSortie);
                                    break;
                                case 3:
                                    Intent intentTypeSortieHebergement = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieHebergement.putExtra("clefTypeActivite", "familleHebergement");
                                    startActivity(intentTypeSortieHebergement);
                                    break;
                                case 4:
                                    Intent intentTypeSortieAdresse = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieAdresse.putExtra("clefTypeActivite", "familleAdresse");
                                    startActivity(intentTypeSortieAdresse);
                                    break;
                                default:
                                    Intent intentTypeSortieAutres = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                                    intentTypeSortieAutres.putExtra("clefTypeActivite", "familleAutres");
                                    startActivity(intentTypeSortieAutres);
                                    break;
                            }
                        default:
                            Intent intentTypeSortieAutres = new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class);
                            intentTypeSortieAutres.putExtra("clefTypeActivite", "autresAutres");
                            startActivity(intentTypeSortieAutres);
                            break;
                    }
                }
            });*/


        }
    }
}
