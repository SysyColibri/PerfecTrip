package fr.ig2i.perfectrip.ecrans;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;

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

    protected GlobalState gs;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_daccueil);

        gs = new GlobalState();
        mPieton = (Button) findViewById(R.id.buttonPieton);
        mVelo = (Button) findViewById(R.id.buttonVelo);
        mVoiture = (Button) findViewById(R.id.buttonVoiture);
        mRomantique = (Button) findViewById(R.id.buttonRomantique);
        mAmis = (Button) findViewById(R.id.buttonAmis);
        mFamille = (Button) findViewById(R.id.buttonFamille);
        mAutres = (Button) findViewById(R.id.buttonAutres);



        /*
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, 2);
            requestPermissions(new String[] { Manifest.permission.ACCESS_COARSE_LOCATION }, 2);
            requestPermissions(new String[] { Manifest.permission.CALL_PHONE }, 2);
        }
        */

        mPieton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moyenDeplacementPieton = true;
                moyenDeplacementVelo = false;
                moyenDeplacementVoiture = false;
                moyenDeplacementEtat = true;
                setButtonsEnabledState();
                gs.typeLocomotion = "pieton";
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
                gs.typeLocomotion = "velo";
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
                gs.typeLocomotion = "voiture";
            }
        });

        mRomantique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat) {
                    gs.typeSortie = "romantique";
                    startActivity(new Intent(EcranDaccueil.this, EcranChoixActivitesEdition.class));
                }
                else{Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();}
            }
        });

        mAmis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacementEtat) {
                    gs.typeSortie = "amis";
                    startActivity(new Intent(EcranDaccueil.this, EcranChoixActivitesEdition.class));
                }
                else{Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();}
            }
        });

        mFamille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moyenDeplacementEtat) {
                    gs.typeSortie = "famille";
                    startActivity(new Intent(EcranDaccueil.this, EcranChoixActivitesEdition.class));
                } else {
                    Toast.makeText(getBaseContext(), "Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mAutres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moyenDeplacementEtat) {
                    gs.typeSortie = "autre";
                    startActivity(new Intent(EcranDaccueil.this, EcranChoixActivitesEdition.class));
                } else {
                    Toast.makeText(getBaseContext(), "Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();
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
}