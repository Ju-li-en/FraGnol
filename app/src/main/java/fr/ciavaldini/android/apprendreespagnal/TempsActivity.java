package fr.ciavaldini.android.apprendreespagnal;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TempsActivity extends AppCompatActivity {
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

        words.add(new Word("Lunes ","Lundi ",R.raw.t1));
        words.add(new Word("Martes ","Mardi ",R.raw.t2));
        words.add(new Word("Miercolés ","Mercredi ",R.raw.t3));
        words.add(new Word("Jueves ","Jeudi ",R.raw.t4));
        words.add(new Word("Viernes ","Vendredi ",R.raw.t5));
        words.add(new Word("Sabado ","Samedi ",R.raw.t6));
        words.add(new Word("Domingo ","Dimanche ",R.raw.t7));
        words.add(new Word("Enero ","Janvier ",R.raw.t8));
        words.add(new Word("Febrero ","Février ",R.raw.t9));
        words.add(new Word("Marzo ","Mars ",R.raw.t10));
        words.add(new Word("Abril ","Avril ",R.raw.t11));
        words.add(new Word("Mayo ","Mai ",R.raw.t12));
        words.add(new Word("Junio ","Juin ",R.raw.t13));
        words.add(new Word("Julio ","Juillet ",R.raw.t14));
        words.add(new Word("Agosto ","Aout ",R.raw.t15));
        words.add(new Word("Septiembre ","Septembre ",R.raw.t16));
        words.add(new Word("Octobre ","Octobre ",R.raw.t17));
        words.add(new Word("Noviembre ","Novembre ",R.raw.t18));
        words.add(new Word("Deciembre ","Décembre ",R.raw.t19));
        words.add(new Word("Al amanecer ","Au lever du soleil ",R.raw.t20));
        words.add(new Word("Al mediodia ","Le midi ",R.raw.t21));
        words.add(new Word("Al atardecer ","Au coucher de soleil ",R.raw.t22));
        words.add(new Word("Al anochecer ","Au crépuscule ",R.raw.t23));
        words.add(new Word("El dia ","Le jour ",R.raw.t24));
        words.add(new Word("Por la manana ","Le matin ",R.raw.t25));
        words.add(new Word("Por la tarde ","L'après midi ",R.raw.t26));
        words.add(new Word("Por la noche ","Le soir ",R.raw.t27));
        words.add(new Word("Manana ","Demain ",R.raw.t28));
        words.add(new Word("Manana por la manana ","Demain matin ",R.raw.t29));
        words.add(new Word("Manana por la tarde ","Demain après-midi ",R.raw.t30));
        words.add(new Word("Qué hora es? ","Quelle heure est-il ? ",R.raw.t31));
        words.add(new Word("Son las cinco de la tarde ","Il est cinq heure de l'après-midi ",R.raw.t32));
        words.add(new Word("Es la una del mediodia ","Il est treize heure ",R.raw.t33));
        words.add(new Word("Es la una ","Il est une heure du matin ",R.raw.t34));
        words.add(new Word("Es la una menos cuarto del mediodia ","Il est une heure moins le quart ",R.raw.t35));
        words.add(new Word("Es la una y cuarto del mediodia ","Il est une heure et quart ",R.raw.t36));
        words.add(new Word("Son las treis y media de la tarde ","Il est 3 heure et demi de l'après-midi ",R.raw.t37));
        words.add(new Word("Son las cuatro en punto ","Il est quatre heure pile ",R.raw.t38));


        WordAdapter adapter = new WordAdapter(this, words,R.color.colorTemps);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                releaseMediaPlayer();
                Word w = words.get(position);
                mediaPlayer = MediaPlayer.create(TempsActivity.this, w.getAudioId());
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
