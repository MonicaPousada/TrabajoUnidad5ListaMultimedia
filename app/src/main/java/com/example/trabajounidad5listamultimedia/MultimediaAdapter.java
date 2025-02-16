package com.example.trabajounidad5listamultimedia;

import static com.example.trabajounidad5listamultimedia.Multimedia.Tipo.*;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MultimediaAdapter extends RecyclerView.Adapter<MultimediaAdapter.MultimediaViewHolder> {

    //constante de la clase
    private final List<Multimedia> listaMultimedia;

    //constructor del adapter
    public MultimediaAdapter(List<Multimedia> listaMultimedia){
        this.listaMultimedia = listaMultimedia;
    }

    //crear e inflar la vesta de los items y encapsularla en el viewHoldeer
    @NonNull
    @Override
    public MultimediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MultimediaViewHolder(view);
    }

    //asignar los datos del modelo a la vista y manejar los eventos onClick
    @Override
    public void onBindViewHolder(@NonNull MultimediaViewHolder holder, int position) {
        Multimedia multimedia = listaMultimedia.get(position);

        holder.img.setImageResource(multimedia.getImagen());
        holder.tvTitulo.setText(multimedia.getTitulo());
        holder.tvDescripcion.setText(multimedia.getDescripcion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si el elemento es un video creo un bundle con la información de un video y llamo al dialogFragment adecuado
                if (multimedia.getTipo().equals(VIDEO)){
                    Bundle bundle = new Bundle();
                    bundle.putString("ruta", multimedia.getUrl());
                    bundle.putString("titulo", multimedia.getTitulo());
                    bundle.putString("descripcion", multimedia.getDescripcion());
                    DialogVideo dialogVideo = new DialogVideo();
                    dialogVideo.setArguments(bundle);
                    dialogVideo.show(((AppCompatActivity) v.getContext()).getSupportFragmentManager(), "ReproductorVideo");
                }
                //si el elemento es un audio creo un bundle con la información de un audio y llamo al dialogFragment adecuado
                else if (multimedia.getTipo().equals(AUDIO)){
                    Bundle bundle = new Bundle();
                    bundle.putString("ruta", multimedia.getUrl());
                    bundle.putString("titulo", multimedia.getTitulo());
                    bundle.putString("descripcion", multimedia.getDescripcion());
                    DialogAudio dialogAudio = new DialogAudio();
                    dialogAudio.setArguments(bundle);
                    dialogAudio.show(((AppCompatActivity) v.getContext()).getSupportFragmentManager(), "ReproductorAudio");
                }
                //si el elemento es una web creo un bundle con la información de una web y llamo al dialogFragment adecuado
                else {
                    Bundle bundle = new Bundle();
                    bundle.putString("ruta", multimedia.getUrl());
                    bundle.putString("titulo", multimedia.getTitulo());
                    bundle.putString("descripcion", multimedia.getDescripcion());
                    DialogWeb dialogWeb = new DialogWeb();
                    dialogWeb.setArguments(bundle);
                    dialogWeb.show(((AppCompatActivity) v.getContext()).getSupportFragmentManager(), "ReproductorWeb");
                }

            }
        });


    }

    //devuelve el numero de elementos de la lista
    @Override
    public int getItemCount() {
        return listaMultimedia.size();
    }

    // ViewHolder para almacenar las referencias a la vista
    public static class MultimediaViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvTitulo;
        TextView tvDescripcion;

        public MultimediaViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        }
    }
}

