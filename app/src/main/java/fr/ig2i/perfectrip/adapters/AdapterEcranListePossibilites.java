package fr.ig2i.perfectrip.adapters;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.ecrans.EcranAlerte;
import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesEdition;
import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesRecapitulation;
import fr.ig2i.perfectrip.models.Activite;
import fr.ig2i.perfectrip.models.lieu.Lieu;
import fr.ig2i.perfectrip.models.lieu.opening_hours;
import fr.ig2i.perfectrip.utils.FilesUtils;
import fr.ig2i.perfectrip.utils.HTTPNumeroUtils;

public class AdapterEcranListePossibilites extends ArrayAdapter<Lieu> implements ListAdapter {

    Context context;
    ArrayList<Lieu> data = new ArrayList<Lieu>();
    FilesUtils filesUtils = new FilesUtils();
    GlobalState gs = new GlobalState();
    private static LayoutInflater inflater = null;
    private Activity activity;

    public AdapterEcranListePossibilites(Activity activity, Context context, ArrayList<Lieu> data) {
        super(context,0,data);
        this.context = context;
        this.data = data;
        this.activity = activity;
        //Prend les fichiers xml pour mettre en forme nos Views
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //Permet d'obtenir la taille du tableau de données et donc le nomre d'item de la listview
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    /*
    Contient les traitements pour la génération des items
    On n'appellera pas cette méthode, c'est l'adapter qui va l'appeler implicitement quand un item doit etre créé
    */
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Lieu lieu = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_ecran_liste_possibilites, parent, false);
        }

        TextView tvOpen = (TextView) convertView.findViewById(R.id.open);
        tvOpen.setText("");
        if(lieu.getOpeningHours() == null) {
            tvOpen.setText("Horaires inconnus");
            tvOpen.setTextColor(Color.parseColor("#fc8710"));
            lieu.setOpeningHours(new opening_hours(true, null, null)); // Si null, on mets true
        }

        if(lieu.getOpeningHours().getOpenNow() == false) {
            tvOpen.setText("Fermé");
            tvOpen.setTextColor(Color.RED);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.nom);
        TextView tvNote = (TextView) convertView.findViewById(R.id.note);
        TextView tvPrix = (TextView) convertView.findViewById(R.id.prix);

        tvName.setText(lieu.getName());
        if (lieu.getRating() != null) {
            tvNote.setText(lieu.getRating().toString());
            if(0<1){
                tvNote.setText("Note: " +lieu.getRating().toString()+ "/5");
                tvNote.setTextColor(Color.parseColor("#009933"));
            } else if(1<2){
                tvNote.setText("Note: " +lieu.getRating().toString()+ "/5");
                tvNote.setTextColor(Color.parseColor("#99cc00"));
            } else if(2<3){
                tvNote.setText("Note: " +lieu.getRating().toString()+ "/5");
                tvNote.setTextColor(Color.parseColor("#ff9900"));
            }
            else if(3<4){
                tvNote.setText("Note: " +lieu.getRating().toString()+ "/5");
                tvNote.setTextColor(Color.parseColor("#ff3300"));
            }
            else{
                tvNote.setText("Note: " +lieu.getRating().toString()+ "/5");
                tvNote.setTextColor(Color.parseColor("#ff0000"));
            }
        }
        //ordre de prix
        if (lieu.getPriceLevel() != null) {
            switch (lieu.getPriceLevel()) {
                case 1:
                    tvPrix.setText("€");
                    tvPrix.setTextColor(Color.parseColor("#009933"));
                    break;
                case 2:
                    tvPrix.setText("€€");
                    tvPrix.setTextColor(Color.parseColor("#99cc00"));
                    break;
                case 3:
                    tvPrix.setText("€€€");
                    tvPrix.setTextColor(Color.parseColor("#ff9900"));
                    break;
                case 4:
                    tvPrix.setText("€€€€");
                    tvPrix.setTextColor(Color.parseColor("#ff3300"));
                    break;
                case 5:
                    tvPrix.setText("€€€€€");
                    tvPrix.setTextColor(Color.parseColor("#ff0000"));
                    break;
                default:
                    tvPrix.setText("");
                    break;
            }
        }

        LinearLayout barre = (LinearLayout) convertView.findViewById(R.id.ecranListePossibilites); //Récupération des images
        barre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(lieu.getOpeningHours().getOpenNow()==false) {
                    new EcranAlerte(activity, "Attention",
                            "Vous êtes en dehors des heures d'ouvertures.",
                            "Continuer",
                            "Annuler",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    HTTPNumeroUtils caller = new HTTPNumeroUtils(lieu.getPlaceId(), activity) {
                                        @Override
                                        public void onResponseReceived(Object result) {
                                            if(result != null) {
                                                data.get(position).setNumTel(result.toString().replace(" ", ""));}
                                        }
                                    };
                                    caller.execute();
                                    ajoutRecapitulation(position,lieu);
                                }
                            },
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                } else {
                    HTTPNumeroUtils caller = new HTTPNumeroUtils(lieu.getPlaceId(), activity) {
                        @Override
                        public void onResponseReceived(Object result) {
                            if(result != null) {
                                data.get(position).setNumTel(result.toString().replace(" ", ""));
                            }
                            ajoutRecapitulation(position,data.get(position));
                        }
                    };
                    caller.execute();

                }
            }
        });

        return convertView;
    }

    public void ajoutRecapitulation(int position, Lieu lieu) {
        Activite a = new Activite(gs.lieuEnCours, lieu, gs.activitesEnCours);
        gs.activites.add(a);
        Intent mainIntent = new Intent(context, EcranChoixActivitesRecapitulation.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mainIntent);
        Log.i("test",filesUtils.getFilesLocation(context));
        filesUtils.set(context, data.get(position).getId(),a);
        FilesUtils f = new FilesUtils();
    }
}
