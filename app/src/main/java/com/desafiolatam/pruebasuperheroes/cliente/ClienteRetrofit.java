package com.desafiolatam.pruebasuperheroes.cliente;

import com.desafiolatam.pruebasuperheroes.servicio.SuperheroeAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteRetrofit {

    private static Retrofit instance;
    public final static String BASE_URL = "https://akabab.github.io/superhero-api/api/";

    private ClienteRetrofit() {}

    public static SuperheroeAPI getInstance(String url)
    {
        if(instance == null)
        {
            instance = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance.create(SuperheroeAPI.class);
    }
}
