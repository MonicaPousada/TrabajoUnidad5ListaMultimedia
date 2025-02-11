package com.example.trabajounidad5listamultimedia;

import static com.example.trabajounidad5listamultimedia.Multimedia.Tipo.*;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Multimedia> multimediaList = new ArrayList<>();
    private MultimediaAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Multimedia videoPlaya = new Multimedia("Video playa", "android.resource://"+getApplicationContext().getPackageName()+"/"+String.valueOf(R.raw.playa), VIDEO, "Video de una playa practicamente vacía y tranquila", R.drawable.playa);
        multimediaList.add(videoPlaya);
        Multimedia videoBosque = new Multimedia("Video bosque", "android.resource://"+getApplicationContext().getPackageName()+"/"+R.raw.bosque, VIDEO, "Video de un bosque vacío", R.drawable.bosque);
        multimediaList.add(videoBosque);
        Multimedia audioOlas = new Multimedia("Audio olas", "android.resource://"+getApplicationContext().getPackageName()+"/"+R.raw.olas, AUDIO, "Audio en el que se escuchan las olas del mar", R.drawable.olas);
        multimediaList.add(audioOlas);
        Multimedia audioLluvia = new Multimedia("Audio lluvia", "android.resource://"+getApplicationContext().getPackageName()+"/"+R.raw.lluvia, AUDIO, "Audio en el que se escucha llover", R.drawable.lluvia);
        multimediaList.add(audioLluvia);
        Multimedia webWikipedia = new Multimedia("Web Wikipedia", "https://es.wikipedia.org/wiki/Wikipedia:Portada", WEB, "Página principal de la wikipedia", R.drawable.wikipedia);
        multimediaList.add(webWikipedia);
        Multimedia webGoogleMaps = new Multimedia("Web Google Maps", "https://www.google.es/maps/?hl=es", WEB, "Página principal de la web GoogleMaps", R.drawable.googlemaps);
        multimediaList.add(webGoogleMaps);

        adapter = new MultimediaAdapter(multimediaList);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);




    }
}