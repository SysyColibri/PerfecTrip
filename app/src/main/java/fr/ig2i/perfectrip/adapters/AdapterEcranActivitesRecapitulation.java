package fr.ig2i.perfectrip.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.ig2i.perfectrip.Call;
import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.GoogleMap;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesEdition;
import fr.ig2i.perfectrip.ecrans.EcranChoixActivitesRecapitulation;
import fr.ig2i.perfectrip.ecrans.EcranDaccueil;
import fr.ig2i.perfectrip.ecrans.EcranListePossibilites;
import fr.ig2i.perfectrip.models.Activite;
import fr.ig2i.perfectrip.utils.FilesUtils;


public class AdapterEcranActivitesRecapitulation extends ArrayAdapter {

    Context context;
    ArrayList<Activite> data;
    GlobalState gs = new GlobalState();
    FilesUtils fu = new FilesUtils();
    private static LayoutInflater inflater = null;


    public AdapterEcranActivitesRecapitulation(Context context, ArrayList<Activite> data) {
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
    public Object getItem(int position) {
        //Permet d'obtenir un item de la listview avec son indice passé en paramètre
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.ligne_ecran_activites_recapitulation, null);
        }
        //Récupération des zones de texte
        TextView text = (TextView) vi.findViewById(R.id.text);
        //on mets les intitulé de manière automatique
        text.setText(data.get(position).getLieu().getName());

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position).getLieu().getNumTel(),Toast.LENGTH_SHORT);
            }
        });

        /*
        Bouton téléphone
         */
        ImageView telephone = (ImageView) vi.findViewById(R.id.telephone);
        System.out.println("data.get(position).getLieu().getNumTel(): " +data.get(position).getLieu().getNumTel());
        if(data.get(position).getLieu().getNumTel() == null) {
            telephone.setBackgroundColor(Color.TRANSPARENT);
        }

        telephone.setTag(data.get(position)); //Ajout d'un identifiant unique sur chaque image
        if(data.get(position).getLieu().getNumTel() != null) {
            telephone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data.get(position).getLieu().getNumTel() == null) {
                        Toast.makeText(context, "PAS DE TEL", Toast.LENGTH_SHORT).show();
                    }
                    gs.activitesEnCours = v.getTag().toString();
                    Intent mainIntent = new Intent(context, Call.class);
                    mainIntent.putExtra("ID", position);
                    ((Activity)context).finish();
                    context.startActivity(mainIntent);

                }
            });
        }
        /*
        Bouton GPS
         */
        ImageView gps = (ImageView)vi.findViewById(R.id.gps); //Récupération des images
        gps.setTag(data.get(position)); //Ajout d'un identifiant unique sur chaque image
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gs.activitesEnCours = v.getTag().toString();
                Intent mainIntent = new Intent(context, GoogleMap.class);
                mainIntent.putExtra("ID",position);
                context.startActivity(mainIntent);
            }
        });

        /*
        Bouton poubelle
         */
        ImageView delete = (ImageView)vi.findViewById(R.id.delete); //Récupération des images
        delete.setTag(data.get(position)); //Ajout d'un identifiant unique sur chaque image
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i  = 0;
                while(gs.activites.get(i).getLieu().getId() != data.get(position).getLieu().getId()) {
                    i++;
                }
                fu.delete(getContext(), data.get(position).getLieu().getId());
                gs.activites.remove(i);
                refresh(gs.activites);
            }
        });
        refresh(data);
        return vi;
    }

    public void refresh(ArrayList<Activite> activites) {
        notifyDataSetChanged();
    }
}