package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AchatsActivity extends AppCompatActivity {
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

        words.add(new Word("Vamos a coger un carro ","Allons chercher un cadis ",R.raw.a1));
        words.add(new Word("Hay mucha cola en la caja ","Il y a beaucoup de monde à la caisse ",R.raw.a2));
        words.add(new Word("Cuanto cuesta la camiseta? ","Combien coùte la chemise ? ",R.raw.a3));
        words.add(new Word("Tienen esta camiseta en talla S? ","Avez-vous cette chemise taille S ? ",R.raw.a4));
        words.add(new Word("Es muy caro ","C'est très cher ",R.raw.a5));
        words.add(new Word("Es muy barato ","C'est bon marché ",R.raw.a6));
        words.add(new Word("Esta muy bien de precio ","C'est un très bon prix ",R.raw.a7));
        words.add(new Word("Ya no quedan mas ","Il ne reste plus rien ",R.raw.a8));
        words.add(new Word("Qué horario tienen? ","Quels sont vos horaires d'ouverture ? ",R.raw.a9));


        WordAdapter adapter = new WordAdapter(this, words,R.color.colorPhrases);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(AchatsActivity.this, w.getAudioId());
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

    private void releaseMediaPlayer(){
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