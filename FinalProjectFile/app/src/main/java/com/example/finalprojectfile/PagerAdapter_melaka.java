package com.example.finalprojectfile;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter_melaka extends FragmentPagerAdapter {

    private int numofFragments;

    public PagerAdapter_melaka(FragmentManager fm, int num)
    {

        super(fm);
        this.numofFragments = num;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new Fragment_About_Melaka();
            case 1: return new Fragment_Foods_Melaka();
            case 2: return new Fragment_Cultures_Melaka();
            case 3: return new Fragment_Spot_Melaka();
            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return numofFragments;
    }
}

