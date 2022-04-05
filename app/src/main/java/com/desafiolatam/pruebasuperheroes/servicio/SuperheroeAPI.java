package com.desafiolatam.pruebasuperheroes.servicio;

import com.desafiolatam.pruebasuperheroes.modelo.Superheroe;
import com.desafiolatam.pruebasuperheroes.modelo.SuperheroeItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperheroeAPI {

    @GET("all.json")
    Call<List<SuperheroeItem>> getAll();
    @GET("{id}/1.json")
    Call<SuperheroeItem> getSuperhero(@Path("id")String id);
}
