package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
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

        words.add(new Word("Una copa de vino tinto por favor? ", "Un verre de vin rouge, s'il-vous-plait ? ",R.raw.r1));
        words.add(new Word("Una racion de bravas ", "Une part de pomme-de-terre Bravas ",R.raw.r2));
        words.add(new Word("Dos canas, por favor ", "Deux demis, s'il-vous-plait ",R.raw.r3));
        words.add(new Word("Me trae la cuenta, por favor ", "Donnez-moi l'addition, s'il-vous-plait ",R.raw.r4));
        words.add(new Word("Quiero un plato de judias verdes y un filete ", "je voudrais une assiette de haricots verts et un bifsteak ",R.raw.r5));
        words.add(new Word("Tiene mesa para cuatro? ", "Auriez-vous une table de 4 personnes ? ",R.raw.r6));
        words.add(new Word("Una paella para seis personas y una ensalada ", "Une paella pour 6 personnes et une salade ",R.raw.r7));
        words.add(new Word("Donde estan los banos, por favor? ", "Où sont les toilettes s'il-vous-plait ? ",R.raw.r8));
        words.add(new Word("Me das el agua? ", "Pourrais-tu me passer l'eau ? ",R.raw.r9));
        words.add(new Word("La carne no esta buena, por favor, retireme el plato ", "La viande n'est pas bonne, je vous remercie de me changer mon assiette ",R.raw.r10));
        words.add(new Word("Me lo puede hacer un poco mas, por favor ", "La cuisson n'est pas suffisante, pourriez-vous la cuire plus ? ",R.raw.r11));
        words.add(new Word("La carne esta muy pasada, no es lo que yo habia pedido ", "La viande est trop cuite, ce n'est pas ce que j'avais commandé ",R.raw.r12));
        words.add(new Word("Una carne al punto ", "Une viande cuite à point ",R.raw.r13));
        words.add(new Word("Une carne poco hecha ", "Une viande saignante ",R.raw.r14));
        words.add(new Word("Une carne muy poco hecha ", "Une viande bleue ",R.raw.r15));
        words.add(new Word("Une carne muy hecha ", "Une viande bien cuite ",R.raw.r16));
        words.add(new Word("Qué tienen de postre, por facor ", "Qu'avez-vous comme déssert, svp ? ",R.raw.r17));
        words.add(new Word("Qué vino nos recomienda? ", "Quel vin nous conseillez-vous ? ",R.raw.r18));
        words.add(new Word("El plato del dia, por favor ", "Le plat du jour svp ",R.raw.r19));


        WordAdapter adapter = new WordAdapter(this, words, R.color.colorPhrases);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(RestaurantActivity.this, w.getAudioId());
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