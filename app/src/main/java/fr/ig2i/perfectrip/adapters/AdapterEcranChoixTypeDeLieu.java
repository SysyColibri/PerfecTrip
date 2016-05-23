package fr.ig2i.perfectrip.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.ecrans.EcranListePossibilites;


public class AdapterEcranChoixTypeDeLieu extends BaseAdapter {

    Context context;
    String[] data;
    private static LayoutInflater inflater = null;
    GlobalState gs = new GlobalState();

    public AdapterEcranChoixTypeDeLieu(Context context, String[] data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//Prend les fichiers xml pour mettre en forme nos Views
    }

    @Override
    public int getCount() {
        return data.length;//Permet d'obtenir la taille du tableau de données et donc le nombre d'item de la listview
    }

    @Override
    public Object getItem(int position) {
        return data[position];//Permet d'obtenir un item de la listview avec son indice passé en paramètre
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    //Contient les traitements pour la génération des items
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.ligne_ecran_choix_type_de_lieu, null);
        //Récupération des zones de texte
        TextView text = (TextView) vi.findViewById(R.id.text);
        //on mets les intitulé de manière automatique
        text.setText(data[position]);

        LinearLayout barre = (LinearLayout) vi.findViewById(R.id.choixTypeDeLieux); //Récupération des images
        barre.setTag(data[position]); //Ajout d'un identifiant unique sur chaque image
        barre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gs.lieuEnCours = v.getTag().toString();//Enregistre le lieu choisit par le user
                Intent mainIntent = new Intent(context, EcranListePossibilites.class);
                context.startActivity(mainIntent);
                ((Activity)context).finish();
            }
        });

        return vi;
    }
}
