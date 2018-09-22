package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NombresActivity extends AppCompatActivity {
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

        words.add(new Word("Uno ","Un ",R.raw.n1));
        words.add(new Word("Dos ","Deux ",R.raw.n2));
        words.add(new Word("Tres ","Trois ",R.raw.n3));
        words.add(new Word("Cuatro ","Quatre ",R.raw.n4));
        words.add(new Word("Cinco ","Cinq ",R.raw.n5));
        words.add(new Word("Seis ","Six ",R.raw.n6));
        words.add(new Word("Siete ","Sept ",R.raw.n7));
        words.add(new Word("Ocho ","Huit ",R.raw.n8));
        words.add(new Word("Nueve ","Neuf ",R.raw.n9));
        words.add(new Word("Diez ","Dix ",R.raw.n10));
        words.add(new Word("Once ","Onze ",R.raw.n11));
        words.add(new Word("Doce ","Douze ",R.raw.n12));
        words.add(new Word("Trece ","Treize ",R.raw.n13));
        words.add(new Word("Catorce ","Quatorze ",R.raw.n14));
        words.add(new Word("Quince ","Quinze ",R.raw.n15));
        words.add(new Word("Dieciseis ","Seize ",R.raw.n16));
        words.add(new Word("Diecisiete ","Dix-sept ",R.raw.n17));
        words.add(new Word("Dieciocho ","Dix-huit ",R.raw.n18));
        words.add(new Word("Diecinueve ","Dix-neuf ",R.raw.n19));
        words.add(new Word("Veinte ","Vingt ",R.raw.n20));
        words.add(new Word("Veintiuno ","Vingt-et-un ",R.raw.n21));
        words.add(new Word("Veintidos ","Vingt-deux ",R.raw.n22));
        words.add(new Word("Veintitres ","Vingt-trois ",R.raw.n23));
        words.add(new Word("Veinticuatro ","Vingt-quatre ",R.raw.n24));
        words.add(new Word("Treinta ","Trente ",R.raw.n25));
        words.add(new Word("Treinta y uno ","Trente-et-un ",R.raw.n26));
        words.add(new Word("Treinta y dos ","Trente-deux ",R.raw.n27));
        words.add(new Word("Treinta y tres ","Trente-trois ",R.raw.n28));
        words.add(new Word("Cuarenta ","Quarante ",R.raw.n29));
        words.add(new Word("Cincuenta ","Cinquante ",R.raw.n30));
        words.add(new Word("Sesenta ","Soixante ",R.raw.n31));
        words.add(new Word("Setenta ","Soixante-dix ",R.raw.n32));
        words.add(new Word("Ochenta ","Quatre-vingt ",R.raw.n33));
        words.add(new Word("Noventa ","Quantre-vingt-dix ",R.raw.n34));
        words.add(new Word("Cien ","Cent ",R.raw.n35));
        words.add(new Word("Ciento uno ","Cent un ",R.raw.n36));
        words.add(new Word("Cinto cincuenta ","Cent cinquante ",R.raw.n37));
        words.add(new Word("Doscientos ","Deux cents ",R.raw.n38));
        words.add(new Word("Doscientos dos ","Deux cents deux ",R.raw.n39));
        words.add(new Word("Trescientos ","Trois cents ",R.raw.n40));
        words.add(new Word("cuatrocientos ","Quatre cents ",R.raw.n41));
        words.add(new Word("Quinientos ","Cinq cents ",R.raw.n42));
        words.add(new Word("Seiscientos ","Six cents ",R.raw.n43));
        words.add(new Word("Setecientos ","Sept cents ",R.raw.n44));
        words.add(new Word("Ochocientos ","Huit cents ",R.raw.n45));
        words.add(new Word("Novecientos ","Neuf cents ",R.raw.n46));
        words.add(new Word("Mil ","Mille ",R.raw.n47));
        words.add(new Word("Dos mil ","Deux mille ",R.raw.n48));
        words.add(new Word("Tres mil ","Trois mille ",R.raw.n49));
        words.add(new Word("Cien mil ","Cent mille ",R.raw.n50));
        words.add(new Word("Un millon ","Un million ",R.raw.n51));


        WordAdapter adapter = new WordAdapter(this, words,R.color.colorNombres);
        
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(NombresActivity.this, w.getAudioId());
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
