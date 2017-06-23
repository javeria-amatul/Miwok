package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> phrses=new ArrayList<Word>();
        phrses.add(new Word("Where are you going?", "minto wuksus" ,
                R.raw.phrase_where_are_you_going));
        phrses.add(new Word("What is your name?","tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        phrses.add(new Word("My name is...","oyaaset...",
                R.raw.phrase_my_name_is));
        phrses.add(new Word("How are you feeling?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrses.add(new Word("I’m feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        phrses.add(new Word("Come here","shyodang", R.raw.phrase_come_here));
        phrses.add(new Word("Are you coming?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrses.add(new Word("Yes, I’m coming.","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrses.add(new Word("I’m coming.","әәnәm", R.raw.phrase_im_coming));
        phrses.add(new Word("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        phrses.add(new Word("Come here.","әnni'nem", R.raw.phrase_come_here));
        WordAdapter itemAdaptar=new WordAdapter(this,phrses,R.color.category_phrases);
        ListView phrases= (ListView) findViewById(R.id.list);
        phrases.setAdapter(itemAdaptar);
        phrases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Word pos=phrses.get(position);
                    mMediaPlayer=MediaPlayer.create(PhrasesActivity.this, pos.getAudioResourceId());
                    mMediaPlayer.start();
            }
        });


    }
}
