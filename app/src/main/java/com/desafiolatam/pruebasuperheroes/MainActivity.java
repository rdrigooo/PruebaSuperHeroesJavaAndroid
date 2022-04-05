package com.desafiolatam.pruebasuperheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.desafiolatam.pruebasuperheroes.databinding.ActivityMainBinding;
import com.desafiolatam.pruebasuperheroes.viewModel.HeroesViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private HeroesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(HeroesViewModel.class);

        viewModel.llamarApi();
    }
}