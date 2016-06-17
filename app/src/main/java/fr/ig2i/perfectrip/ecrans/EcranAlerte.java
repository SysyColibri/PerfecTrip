package fr.ig2i.perfectrip.ecrans;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;

public class EcranAlerte extends Activity {
    private Activity activity;

    public EcranAlerte(Activity activity, String title, String message, String textPositif, DialogInterface.OnClickListener listenerPositif) {
        this.activity = activity;
        AlertDialog LDialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(textPositif, listenerPositif).create();
        LDialog.show();
        LDialog.setCanceledOnTouchOutside(false);
    }

    public EcranAlerte(Activity activity, String title, String message, String textPositif, String textNegatif, DialogInterface.OnClickListener listenerPositif, DialogInterface.OnClickListener listenerNegatif) {
        this.activity = activity;
        AlertDialog LDialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(textPositif, listenerPositif)
                .setNegativeButton(textNegatif, listenerNegatif).create();
        LDialog.show();
        LDialog.setCanceledOnTouchOutside(false);
    }
}
