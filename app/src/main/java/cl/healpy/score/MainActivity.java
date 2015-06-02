package cl.healpy.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import butterknife.InjectView;
import cl.healpy.score.adapters.ChampionshipRest;
import cl.healpy.score.adapters.PartidoAdapter;
import cl.healpy.score.config.ConfigChampionship;
import cl.healpy.score.models.ChampionshipDBHelper;
import cl.healpy.score.models.data.PartidoData;

public class MainActivity extends AppCompatActivity {

    private ConfigChampionship configChampionship;
    private ChampionshipRest championshipRest;
    private ChampionshipDBHelper partidoHelper;
    private RuntimeExceptionDao<PartidoData, Integer> partidoDao;
    private PartidoAdapter partidoAdapter;

    @InjectView(R.id.listView_partido)
    ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.variables();
        championshipRest.getRestAdapterChampionship();

        this.getPartido();

    }

    public void variables(){
        configChampionship = new ConfigChampionship(this);
        configChampionship.setToolbar();
        championshipRest = new ChampionshipRest(getApplicationContext());

        partidoHelper = OpenHelperManager.getHelper(getApplicationContext(), ChampionshipDBHelper.class);
        partidoDao = partidoHelper.getPartidoRuntimeDao();
    }

    public void getPartido() {
        try {
            QueryBuilder<PartidoData, Integer> partidoDB = partidoDao.queryBuilder();
            partidoDB.orderBy("fecha", false);
            final List<PartidoData> partidoAll = partidoDB.query();


            partidoAdapter = new PartidoAdapter(this, R.layout.activity_main, partidoAll);
            list_view.setAdapter(partidoAdapter);

            list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView textView_idPartido = (TextView) view.findViewById(R.id.textView_idPartido);
                    String partidoId = textView_idPartido.getText().toString();

                    Intent intent = new Intent(MainActivity.this, PartidoDetailActivity.class);
                    intent.putExtra("partidoId", partidoId);
                    startActivity(intent);

                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
