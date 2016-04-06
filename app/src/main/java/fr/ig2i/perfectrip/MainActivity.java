package fr.ig2i.perfectrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
            }
        });

        mRomantique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat == true) {startActivity(new Intent(MainActivity.this, EcranChoixActivitesEdition.class));}
                else{Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();}
            }
        });

        mAmis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat == true) {startActivity(new Intent(MainActivity.this, EcranChoixActivitesEdition.class));}
                else{Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();}
            }
        });

        mFamille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat == true) {
                    startActivity(new Intent(MainActivity.this, EcranChoixActivitesEdition.class));
                }
                else{
                    Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mAutres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat == true) {
                    startActivity(new Intent(MainActivity.this, EcranChoixActivitesEdition.class));
                }
                else{
                    Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

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
}
