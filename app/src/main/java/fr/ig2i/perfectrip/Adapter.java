package fr.ig2i.perfectrip;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class Adapter extends BaseAdapter {

    Context context;
    String[] data;
    private static LayoutInflater inflater = null;

    public Adapter(Context context, String[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.ligne, null);
        TextView text = (TextView) vi.findViewById(R.id.text);
        text.setText(data[position]);

        ImageView add = (ImageView)vi.findViewById(R.id.add); //Récupération des images '+'
        add.setTag(data[position]); //Ajout d'un identifiant unique sur chaque image
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Ajouter un(e)"+v.getTag().toString(), Toast.LENGTH_SHORT).show();
                Intent mainIntent = new Intent(context, EcranChoixTypeDeLieu.class);
                //Sauvegarder le choix de l'utilisateur
                context.startActivity(mainIntent);
            }
        });


        return vi;
    }
}
