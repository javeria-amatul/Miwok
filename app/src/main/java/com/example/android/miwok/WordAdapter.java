package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Javeria on 6/5/2017.
 * Customize the ArrayAdapter since getView () method of ArrayAdapter can have only one TextView
 * Hence override the getView() to accomodate two views
 * https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/AndroidFlavorAdapter.java
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color  for this list of words**/
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorsResourceId){
        super(context,0,words);
        mColorResourceId=colorsResourceId;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
        }
        Word currentWord=getItem(position);

        TextView miwokTextView=(TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTransalation());

        TextView defaultTextView=(TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getdefaultTransalation());

        ImageView imageResourceId= (ImageView) listItemView.findViewById(R.id.image_view);

        if(currentWord.hasImage()) {
            imageResourceId.setImageResource(currentWord.getImageResourceId());
            imageResourceId.setVisibility(View.VISIBLE);

        }else{
            imageResourceId.setVisibility(View.GONE);
        }
        //Set the theme color for the list
        View textContainer=listItemView.findViewById(R.id.text_container);
        //Find the color that resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //Set the background color of the text container view
        textContainer.setBackgroundColor(color);
        return listItemView;
        //return super.getView(position, convertView, parent);
    }
}
