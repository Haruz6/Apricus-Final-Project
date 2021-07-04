package com.example.finalprojectfile;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter_kelantan extends FragmentPagerAdapter {

    private int numofFragments;

    public PagerAdapter_kelantan(FragmentManager fm, int num)
    {

        super(fm);
        this.numofFragments = num;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new Fragment_About_Kelantan();
            case 1: return new Fragment_Foods_Kelantan();
            case 2: return new Fragment_Cultures_Kelantan();
            case 3: return new Fragment_Spot_Kelantan();
            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return numofFragments;
    }
}

