package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by user on 2016/11/08.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    /**Resource ID for the background color for this list of words*/
    private int mColorResourceId;

    public WordAdapter(Activity context, List<Word> words,int colorResourceId){
        //Here, we initialize the ArrayAdapter's internal storage for the context and the list
        super(context, 0 , words);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        //Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        //Get the Version name from the currentword object and set this text on the vNameTextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        //Get the Version name from the currentword object and set this text on the vNameTextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
        //Set the ImageView to the image resource specified in the current Word
        //imageView.setImageResource(currentWord.getImageResourceId());

            Glide.with(getContext()).load(currentWord.getImageResourceId())
                    .centerCrop()
                    .crossFade()
                    .into(imageView);

            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            //Otherwise hide the Image
               imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        //Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView
        return listItemView;

    }
}
