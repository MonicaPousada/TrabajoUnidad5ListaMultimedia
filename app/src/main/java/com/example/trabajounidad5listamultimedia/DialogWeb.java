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
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogWeb extends DialogFragment {
    private TextView tvTitulo;
    private TextView tvDescripcion;
    private WebView webView;
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
        View vista = inflater.inflate(R.layout.dialog_web, null);

        tvTitulo = vista.findViewById(R.id.tvTituloDialogWeb);
        tvDescripcion = vista.findViewById(R.id.tvDescripcionDialogWeb);
        webView = vista.findViewById(R.id.webView);
        btnVolver = vista.findViewById(R.id.btnVolverDialogWeb);

        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        //webView.loadUrl(ruta);
        webView.loadUrl("https://www.google.com");

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