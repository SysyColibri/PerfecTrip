package fr.ig2i.perfectrip;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesRecapitulation;

public class Call extends Activity {
    private static final int MY_PERMISSIONS_REQUEST_CALL = 1;
    GlobalState gs = new GlobalState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(Call.this, EcranChoixActivitesRecapitulation.class));
        startCall();
    }

    public void startCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);

        Bundle extras = getIntent().getExtras();
        Integer id = extras.getInt("ID");
        String num = gs.activites.get(id).getLieu().getNumTel();

        callIntent.setData(Uri.parse("tel:" + num));
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)) {
                Toast.makeText(Call.this, "Veuillez autoriser la permission \"Téléphone\" dans Paramètres/Applications/PerfecTrip/Autorisations.", Toast.LENGTH_LONG).show();
                //Cela signifie que la permission à déjà était
                //demandé et l'utilisateur l'a refusé
                //Vous pouvez aussi expliquer à l'utilisateur pourquoi
                //cette permission est nécessaire et la redemander
            } else {
                //Sinon demander la permission
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSIONS_REQUEST_CALL);
                return;
            }
        }
        startActivity(callIntent);
    }
}
