package com.desafiolatam.pruebasuperheroes.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.desafiolatam.pruebasuperheroes.cliente.ClienteRetrofit;
import com.desafiolatam.pruebasuperheroes.modelo.SuperheroeItem;
import com.desafiolatam.pruebasuperheroes.servicio.SuperheroeAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroesViewModel extends ViewModel {

    private SuperheroeAPI servicio = ClienteRetrofit.getInstance(ClienteRetrofit.BASE_URL);
    private MutableLiveData<List<SuperheroeItem>> listaHeroe = new MutableLiveData<List<SuperheroeItem>>();
    private MutableLiveData<SuperheroeItem>detalleHeroe = new MutableLiveData<>();

    public void llamarApi(){
        servicio.getAll().enqueue(new Callback<List<SuperheroeItem>>() {
            @Override
            public void onResponse(Call<List<SuperheroeItem>> call, Response<List<SuperheroeItem>> response) {
                listaHeroe.postValue(response.body());
                Log.i("conectado",response.message());
            }

            @Override
            public void onFailure(Call<List<SuperheroeItem>> call, Throwable t) {
                Log.i("Heroe",t.getMessage());
                call.cancel();

            }

        });
    }
    public void obtenerHeroe(SuperheroeItem heroe){ detalleHeroe.setValue(heroe);}

    public MutableLiveData<List<SuperheroeItem>> getListaHeroe() { return listaHeroe; }
    public MutableLiveData<SuperheroeItem> getDetalleHeroe() { return detalleHeroe; }
}
