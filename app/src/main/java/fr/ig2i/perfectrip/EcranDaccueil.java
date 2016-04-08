package fr.ig2i.perfectrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class EcranDaccueil extends AppCompatActivity {

    protected Button mPieton;
    protected Button mVelo;
    protected Button mVoiture;
    protected Button mRomantique;
    protected Button mAmis;
    protected Button mFamille;
    protected Button mAutres;

    protected Boolean moyenDeplacementPieton = false;
    protected Boolean moyenDeplacementVelo = false;
    protected Boolean moyenDeplacementVoiture = false;
    protected Boolean moyenDeplacementEtat = false;

    protected String moyenDeplacement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_daccueil);

        mPieton = (Button) findViewById(R.id.buttonPieton);
        mVelo = (Button) findViewById(R.id.buttonVelo);
        mVoiture = (Button) findViewById(R.id.buttonVoiture);
        mRomantique = (Button) findViewById(R.id.buttonRomantique);
        mAmis = (Button) findViewById(R.id.buttonAmis);
        mFamille = (Button) findViewById(R.id.buttonFamille);
        mAutres = (Button) findViewById(R.id.buttonAutres);

        mPieton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moyenDeplacementPieton = true;
                moyenDeplacementVelo = false;
                moyenDeplacementVoiture = false;
                moyenDeplacementEtat = true;
                setButtonsEnabledState();
                sauvegardeMoyenDeplacement("pieton");
            }
        });

        mVelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moyenDeplacementPieton = false;
                moyenDeplacementVelo = true;
                moyenDeplacementVoiture = false;
                moyenDeplacementEtat = true;
                setButtonsEnabledState();
                sauvegardeMoyenDeplacement("velo");
            }
        });

        mVoiture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moyenDeplacementPieton = false;
                moyenDeplacementVelo = false;
                moyenDeplacementVoiture = true;
                moyenDeplacementEtat = true;
                setButtonsEnabledState();
                sauvegardeMoyenDeplacement("voiture");
            }
        });

        mRomantique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat) {
                    startActivity(new Intent(EcranDaccueil.this, EcranChoixActivitesEdition.class));
                    sauvegardeTypeSortie("romantique");
                }
                else{Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();}
            }
        });

        mAmis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat) {
                    startActivity(new Intent(EcranDaccueil.this, EcranChoixActivitesEdition.class));
                    sauvegardeTypeSortie("amis");
                }
                else{Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();}
            }
        });

        mFamille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat) {
                    startActivity(new Intent(EcranDaccueil.this, EcranChoixActivitesEdition.class));
                    sauvegardeTypeSortie("famille");
                }
                else{
                    Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mAutres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat) {
                    startActivity(new Intent(EcranDaccueil.this, EcranChoixActivitesEdition.class));
                    sauvegardeTypeSortie("autres");
                }
                else{
                    Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
    Possibilité de ne selectionner qu'un moyen de déplacement
     */
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

    /*
    Sauvegarde du moyen de déplacement sélectionné
     */
    private void sauvegardeMoyenDeplacement(String moyenDeplacement){
        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput("moyenDeplacement.txt", MODE_PRIVATE));
            out.write(moyenDeplacement);
            out.close();
        } catch (java.io.IOException e) {
            Toast.makeText(getBaseContext(),"Impossible de sauvegarder le moyen de deplacement", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Sauvegarde du type de sortie
     */
    private void sauvegardeTypeSortie(String typeSortie){
        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput("typeSortie.txt", MODE_PRIVATE));
            out.write(typeSortie);
            out.close();
        } catch (java.io.IOException e) {
            Toast.makeText(getBaseContext(),"Impossible de sauvegarder le type de sortie", Toast.LENGTH_SHORT).show();
        }
    }
}
