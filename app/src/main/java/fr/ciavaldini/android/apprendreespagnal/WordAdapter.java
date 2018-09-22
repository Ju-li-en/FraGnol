package fr.ciavaldini.android.apprendreespagnal;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int couleur;

    public WordAdapter(Activity context, ArrayList<Word> Word, int couleurActivity) {
        super(context, 0, Word);
        this.couleur = couleurActivity;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        View layoutTexte = listItemView.findViewById(R.id.layoutWords);
        int color = ContextCompat.getColor(getContext(), couleur);
        layoutTexte.setBackgroundColor(color);

        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView espagnolTextView = listItemView.findViewById(R.id.espagnol);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        espagnolTextView.setText(currentWord.getMotEspagnol());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView francaisTextView = listItemView.findViewById(R.id.francais);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        francaisTextView.setText(currentWord.getMotFrancais());

        ImageView imageView = listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImage());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
