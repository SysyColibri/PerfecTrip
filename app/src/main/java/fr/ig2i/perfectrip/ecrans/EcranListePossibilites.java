package fr.ig2i.perfectrip.ecrans;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.ig2i.perfectrip.Data;
import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.PerfectripApp;
import fr.ig2i.perfectrip.R;
import fr.ig2i.perfectrip.adapters.AdapterEcranListePossibilites;
import fr.ig2i.perfectrip.interfaces.Requete;
import fr.ig2i.perfectrip.models.LieuContainer;
import fr.ig2i.perfectrip.models.lieu.Lieu;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EcranListePossibilites extends ListActivity {

    Data data = new Data();
    GlobalState gs = new GlobalState();
    ArrayList<Lieu> lieuxPossible;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chargerLieux();
    }

    private void chargerLieux() {

        final ProgressDialog mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Récupération des données... Veuillez patienter.");
        mProgressDialog.show();

        Requete service = ((PerfectripApp) getApplicationContext()).getRetrofitService();
        Call<LieuContainer> call = service.getLieux(gs.latitude+","+gs.longitude, data.getRadius(gs.typeLocomotion).toString(), data.getLieu(gs.lieuEnCours), "AIzaSyC7hRH7RnYQcYCPlMbnIXeMCZ7LgVX134U");

        call.enqueue(new Callback<LieuContainer>() {
            @Override
            public void onResponse(Call<LieuContainer> call, Response<LieuContainer> response) {

                lieuxPossible = response.body().getResults();
                mProgressDialog.dismiss();
                if(lieuxPossible.size() == 0) {
                    /*ViewStub vs = ((ViewStub)findViewById(R.id.stub));
                    if(vs == null) {
                        Toast.makeText(getApplicationContext(),"TON VS EST POURRI FDP", Toast.LENGTH_LONG).show();
                    }
                    else {
                        vs.inflate();
                    }*/

                    Toast.makeText(getApplicationContext(),"Pas de résultats. Veuillez choisir un autre type de lieu.",Toast.LENGTH_LONG).show();
                }
                else {
                    listView = getListView();
                    TextView emptyView = (TextView) findViewById(R.id.textViewNoData);
                    listView.setEmptyView(emptyView);
                    AdapterEcranListePossibilites adapter = new AdapterEcranListePossibilites(getApplicationContext(), lieuxPossible);
                    listView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<LieuContainer> call, Throwable t) {
                //Si l'appel http a merdé
                mProgressDialog.dismiss();
                Log.i("HELLO", "HELLO KO");
            }
        });
    }
}
