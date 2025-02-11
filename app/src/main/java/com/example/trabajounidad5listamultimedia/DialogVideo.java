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
    private TextView tvTitulo;
    private TextView tvDescripcion;
    private VideoView videoView;
    private Button btnVolver;

    private String ruta;
    private String titulo;
    private String descripcion;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        ruta = bundle.getString("ruta");
        titulo = bundle.getString("titulo");
        descripcion = bundle.getString("descripcion");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.dialog_video, null);

        tvTitulo = vista.findViewById(R.id.tvTituloDialog);
        tvDescripcion = vista.findViewById(R.id.tvDescripcionDialog);
        videoView = vista.findViewById(R.id.videoView);
        btnVolver = vista.findViewById(R.id.btnVolverDialogVideo);

        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);
        videoView.setVideoPath(ruta);

        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        mediaController.setMediaPlayer(videoView);
        videoView.setOnPreparedListener(mp -> mediaController.show(3000));

        videoView.start();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        builder.setView(vista);

        return builder.create();
    }
}
