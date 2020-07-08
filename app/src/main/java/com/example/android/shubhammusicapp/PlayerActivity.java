package com.example.android.shubhammusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    private static final String TAG = PlayerActivity.class.getSimpleName();

    private Button mLibraryButton;
    private TextView msongTitleTextView;
    private TextView mDurationTextView;
    private ImageView msongCoverImageView;

    private boolean isPlaying;
    private String msongTitle;
    private String msongDuration;
    private int msongCoverID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        setTitle(new String("PlayerActivity"));
        findViews();

        Intent intent = getIntent();

        isPlaying = intent.getBooleanExtra(Constants.NOW_PLAYING, false);
        if (isPlaying){
            msongTitle = "Sick Boy";
            msongDuration = "03:39";
            msongCoverID = R.drawable.sikboy;
        } else {
            msongTitle = intent.getStringExtra(Constants.Song_TITLE);
            msongDuration = intent.getStringExtra(Constants.Song_DURATION);
            msongCoverID = intent.getIntExtra(Constants.Song_COVER, 0);
        }

        msongTitleTextView.setText(msongTitle);
        mDurationTextView.setText(msongDuration);
        msongCoverImageView.setImageResource(msongCoverID);


        mLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void findViews() {
        mLibraryButton = (Button) findViewById(R.id.library_button_view);
        msongTitleTextView = (TextView) findViewById(R.id.song_title_text_view);
        mDurationTextView = (TextView) findViewById(R.id.duration_text_view);
        msongCoverImageView = (ImageView) findViewById(R.id.song_cover_image_view);
    }
}