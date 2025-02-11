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

    private final List<Multimedia> listaMultimedia;

    public MultimediaAdapter(List<Multimedia> listaMultimedia){
        this.listaMultimedia = listaMultimedia;
    }

    @NonNull
    @Override
    public MultimediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MultimediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultimediaViewHolder holder, int position) {
        Multimedia multimedia = listaMultimedia.get(position);

        holder.img.setImageResource(multimedia.getImagen());
        holder.tvTitulo.setText(multimedia.getTitulo());
        holder.tvDescripcion.setText(multimedia.getDescripcion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (multimedia.getTipo().equals(VIDEO)){
                    Bundle bundle = new Bundle();
                    bundle.putString("ruta", multimedia.getUrl());
                    bundle.putString("titulo", multimedia.getTitulo());
                    bundle.putString("descripcion", multimedia.getDescripcion());
                    DialogVideo dialogVideo = new DialogVideo();
                    dialogVideo.setArguments(bundle);
                    dialogVideo.show(((AppCompatActivity) v.getContext()).getSupportFragmentManager(), "ReproductorVideo");
                }
                else if (multimedia.getTipo().equals(AUDIO)){
                    Bundle bundle = new Bundle();
                    bundle.putString("ruta", multimedia.getUrl());
                    bundle.putString("titulo", multimedia.getTitulo());
                    bundle.putString("descripcion", multimedia.getDescripcion());
                    DialogAudio dialogAudio = new DialogAudio();
                    dialogAudio.setArguments(bundle);
                    dialogAudio.show(((AppCompatActivity) v.getContext()).getSupportFragmentManager(), "ReproductorAudio");
                }
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

    @Override
    public int getItemCount() {
        return listaMultimedia.size();
    }

    // ViewHolder
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

