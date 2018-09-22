package fr.ciavaldini.android.apprendreespagnal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textRestaurant = findViewById(R.id.restaurant);
        TextView textVoyage = findViewById(R.id.voyage);
        TextView textAchats = findViewById(R.id.achats);

        textRestaurant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(PhrasesActivity.this, RestaurantActivity.class);
                startActivity(i);
            }
        });

        textVoyage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(PhrasesActivity.this, VoyageActivity.class);
                startActivity(i);
            }
        });

        textAchats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(PhrasesActivity.this, AchatsActivity.class);
                startActivity(i);
            }
        });


    }
}
