package fr.ig2i.perfectrip;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesRecapitulation;
import fr.ig2i.perfectrip.models.lieu.Lieu;

public class Call extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
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
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            return;
        }
        startActivity(callIntent);
    }
}
