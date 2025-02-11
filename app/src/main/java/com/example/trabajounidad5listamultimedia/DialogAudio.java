package com.example.trabajounidad5listamultimedia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogAudio extends DialogFragment {
    private TextView tvTitulo;
    private TextView tvDescripcion;
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
        View vista = inflater.inflate(R.layout.dialog_audio, null);

        tvTitulo = vista.findViewById(R.id.tvTituloDialogAudio);
        tvDescripcion = vista.findViewById(R.id.tvDescripcionDialogAudio);
        btnVolver = vista.findViewById(R.id.btnVolverDialogAudio);

        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);

        MediaPlayer mp = MediaPlayer.create(getContext(), Uri.parse(ruta));
        mp.start();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                dismiss();
            }
        });

        builder.setView(vista);

        return builder.create();
    }
}