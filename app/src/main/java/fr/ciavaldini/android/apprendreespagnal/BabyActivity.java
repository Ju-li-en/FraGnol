package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BabyActivity extends AppCompatActivity {
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
        words.add(new Word("La banera ", "La baignoire ", R.raw.e1));
        words.add(new Word("El cambiador ", "La table à langer ", R.raw.e2));
        words.add(new Word("La cuna ", "Le lit du bébé ", R.raw.e3));
        words.add(new Word("El moisés ", "Le berceau ", R.raw.e4));
        words.add(new Word("El cochecito ", "La poussette ", R.raw.e5));
        words.add(new Word("El Chupete ", "La tétine ", R.raw.e6));
        words.add(new Word("El biberon ", "Le biberon ", R.raw.e7));
        words.add(new Word("El panel ", "La couche ", R.raw.e8));
        words.add(new Word("La toalla ", "La serviette ", R.raw.e9));
        words.add(new Word("El termometro ", "Le thermomètre ", R.raw.e10));
        words.add(new Word("El capazo ", "Le landau ", R.raw.e11));
        words.add(new Word("Llocar ", "Pleurer ", R.raw.e12));
        words.add(new Word("Dar el pecho ", "Donner le sein ", R.raw.e13));
        words.add(new Word("Amamantar ", "Allaiter ", R.raw.e14));
        words.add(new Word("Mamar ", "Têter ", R.raw.e15));

        WordAdapter adapter = new WordAdapter(this, words, R.color.colorBaby);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(BabyActivity.this, w.getAudioId());
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