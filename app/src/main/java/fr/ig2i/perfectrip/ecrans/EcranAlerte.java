package fr.ig2i.perfectrip.ecrans;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;

public class EcranAlerte extends AppCompatActivity {

    public EcranAlerte(final Activity activity, String title, String message, String textPositif, DialogInterface.OnClickListener listenerPositif) {
        AlertDialog LDialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(textPositif, listenerPositif).create();
        LDialog.show();
    }

    public EcranAlerte(final Activity activity, String title, String message, String textPositif, String textNegatif, DialogInterface.OnClickListener listenerPositif, DialogInterface.OnClickListener listenerNegatif) {
        AlertDialog LDialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(textPositif, listenerPositif)
                .setNegativeButton(textNegatif, listenerNegatif).create();
        LDialog.show();
    }
}
