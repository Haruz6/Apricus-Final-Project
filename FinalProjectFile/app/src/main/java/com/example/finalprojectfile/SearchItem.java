package com.example.finalprojectfile;

public class SearchItem {
    private int mImageResource;
    private String mText1;
    private Class mLaunchClass;

    public SearchItem(int imageResource, String text1, Class launchClass)
    {
        mImageResource = imageResource;
        mText1 = text1;
        mLaunchClass = launchClass;
    }

    public int getmImageResource(){
        return mImageResource;
    }

    public String getmText1(){
        return mText1;
    }

    public Class getmLaunchClass(){return mLaunchClass;}
}
