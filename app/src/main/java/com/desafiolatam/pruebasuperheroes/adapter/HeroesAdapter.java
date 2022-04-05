package com.desafiolatam.pruebasuperheroes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.desafiolatam.pruebasuperheroes.R;
import com.desafiolatam.pruebasuperheroes.databinding.ItemLayoutBinding;
import com.desafiolatam.pruebasuperheroes.modelo.Superheroe;
import com.desafiolatam.pruebasuperheroes.modelo.SuperheroeItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.CustomViewHolder> {
    private List<SuperheroeItem>lista = new ArrayList<>();
    private MiOnClickListener listener;

    public void setLista(List<SuperheroeItem> lista){
    this.lista = lista;
        notifyDataSetChanged();
    }

    public void setListener(MiOnClickListener listener){
        this.listener = listener;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.CustomViewHolder holder, int position) {
     holder.bindData(lista.get(position));
    }

    @Override
    public int getItemCount() { return lista.size();}

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ItemLayoutBinding binding;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemLayoutBinding.bind(itemView);
        }

        public void bindData(SuperheroeItem superheroe) {
            Picasso.get().load(superheroe.getImages().getMd()).into(binding.ivSuper);
            binding.tvName.setText(superheroe.getName());
            binding.tvSlug.setText(superheroe.getSlug());

            itemView.setOnClickListener(v -> {
                listener.onClickListener(superheroe);
            });
        }
    }

   public interface MiOnClickListener {
        void onClickListener(SuperheroeItem heroe);
    }
}