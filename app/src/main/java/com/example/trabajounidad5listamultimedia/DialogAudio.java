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
    //declaración de variables de la clase
    private TextView tvTitulo;
    private TextView tvDescripcion;
    private Button btnVolver;

    private String ruta;
    private String titulo;
    private String descripcion;

    //metodo onCreate del Dialog
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //creación del bundle y obtención de los datos necesarios del audio
        Bundle bundle = getArguments();
        ruta = bundle.getString("ruta");
        titulo = bundle.getString("titulo");
        descripcion = bundle.getString("descripcion");

        //creación del builder y del inflater y asociación del xml a la vista
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.dialog_audio, null);

        //obtención de los elementos de la vista
        tvTitulo = vista.findViewById(R.id.tvTituloDialogAudio);
        tvDescripcion = vista.findViewById(R.id.tvDescripcionDialogAudio);
        btnVolver = vista.findViewById(R.id.btnVolverDialogAudio);

        //inserción de datos en la vista
        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);

        //clase MediaPlayer para reproducir el audio
        MediaPlayer mp = MediaPlayer.create(getContext(), Uri.parse(ruta));
        mp.start();

        //onClick del boton para volver en el que se para la reproducción del audio y se cierra el dialogfragment
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                dismiss();
            }
        });

        //asociación de la vista al builder
        builder.setView(vista);

        //devolución del dialog
        return builder.create();
    }
}