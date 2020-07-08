package com.example.android.shubhammusicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;


public class AudioAdapter extends ArrayAdapter<Audio> {

    public AudioAdapter(@NonNull Context context, @NonNull List<Audio> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        Audio currentAudio = getItem(position);

        ImageView songCoverImageView = (ImageView) listItemView.findViewById(R.id.song_cover_image_view);
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_text_view);
        TextView songAuthorTextView = (TextView) listItemView.findViewById(R.id.song_author_text_view);
        TextView songYearTextView = (TextView) listItemView.findViewById(R.id.song_year_text_view);

        songCoverImageView.setImageResource(currentAudio.getImageResourceId());
        songTitleTextView.setText(currentAudio.getTitle());
        songAuthorTextView.setText(currentAudio.getSinger());
        songYearTextView.setText(currentAudio.getYear());

        return listItemView;
    }

}
