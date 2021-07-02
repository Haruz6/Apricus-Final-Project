package com.example.finalprojectfile;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter_negeri_sembilan extends FragmentPagerAdapter {

    private int numofFragments;

    public PagerAdapter_negeri_sembilan(FragmentManager fm, int num)
    {

        super(fm);
        this.numofFragments = num;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new Fragment_About_Negeri_Sembilan();
            case 1: return new Fragment_Cultures_Negeri_Sembilan();
            case 2: return new Fragment_Foods_Negeri_Sembilan();
            case 3: return new Fragment_Spot_Negeri_Sembilan();
            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return numofFragments;
    }
}

