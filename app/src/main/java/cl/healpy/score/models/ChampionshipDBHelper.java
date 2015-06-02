package cl.healpy.score.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import cl.healpy.score.R;
import cl.healpy.score.models.data.ChampionshipData;
import cl.healpy.score.models.data.PartidoData;


public class ChampionshipDBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<ChampionshipData, Integer> championshipDao = null;
    private RuntimeExceptionDao<ChampionshipData, Integer> championshipRuntimeDao = null;

    private Dao<PartidoData, Integer> partidoDao = null;
    private RuntimeExceptionDao<PartidoData, Integer> partidoRuntimeDao = null;

    public ChampionshipDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(ChampionshipDBHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, ChampionshipData.class);
            TableUtils.createTable(connectionSource, PartidoData.class);
        } catch (SQLException e) {
            Log.e(ChampionshipDBHelper.class.getSimpleName(), "Error", e);
            Log.e(ChampionshipDBHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, ChampionshipData.class, true);
            TableUtils.dropTable(connectionSource, PartidoData.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(ChampionshipDBHelper.class.getSimpleName(), "Error", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<ChampionshipData, Integer> getChampionshipDao() throws SQLException {
        if (championshipDao == null) championshipDao = getDao(ChampionshipData.class);
        return championshipDao;
    }

    public RuntimeExceptionDao<ChampionshipData, Integer> getChampionshipRuntimeDao() {
        if (championshipRuntimeDao == null) championshipRuntimeDao = getRuntimeExceptionDao(ChampionshipData.class);
        return championshipRuntimeDao;
    }

    public Dao<PartidoData, Integer> getPartidoDao() throws SQLException {
        if (partidoDao == null) partidoDao = getDao(PartidoData.class);
        return partidoDao;
    }

    public RuntimeExceptionDao<PartidoData, Integer> getPartidoRuntimeDao() {
        if (partidoRuntimeDao == null) partidoRuntimeDao = getRuntimeExceptionDao(PartidoData.class);
        return partidoRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        championshipDao = null;
        championshipRuntimeDao = null;

        partidoDao = null;
        partidoRuntimeDao = null;
    }
}
