package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
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
        words.add(new Word("Una mesa ", "Une table ", R.raw.ta1));
        words.add(new Word("Una silla ", "Une chaise ", R.raw.ta2));
        words.add(new Word("Un tenedor ", "Une fourchette ", R.raw.ta3));
        words.add(new Word("Un cochillo ", "Un couteau ", R.raw.ta4));
        words.add(new Word("Una cuchara ", "Une grande cuillère ", R.raw.ta5));
        words.add(new Word("Una cucharilla ", "Une petite cuillère ", R.raw.ta6));
        words.add(new Word("Un vaso ", "Un verre ", R.raw.ta7));
        words.add(new Word("Una copa ", "Un verre à pied ", R.raw.ta8));
        words.add(new Word("Una taza ", "Une tasse ", R.raw.ta9));
        words.add(new Word("Un cuenco ", "Un bol ", R.raw.ta10));
        words.add(new Word("Un plato ", "Une assiette ", R.raw.ta11));
        words.add(new Word("Un plato hondo ", "Une assiette creuse ", R.raw.ta12));
        words.add(new Word("Una jarra ", "Une caraffe ", R.raw.ta13));
        words.add(new Word("Una boteilla ", "Une bouteille ", R.raw.ta14));
        words.add(new Word("Una sarten ", "Une poele ", R.raw.ta15));
        words.add(new Word("Una cacerola ", "Une casserole ", R.raw.ta16));
        words.add(new Word("El mantel ", "La nappe ", R.raw.ta17));
        words.add(new Word("Una servilleta ", "Une serviette ", R.raw.ta18));
        words.add(new Word("La mantequilla ", "Le beure ", R.raw.ta19));
        words.add(new Word("La harina ", "La farine ", R.raw.ta20));
        words.add(new Word("El aceite ", "L'huile ", R.raw.ta21));
        words.add(new Word("El vinagre ", "Le vinaigre ", R.raw.ta22));
        words.add(new Word("El pan ", "Le pain ", R.raw.ta23));
        words.add(new Word("El pescado ", "Le poisson ", R.raw.ta24));
        words.add(new Word("La leche ", "Le lait ", R.raw.ta25));
        words.add(new Word("El café ", "Le café ", R.raw.ta26));
        words.add(new Word("El té ", "Le thé ", R.raw.ta27));
        words.add(new Word("Una infusion ", "Une infusion ", R.raw.ta28));
        words.add(new Word("El vino blanco ", "Le vin blanc ", R.raw.ta29));
        words.add(new Word("El vino tinto ", "Le vin rouge ", R.raw.ta30));
        words.add(new Word("Una cerveza ", "Une bière ", R.raw.ta31));
        words.add(new Word("El queso ", "Le fromage ", R.raw.ta32));
        words.add(new Word("Los huevos ", "Les oeufs ", R.raw.ta33));
        words.add(new Word("Los entrantes ", "Les entrées ", R.raw.ta34));
        words.add(new Word("Primer plato ", "L'entrée ", R.raw.ta35));
        words.add(new Word("Segundo plato ", "Plat de résistance ", R.raw.ta36));
        words.add(new Word("El postré ", "Le dessert ", R.raw.ta37));
        words.add(new Word("La sal ", "Le sel ", R.raw.ta38));
        words.add(new Word("El azucar ", "Le sucre ", R.raw.ta39));
        words.add(new Word("La pimienta ", "Le poivre ", R.raw.ta40));

        WordAdapter adapter = new WordAdapter(this, words, R.color.colorTable);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(TableActivity.this, w.getAudioId());
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