package fr.ig2i.perfectrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
    protected Boolean moyenDeplacmeentEtat = false;


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
                moyenDeplacmeentEtat = true;
                setButtonsEnabledState();
            }
        });

        mVelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moyenDeplacementPieton = false;
                moyenDeplacementVelo = true;
                moyenDeplacementVoiture = false;
                moyenDeplacmeentEtat = true;
                setButtonsEnabledState();
            }
        });

        mVoiture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moyenDeplacementPieton = false;
                moyenDeplacementVelo = false;
                moyenDeplacementVoiture = true;
                moyenDeplacmeentEtat = true;
                setButtonsEnabledState();
            }
        });

        mRomantique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacmeentEtat == true) {
                    startActivity(new Intent(MainActivity.this, EcranChoixActivitesEdition.class));
                }
                else{
                    Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_LONG).show();
                }
            }
        });

        mAmis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacmeentEtat == true) {
                    startActivity(new Intent(MainActivity.this, EcranChoixActivitesEdition.class));
                }
                else{
                    Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_LONG).show();
                }
            }
        });

        mFamille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacmeentEtat == true) {
                    startActivity(new Intent(MainActivity.this, EcranChoixActivitesEdition.class));
                }
                else{
                    Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_LONG).show();
                }
            }
        });

        mAutres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moyenDeplacmeentEtat == true) {
                    startActivity(new Intent(MainActivity.this, EcranChoixActivitesEdition.class));
                }
                else{
                    Toast.makeText(getBaseContext(),"Vous devez d'abord définir le moyen de déplacement.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
