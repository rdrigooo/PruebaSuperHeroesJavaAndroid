package com.desafiolatam.pruebasuperheroes.cliente;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.desafiolatam.pruebasuperheroes.LectorJson;
import com.desafiolatam.pruebasuperheroes.modelo.SuperheroeItem;
import com.desafiolatam.pruebasuperheroes.servicio.SuperheroeAPI;
import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@RunWith(AndroidJUnit4.class)
public class ClienteRetrofitTest {
    private MockWebServer server;
    private String url = "https://localhost:8080/api/";
    private String body = LectorJson.lector("heroes.json");

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start(8080);
        server.enqueue(new MockResponse().setResponseCode(200).setBody(body));
        server.url("id/1.json");

    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void llamadaCorrecta(){
        SuperheroeAPI servicio = ClienteRetrofit.getInstance(url);
        try {
            SuperheroeItem detalle = servicio.getSuperhero("{id}").execute().body();
            Truth.assertThat(detalle.getName()).isEqualTo("A-Bomb");

        }catch (IOException exception){
            exception.printStackTrace();

        }

    }

    @Test
    public void llamadaInrrecta(){
        SuperheroeAPI servicio = ClienteRetrofit.getInstance(url);
        try {
            SuperheroeItem detalle = servicio.getSuperhero("{id}").execute().body();
            Truth.assertThat(detalle.getName()).isNotEqualTo("Rodrigo");

        }catch (IOException exception){
            exception.printStackTrace();

        }

    }
}