package com.example.finalprojectfile;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter_pahang extends FragmentPagerAdapter {

    private int numofFragments;

    public PagerAdapter_pahang(FragmentManager fm, int num)
    {

        super(fm);
        this.numofFragments = num;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new Fragment_About_Pahang();
            case 1: return new Fragment_Foods_Pahang();
            case 2: return new Fragment_Cultures_Pahang();
            case 3: return new Fragment_Spot_Pahang();
            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return numofFragments;
    }
}

