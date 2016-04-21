package fr.ig2i.perfectrip.adapters;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesEdition;
import fr.ig2i.perfectrip.ecrans.EcranChoixTypeDeLieu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.ig2i.perfectrip.ecrans.EcranChoixTypeDeLieu;
import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.models.Activite;
import fr.ig2i.perfectrip.models.Lieu;

public class AdapterEcranListePossibilites extends ArrayAdapter<Lieu> implements ListAdapter  {

    Context context;
    ArrayList<Lieu> data = new ArrayList<Lieu>();
    GlobalState gs = new GlobalState();
    private static LayoutInflater inflater = null;

    public AdapterEcranListePossibilites(Context context, ArrayList<Lieu> data) {
        super(context,0,data);
        this.context = context;
        this.data = data;
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
        // Get the data item for this position
        final Lieu lieu = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_ecran_liste_possibilites, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.nom);
        TextView tvNote = (TextView) convertView.findViewById(R.id.note);
        TextView tvPrix = (TextView) convertView.findViewById(R.id.prix);

        tvName.setText(lieu.getName());
        if(lieu.getNote() != null) {
            tvNote.setText(lieu.getNote().toString());
        }
        if(lieu.getOrdrePrix() != null) {
            tvPrix.setText(lieu.getOrdrePrix().toString());
        }

        tvName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gs.activites.add(new Activite(gs.lieuEnCours,data.get(position),gs.activitesEnCours));
                Intent mainIntent = new Intent(context, EcranChoixActivitesEdition.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(mainIntent);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}

