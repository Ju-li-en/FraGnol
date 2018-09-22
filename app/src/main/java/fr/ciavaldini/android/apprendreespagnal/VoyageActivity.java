package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class VoyageActivity extends AppCompatActivity {
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

        words.add(new Word("Donde esta la puerta de embarque ?  "," Où se trouve la porte d'embarquement ? ",R.raw.v1));
        words.add(new Word("A que hora sale el autobus ?  "," A quelle heure part l'autobus ? ",R.raw.v2));
        words.add(new Word("A que hora llega el autobus ?  "," A quelle heure arrive l'autobus ? ",R.raw.v3));
        words.add(new Word("Por donde se va a la plaza ?  "," Comment fait-on pour se rendre à la place ? ",R.raw.v4));
        words.add(new Word("Cuanto se tarda en llagar a Madrid  "," Combien de temps met-on pour aller à Madrid ",R.raw.v5));
        words.add(new Word("Cuanto cuesta un billete ?  "," Combien coûte un titre de transport ? ",R.raw.v6));

        WordAdapter adapter = new WordAdapter(this, words,R.color.colorPhrases);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(VoyageActivity.this, w.getAudioId());
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