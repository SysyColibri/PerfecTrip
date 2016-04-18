package fr.ig2i.perfectrip;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class Call extends AppCompatActivity {

    Lieu lieu = new Lieu();
    private static final int REQUEST_CALL = 1;

    //1 On trouve le numero du coorespondant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(Call.this, EcranChoixActivitesRecapitulation.class));
        startCall();
    }

    public void startCall() {
        System.out.println("START INTENT");
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + lieu.getNumTel()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("START REQUEST");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            return;
        }
        startActivity(callIntent);
    }
}
