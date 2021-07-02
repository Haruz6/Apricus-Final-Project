package com.example.finalprojectfile;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter_kedah extends FragmentPagerAdapter {

    private int numofFragments;

    public PagerAdapter_kedah(FragmentManager fm, int num)
    {

        super(fm);
        this.numofFragments = num;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new Fragment_About_Kedah();
            case 1: return new Fragment_Cultures_Kedah();
            case 2: return new Fragment_Foods_Kedah();
            case 3: return new Fragment_Spot_Kedah();
            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return numofFragments;
    }
}

