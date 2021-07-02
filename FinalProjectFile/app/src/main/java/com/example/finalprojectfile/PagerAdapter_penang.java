package com.example.finalprojectfile;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter_penang extends FragmentPagerAdapter {

    private int numofFragments;

    public PagerAdapter_penang(FragmentManager fm, int num)
    {

        super(fm);
        this.numofFragments = num;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new Fragment_About_Penang();
            case 1: return new Fragment_Cultures_Penang();
            case 2: return new Fragment_Foods_Penang();
            case 3: return new Fragment_Spot_Penang();
            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return numofFragments;
    }
}

