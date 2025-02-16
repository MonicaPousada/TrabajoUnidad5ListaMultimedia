package com.example.trabajounidad5listamultimedia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogWeb extends DialogFragment {
    //declaración de variables de la clase
    private TextView tvTitulo;
    private TextView tvDescripcion;
    private WebView webView;
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
        View vista = inflater.inflate(R.layout.dialog_web, null);

        //obtención de los elementos de la vista
        tvTitulo = vista.findViewById(R.id.tvTituloDialogWeb);
        tvDescripcion = vista.findViewById(R.id.tvDescripcionDialogWeb);
        webView = vista.findViewById(R.id.webView);
        btnVolver = vista.findViewById(R.id.btnVolverDialogWeb);

        //inserción de datos en la vista
        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);

        //configuracion del webView para que pueda verse la pagina web y se le pasa la ruta
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(ruta);
        //webView.loadUrl("https://www.google.com");

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