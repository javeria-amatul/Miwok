package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class NumbersActivity extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>(10);
        words.add(new Word("One","Lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("Two","Otiiko",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three","Tolookosu",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four","Oyyisa",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five","Massokka",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six","Temmokka",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven","Kenekaku",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight","Kawinta",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine","Wo’e",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten","Na’aacha",R.drawable.number_ten, R.raw.number_ten));

        /*This is to disply array*/
        /* for (int i = 0; i < words.size(); i++) {

            LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);//Creates a linear layout for id rootView
            TextView wordView = new TextView(this); //Creates a textView with "this" as context
            wordView.setText(words.get(i));  //sets the textView text as the words list
            rootView.addView(wordView);      //adds the textView to parent view
            }
            int index=0;
            while(index<words.size()){
            TextView wordView=new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
            index=index+1;
        }*/


        /* Array adapter is used to recycle the views*/
        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter Adapter = new WordAdapter(this, words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should      be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        final ListView listView=(ListView) findViewById(R.id.list);
        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
               // mMediaPlayer=MediaPlayer.create(NumbersActivity.this,R.raw.number_one);
                //mMediaPlayer.start();

                //Get position of each list item
                Word word=words.get(position);
                mMediaPlayer=MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });




    }
}
