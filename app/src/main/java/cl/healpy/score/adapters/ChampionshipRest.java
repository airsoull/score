package cl.healpy.score.adapters;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

import cl.healpy.score.clients.Championship;
import cl.healpy.score.clients.ChampionshipClient;
import cl.healpy.score.clients.Partido;
import cl.healpy.score.config.DataChampinship;
import cl.healpy.score.models.ChampionshipDBHelper;
import cl.healpy.score.models.data.ChampionshipData;
import cl.healpy.score.models.data.PartidoData;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ChampionshipRest {

    private ChampionshipClient championshipClient;
    private Context mContext;

    public ChampionshipRest(Context context) {
        this.setContext(context);
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public void getRestAdapterChampionship(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(DataChampinship.URL)
                .build();
        championshipClient = restAdapter.create(ChampionshipClient.class);

        this.saveChampionship();
    }

    public void saveChampionship(){
        championshipClient.championships(new Callback<List<Championship>>() {
            @Override
            public void success(List<Championship> championships, Response response) {

                ChampionshipDBHelper championshipDBHelper = OpenHelperManager.getHelper(getContext(), ChampionshipDBHelper.class);
                RuntimeExceptionDao<ChampionshipData, Integer> championshipDao = championshipDBHelper.getChampionshipRuntimeDao();
                RuntimeExceptionDao<PartidoData, Integer> partidoDao = championshipDBHelper.getPartidoRuntimeDao();

                try {
                    DeleteBuilder championshipDb = championshipDao.deleteBuilder();
                    DeleteBuilder partidoDb = partidoDao.deleteBuilder();

                    championshipDao.delete(championshipDb.prepare());
                    partidoDao.delete(partidoDb.prepare());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                createChampionship(championships, championshipDao, partidoDao);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void createChampionship(final List<Championship> championships, final RuntimeExceptionDao championshipDao,
                                   final RuntimeExceptionDao partidoDao){

        championshipDao.callBatchTasks(new Callable<Object>() {

            @Override
            public Object call() throws Exception {

                ChampionshipData championshipData = new ChampionshipData();
                PartidoData partidoData = new PartidoData();

                for (Championship championship : championships) {
                    int id = championship.getId();

                    championshipData.setId(id);
                    championshipData.setName(championship.getName());
                    championshipData.setDesde(championship.getDesde());
                    championshipData.setTemporada(championship.getTemporada());
                    championshipData.setHasta(championship.getHasta());
                    championshipData.setVersion(championship.getVersion());
                    championshipData.setDia(championship.getDia());

                    championshipDao.create(championshipData);

                    for (Partido partido: championship.getPartidos()){

                        partidoData.setId_championship(id);
                        partidoData.setHoraEstado(partido.getHoraEstado());
                        partidoData.setIdPartido(partido.getIdPartido());
                        partidoData.setHora(partido.getHora());
                        partidoData.setCiudad(partido.getCiudad());
                        partidoData.setIdEstado(partido.getIdEstado());
                        partidoData.setNombreArbitro(partido.getNombreArbitro());
                        partidoData.setGolLocal(partido.getGolLocal());
                        partidoData.setIdArbitro(partido.getIdArbitro());
                        partidoData.setEscudoVisita(partido.getEscudoVisita());
                        partidoData.setGolVisita(partido.getGolVisita());
                        partidoData.setEstadio(partido.getEstadio());
                        partidoData.setIdVisita(partido.getIdVisita());
                        partidoData.setEstado(partido.getEstado());
                        partidoData.setEscudoLocal(partido.getEscudoLocal());
                        partidoData.setNombreVisita(partido.getNombreVisita());
                        partidoData.setNombreLocal(partido.getNombreLocal());
                        partidoData.setFecha(partido.getFecha());

                        partidoDao.create(partidoData);
                    }
                }

                return null;
            }
        });
    }

}
