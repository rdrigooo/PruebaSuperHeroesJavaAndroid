package com.desafiolatam.pruebasuperheroes.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProvider;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafiolatam.pruebasuperheroes.R;
import com.desafiolatam.pruebasuperheroes.adapter.HeroesAdapter;
import com.desafiolatam.pruebasuperheroes.databinding.FragmentDestinoBinding;
import com.desafiolatam.pruebasuperheroes.modelo.SuperheroeItem;
import com.desafiolatam.pruebasuperheroes.viewModel.HeroesViewModel;
import com.squareup.picasso.Picasso;


public class DestinoFragment extends Fragment {
private FragmentDestinoBinding binding;
private HeroesViewModel viewModel;
private SuperheroeItem item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDestinoBinding.inflate(inflater,container,false);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        viewModel = new ViewModelProvider(getActivity()).get(HeroesViewModel.class);
        viewModel.getDetalleHeroe().observe(getViewLifecycleOwner(),superheroeItems -> {
            binding.getViewmodel();
            binding.tvNameDetail.setText(superheroeItems.getName());
            Picasso.get().load(superheroeItems.getImages().getMd()).into(binding.imageView);
            if(superheroeItems.getBiography().getFullName().equals("")) {
                binding.tvFullName.setText(R.string.desco);
            }else{
                binding.tvFullName.setText(superheroeItems.getBiography().getFullName());
            }
            binding.tvIntelligence.setText(String.valueOf(superheroeItems.getPowerstats().getIntelligence()));
            binding.tvComabat.setText(String.valueOf(superheroeItems.getPowerstats().getCombat()));
            binding.tvDurability.setText(String.valueOf(superheroeItems.getPowerstats().getDurability()));
            binding.tvPower.setText(String.valueOf(superheroeItems.getPowerstats().getPower()));
            binding.tvSpeed.setText(String.valueOf(superheroeItems.getPowerstats().getSpeed()));
            binding.tvStrenght.setText(String.valueOf(superheroeItems.getPowerstats().getStrength()));

        });

        binding.getViewmodel();
        return binding.getRoot();
    }
}