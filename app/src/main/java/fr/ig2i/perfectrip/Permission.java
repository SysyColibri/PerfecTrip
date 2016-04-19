package fr.ig2i.perfectrip;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.RelativeLayout;

public class Permission {

    private RelativeLayout containerView;

    public void explain()
    {
        Snackbar.make(containerView, "Cette permission est nécessaire pour appeler", Snackbar.LENGTH_LONG).setAction("Activer", new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //demander l'autorisation
            }
        }).show();
    }
}
