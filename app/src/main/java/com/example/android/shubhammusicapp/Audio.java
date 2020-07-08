package com.example.android.shubhammusicapp;

public class Audio {
    private String mTitle;
    private String mSinger;
    private String mYear;
    private int mImageResourceId;
    private String mDuration;


    public Audio(String title, String singer, String year, int cover, String duration) {
        mTitle = title;
        mSinger = singer;
        mYear = year;
        mImageResourceId = cover;
        mDuration = duration;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSinger() {
        return mSinger;
    }

    public String getYear() {
        return mYear;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getDuration() {
        return mDuration;
    }

}
