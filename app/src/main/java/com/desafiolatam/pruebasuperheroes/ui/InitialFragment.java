package com.desafiolatam.pruebasuperheroes.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafiolatam.pruebasuperheroes.R;
import com.desafiolatam.pruebasuperheroes.adapter.HeroesAdapter;
import com.desafiolatam.pruebasuperheroes.databinding.FragmentInitialBinding;
import com.desafiolatam.pruebasuperheroes.modelo.Superheroe;
import com.desafiolatam.pruebasuperheroes.modelo.SuperheroeItem;
import com.desafiolatam.pruebasuperheroes.viewModel.HeroesViewModel;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


public class InitialFragment extends Fragment {
    private FragmentInitialBinding binding;
    private HeroesViewModel viewModel;
    private HeroesAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInitialBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(getActivity()).get(HeroesViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        adapter = new HeroesAdapter();
        GridLayoutManager manager = new GridLayoutManager(getContext(),1);
        binding.rvHeroes.setAdapter(adapter);
        binding.rvHeroes.setLayoutManager(manager);


        adapter.setListener(new HeroesAdapter.MiOnClickListener() {
            @Override
            public void onClickListener(SuperheroeItem heroe) {
                viewModel.obtenerHeroe(heroe);
                Navigation.findNavController(getView()).navigate(R.id.action_initialFragment_to_destinoFragment);
            }

        });

    viewModel.getListaHeroe().observe(getViewLifecycleOwner(),superheroeItem -> {
        Log.i("Heroe",superheroeItem.toString());
        adapter.setLista((List<SuperheroeItem>) superheroeItem);
    });


    }
}