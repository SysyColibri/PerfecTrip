package fr.ig2i.perfectrip.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import fr.ig2i.perfectrip.ecrans.EcranChoixTypeDeLieu;
import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.R;

public class AdapterEcranActivitesEdition extends BaseAdapter {

    Context context;
    String[] data;
    GlobalState gs = new GlobalState();
    private static LayoutInflater inflater = null;

    public AdapterEcranActivitesEdition(Context context, String[] data) {
        this.context = context;
        this.data = data;
        //Prend les fichiers xml pour mettre en forme nos Views
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //Permet d'obtenir la taille du tableau de données et donc le nomre d'item de la listview
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        //Permet d'obtenir un item de la listview avec son indice passé en paramètre
        return data[position];
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
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.ligne_ecran_activites_edition, null);
        //Récupération des zones de texte
        TextView text = (TextView) vi.findViewById(R.id.text);
        //on mets les intitulé de manière automatique
        text.setText(data[position]);

        ImageView add = (ImageView)vi.findViewById(R.id.add); //Récupération des images '+'
        add.setTag(data[position]); //Ajout d'un identifiant unique sur chaque image
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("DEBUT ACTIVITY TYPE DE LIEU");
                gs.activitesEnCours = v.getTag().toString();
                //Toast.makeText(context, "Ajouter un(e)"+v.getTag().toString(), Toast.LENGTH_SHORT).show();
                Intent mainIntent = new Intent(context, EcranChoixTypeDeLieu.class);
                context.startActivity(mainIntent);
            }
        });
        return vi;
    }
}
