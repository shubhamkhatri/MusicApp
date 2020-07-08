package com.example.android.shubhammusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mNowPlayingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        final ArrayList<Audio> audio = new ArrayList<>();

        audio.add(new Audio("Sick Boy", "The Chainsmokers", "2018", R.drawable.sikboy, "03:39"));
        audio.add(new Audio("Somebody", "The Chainsmokers", "2018", R.drawable.somebody, "03:54"));
        audio.add(new Audio("So Far Away", "Martin Garrix", "2019", R.drawable.so_far_away, "03:04"));
        audio.add(new Audio("Happier", "Marshmello", "2018", R.drawable.happier, "03:39"));
        audio.add(new Audio("Rockstar", "Post Malone", "2019", R.drawable.rockstar, "04:02"));
        audio.add(new Audio("Beautiful", "Bazzi", "2017", R.drawable.beautiful, "03:15"));

        AudioAdapter audioAdapter = new AudioAdapter(this, audio);
        GridView list = (GridView) findViewById(R.id.list);
        list.setAdapter(audioAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra(Constants.NOW_PLAYING, false);
                intent.putExtra(Constants.Song_TITLE, audio.get(position).getTitle());
                intent.putExtra(Constants.Song_DURATION, audio.get(position).getDuration());
                intent.putExtra(Constants.Song_COVER, audio.get(position).getImageResourceId());
                startActivity(intent);
            }
        });

        mNowPlayingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra(Constants.NOW_PLAYING, true);
                startActivity(intent);
            }
        });

    }

    private void findViews() {
        mNowPlayingButton = (Button) findViewById(R.id.now_playing_button_view);
    }

}
