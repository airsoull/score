package cl.healpy.score.clients;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


public interface ChampionshipClient {

    @GET("/Fixture?campeonato=chile&estado=anteriores")
    void championships(Callback<List<Championship>> championships);

}
