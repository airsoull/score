package cl.healpy.score;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.squareup.picasso.Picasso;


import butterknife.InjectView;
import cl.healpy.score.adapters.ChampionshipRest;
import cl.healpy.score.config.ConfigChampionship;
import cl.healpy.score.models.ChampionshipDBHelper;
import cl.healpy.score.models.data.PartidoData;

public class PartidoDetailActivity extends AppCompatActivity {

    private String partidoID;
    private ConfigChampionship configChampionship;
    private ChampionshipRest championshipRest;

    @InjectView(R.id.img_escudoVisita)
    ImageView img_visita;
    @InjectView(R.id.img_escudoLocal)
    ImageView img_escudoLocal;
    @InjectView(R.id.textView_nombreVisita)
    TextView textView_nombreVisita;
    @InjectView(R.id.textView_nombreLocal)
    TextView textView_nombreLocal;
    @InjectView(R.id.textView_golVisita)
    TextView textView_golVisita;
    @InjectView(R.id.textView_golLocal)
    TextView textView_golLocal;
    @InjectView(R.id.textView_ciudad)
    TextView textView_ciudad;
    @InjectView(R.id.textView_estadio)
    TextView textView_estadio;
    @InjectView(R.id.textView_hora)
    TextView textView_hora;
    @InjectView(R.id.textView_nombreArbitro)
    TextView textView_nombreArbitro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_detail);

        this.variables();

        ChampionshipDBHelper partidoHelper = OpenHelperManager.getHelper(getApplicationContext(), ChampionshipDBHelper.class);
        RuntimeExceptionDao<PartidoData, Integer> partidoDao = partidoHelper.getPartidoRuntimeDao();

        PartidoData partidoDetail = partidoDao.queryForId(Integer.parseInt(partidoID));

        if (partidoDetail != null){
            this.setPartidoDetail(partidoDetail);
        }

    }

    public void variables(){
        configChampionship = new ConfigChampionship(this);
        configChampionship.setToolbar();
        championshipRest = new ChampionshipRest(getApplicationContext());



        Bundle bundle = getIntent().getExtras();
        partidoID = bundle.getString("partidoId");
    }


    private void setPartidoDetail(PartidoData partidoDetail){
        Picasso.with(getApplicationContext()).load(partidoDetail.getEscudoVisita()).into(img_visita);
        Picasso.with(getApplicationContext()).load(partidoDetail.getEscudoLocal()).into(img_escudoLocal);
        textView_nombreVisita.setText(partidoDetail.getNombreVisita());
        textView_nombreLocal.setText(partidoDetail.getNombreLocal());
        textView_golVisita.setText(partidoDetail.getGolVisita());
        textView_golLocal.setText(partidoDetail.getGolLocal());
        textView_ciudad.setText(partidoDetail.getCiudad());
        textView_estadio.setText(partidoDetail.getEstadio());
        textView_hora.setText(partidoDetail.getHora());
        textView_nombreArbitro.setText(partidoDetail.getNombreArbitro());
    }
}
