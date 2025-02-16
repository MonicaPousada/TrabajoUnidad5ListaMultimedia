package com.example.trabajounidad5listamultimedia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogVideo extends DialogFragment {
    //declaración de variables de la clase
    private TextView tvTitulo;
    private TextView tvDescripcion;
    private VideoView videoView;
    private Button btnVolver;

    private String ruta;
    private String titulo;
    private String descripcion;

    //metodo onCreate del Dialog
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //creación del bundle y obtención de los datos necesarios del video
        Bundle bundle = getArguments();
        ruta = bundle.getString("ruta");
        titulo = bundle.getString("titulo");
        descripcion = bundle.getString("descripcion");

        //creación del builder y del inflater y asociación del xml a la vista
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.dialog_video, null);

        //obtención de los elementos de la vista
        tvTitulo = vista.findViewById(R.id.tvTituloDialog);
        tvDescripcion = vista.findViewById(R.id.tvDescripcionDialog);
        videoView = vista.findViewById(R.id.videoView);
        btnVolver = vista.findViewById(R.id.btnVolverDialogVideo);

        //inserción de datos en la vista
        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);
        videoView.setVideoPath(ruta);

        //clase MEdiaController para reproducir el video, configuración de la barra de navegación y start del contenido multimedia
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        mediaController.setMediaPlayer(videoView);
        videoView.setOnPreparedListener(mp -> mediaController.show(3000));

        videoView.start();

        //onClick del boton para volver en el que se cierra el dialogfragment
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        //asociación de la vista al builder
        builder.setView(vista);

        //devolución del dialog
        return builder.create();
    }
}
