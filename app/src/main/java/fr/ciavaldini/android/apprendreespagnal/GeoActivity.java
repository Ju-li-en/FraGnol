package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class GeoActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_words);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("La calle ", "La rue ", R.raw.g1));
        words.add(new Word("La callejuela ", "La ruelle ", R.raw.g2));
        words.add(new Word("El camino ", "Le chemin ", R.raw.g3));
        words.add(new Word("La autopista ", "L'autoroute ", R.raw.g4));
        words.add(new Word("La autovia ", "La voie rapide ", R.raw.g5));
        words.add(new Word("La carretera ", "La route ", R.raw.g6));
        words.add(new Word("La rotonda ", "Le rond point ", R.raw.g7));
        words.add(new Word("La glorieta ", "Le rond point ", R.raw.g8));
        words.add(new Word("La ciudad ", "La ville ", R.raw.g9));
        words.add(new Word("El centro de la ciudad ", "Le centre ville ", R.raw.g10));
        words.add(new Word("El campo ", "La campagne ", R.raw.g11));
        words.add(new Word("El pueblo ", "Le village ", R.raw.g12));
        words.add(new Word("La capital ", "La capitale ", R.raw.g13));
        words.add(new Word("El cruce ", "Le carrefour ", R.raw.g14));
        words.add(new Word("La interseccion ", "L'intersection ", R.raw.g15));
        words.add(new Word("El semaforo ", "Le feu de circulation ", R.raw.g16));
        words.add(new Word("El stop ", "Le stop ", R.raw.g17));
        words.add(new Word("El paso de zebra ", "Le passage clouté ", R.raw.g18));
        words.add(new Word("El puente ", "Le pont ", R.raw.g19));
        words.add(new Word("El tunel ", "Le tunnel ", R.raw.g20));
        words.add(new Word("El ayuntamiento ", "La mairie ", R.raw.g21));
        words.add(new Word("La comisaria ", "Le comissariat ", R.raw.g22));
        words.add(new Word("La montana ", "La montagne ", R.raw.g23));
        words.add(new Word("El valle ", "La vallée ", R.raw.g24));
        words.add(new Word("El bosque ", "La forêt ", R.raw.g25));
        words.add(new Word("El rio ", "Le fleuve ", R.raw.g26));
        words.add(new Word("El puerto de montana ", "Le col ", R.raw.g27));
        words.add(new Word("El puerto maritimo ", "Le port ", R.raw.g28));
        words.add(new Word("La cima ", "Le sommet (la cime) ", R.raw.g29));
        words.add(new Word("El pico ", "Le sommet ", R.raw.g30));
        words.add(new Word("La playa ", "La plage ", R.raw.g31));

        WordAdapter adapter = new WordAdapter(this, words, R.color.colorGeo);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(GeoActivity.this, w.getAudioId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.release();
                    }
                });
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}