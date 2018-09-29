package fr.ciavaldini.android.apprendreespagnal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textCouleurs = findViewById(R.id.couleurs);
        TextView textNombres = findViewById(R.id.nombres);
        TextView textPhrases = findViewById(R.id.phrases);
        TextView textTemps = findViewById(R.id.temps);
        TextView textTable = findViewById(R.id.table);
        TextView textBaby = findViewById(R.id.baby);
        TextView textGeo = findViewById(R.id.geo);

        textGeo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GeoActivity.class);
                startActivity(i);
            }
        });

        textBaby.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BabyActivity.class);
                startActivity(i);
            }
        });

        textTable.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TableActivity.class);
                startActivity(i);
            }
        });

        textCouleurs.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CouleursActivity.class);
                startActivity(i);
            }
        });

        textTemps.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TempsActivity.class);
                startActivity(i);
            }
        });

        textNombres.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NombresActivity.class);
                startActivity(i);
            }
        });

        textPhrases.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(i);
            }
        });
    }
}
