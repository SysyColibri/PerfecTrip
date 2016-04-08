package fr.ig2i.perfectrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EcranChoixActivitesEdition extends AppCompatActivity {

    String[] romantiqueAmisFamille = new String[]{"Cadeau", "Repas", "Sortie", "Hébergement", "Adresse particulière", "Autres"};
    String[] autres = new String[]{"Autres"};
    String typeSortie;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        typeSortie = recuperationValeurFichier("typeSortie.txt");

        setContentView(R.layout.activity_ecran_choix_activites_edition);
        mListView = (ListView) findViewById(R.id.listViewActivites);
        switch (typeSortie) {
            case "romantique":
                ArrayAdapter<String> adapterRomantique = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, romantiqueAmisFamille);
                mListView.setAdapter(adapterRomantique);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("cadeau");
                                break;
                            case 1:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("repas");
                                break;
                            case 2:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("sortie");
                                break;
                            case 3:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("hebergement");
                                break;
                            case 4:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("adresse");
                                break;
                            default:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("autres");
                                break;
                        }
                    }
                });
                break;
            case "amis":
                ArrayAdapter<String> adapterAmis = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, romantiqueAmisFamille);
                mListView.setAdapter(adapterAmis);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("cadeau");
                                break;
                            case 1:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("repas");
                                break;
                            case 2:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("sortie");
                                break;
                            case 3:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("hebergement");
                                break;
                            case 4:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("adresse");
                                break;
                            default:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("autres");
                                break;
                        }
                    }
                });
                break;
            case "famille":
                ArrayAdapter<String> adapterFamille = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, romantiqueAmisFamille);
                mListView.setAdapter(adapterFamille);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("cadeau");
                                break;
                            case 1:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("repas");
                                break;
                            case 2:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("sortie");
                                break;
                            case 3:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("hebergement");
                                break;
                            case 4:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("adresse");
                                break;
                            default:
                                startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                                sauvegardeActivite("autres");
                                break;
                        }
                    }
                });
                break;
            default:
                ArrayAdapter<String> adapterAutres = new ArrayAdapter<String>(EcranChoixActivitesEdition.this, android.R.layout.simple_list_item_1, autres);
                mListView.setAdapter(adapterAutres);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        startActivity(new Intent(EcranChoixActivitesEdition.this, EcranChoixTypeDeLieu.class));
                    }
                });
                break;
        }
    }

    /*
    Sauvegarde du type activité
     */
    private void sauvegardeActivite(String typeActivite){
        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput("typeActivite.txt", MODE_PRIVATE));
            out.write(typeActivite);
            out.close();
        } catch (java.io.IOException e) {
            Toast.makeText(getBaseContext(), "Impossible de sauvegarder le type de sortie", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Récupération de la valeur d'un .txt
     */
    private String recuperationValeurFichier(String fichier){
        String retour = null;
        try
        {
            //On ouvre le .txt
            InputStream instream = openFileInput(fichier);
            //prepare le .txt pour lecture
            InputStreamReader inputreader = new InputStreamReader(instream);
            BufferedReader br = new BufferedReader (inputreader);

            try
            {
                //On écrit la valeur de la première ligne dans le String
                retour = br.readLine();
                br.close();
                inputreader.close();
            }
            catch (IOException exception)
            {
                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("Le fichier n'a pas été trouvé");
        }
        return retour;
    }
}
