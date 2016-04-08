package fr.ig2i.perfectrip;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;

public class EcranAlerte extends AppCompatActivity {

    public Activity activity;

    public EcranAlerte(final Activity activity, String title, String message, String textButton, DialogInterface.OnClickListener listener) {
        this.activity = activity;
        AlertDialog LDialog = new AlertDialog.Builder(this.activity)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(textButton, listener).create();
        LDialog.show();
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_pas_de_reseau);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/
}
