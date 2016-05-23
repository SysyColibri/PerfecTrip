package fr.ig2i.perfectrip.ecrans;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;
    private static final int MY_PERMISSIONS_REQUEST_CALL = 2;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_daccueil);

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(EcranDaccueil.this, "Veuillez autoriser la permission \"Position\" dans Paramètres/Applications/PerfecTrip/Autorisations.", Toast.LENGTH_LONG).show();
                //Cela signifie que la permission à déjà était demandé et l'utilisateur l'a refusé
                //Vous pouvez aussi expliquer à l'utilisateur pourquoi cette permission est nécessaire et la redemander
            } else {
                //Sinon demander la permission
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)) {
                Toast.makeText(EcranDaccueil.this, "Veuillez autoriser la permission \"Téléphone\" dans Paramètres/Applications/PerfecTrip/Autorisations.", Toast.LENGTH_LONG).show();
                //Cela signifie que la permission à déjà était
                //demandé et l'utilisateur l'a refusé
                //Vous pouvez aussi expliquer à l'utilisateur pourquoi
                //cette permission est nécessaire et la redemander
            } else {
                //Sinon demander la permission
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSIONS_REQUEST_CALL);
            }
        }

        gs = new GlobalState();
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
                    finish();
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
                    finish();
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
                    finish();
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
                    finish();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean onKeyDown(){
        Toast.makeText(getBaseContext(), "Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_SHORT).show();
        return true;
    }
}
