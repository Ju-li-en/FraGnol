package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CouleursActivity extends AppCompatActivity {
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

        words.add(new Word("Rojo", "Rouge", R.raw.c1));
        words.add(new Word("Azul", "Bleu", R.raw.c2));
        words.add(new Word("Amarillo", "Jaune", R.raw.c3));
        words.add(new Word("Verde", "Vert", R.raw.c4));
        words.add(new Word("Marron", "Marron", R.raw.c5));
        words.add(new Word("Negro", "Noir", R.raw.c6));
        words.add(new Word("Naranja", "Orange", R.raw.c7));
        words.add(new Word("Violeta", "Violet", R.raw.c8));
        words.add(new Word("Rosa", "Rose", R.raw.c9));
        words.add(new Word("Morado", "Mauve", R.raw.c10));
        words.add(new Word("Gris", "Gris", R.raw.c11));

        WordAdapter adapter = new WordAdapter(this, words, R.color.colorCouleurs);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(CouleursActivity.this, w.getAudioId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
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
