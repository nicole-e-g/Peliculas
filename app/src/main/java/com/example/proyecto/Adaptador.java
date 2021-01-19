package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>{
    private List<Peliculas> misDatos;
    public Adaptador(List<Peliculas> misDatos){
        this.misDatos = misDatos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.peliculas, parent, false);

        ViewHolder miViewHolder = new Adaptador.ViewHolder(vista);
        return miViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.traerDatos(misDatos.get(position));
        Peliculas peliculas = misDatos.get(position);
        holder.tvNom.setText(peliculas.getNombre());
        holder.tvGen.setText(peliculas.getGenero());
        holder.tvDir.setText(peliculas.getDirector());
        holder.tvDur.setText(peliculas.getDuracion());
        holder.position = position;
        holder.peliculas = peliculas;
    }

    @Override
    public int getItemCount() {
        return misDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNom, tvGen, tvDir, tvSip,  tvDur;
        Button Ver;
        ImageView image;
        int position;
        Peliculas peliculas;
        public ViewHolder(View vista) {
            super(vista);
            image= vista.findViewById(R.id.image);
            tvNom = vista.findViewById(R.id.tvPeli);
            tvGen = vista.findViewById(R.id.tvGenero);
            tvDir = vista.findViewById(R.id.tvDirector);
            tvDur = vista.findViewById(R.id.tvDuracion);
            Ver = vista.findViewById(R.id.btnMas);


            Ver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(vista.getContext(), sinopsis.class);
                    intent.putExtra("id", peliculas.getId());
                    intent.putExtra("image",peliculas.getImg());
                    intent.putExtra("sinopsis", peliculas.getDescripcion());
                    vista.getContext().startActivity(intent);
                }
            });
        }

        public void traerDatos(Peliculas peliculas) {
            Glide.with(image.getContext()).load(peliculas.getImg()).into(image);
        }
    }
}
