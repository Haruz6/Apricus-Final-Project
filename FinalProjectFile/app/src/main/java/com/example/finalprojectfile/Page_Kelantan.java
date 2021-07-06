package com.example.finalprojectfile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Page_Kelantan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_kelantan);

        TabLayout tablayout = findViewById((R.id.tabBar_kelantan));
        TabItem tababout_kelantan = findViewById((R.id.tabItem_About_kelantan));
        TabItem tabfoods_kelantan = findViewById((R.id.tabItem_Foods_kelantan));
        TabItem tabcultures_kelantan = findViewById((R.id.tabItem_Cultures_kelantan));
        TabItem tabspot_kelantan = findViewById((R.id.tabItem_Spot_kelantan));
        ViewPager viewPager_kelantan = findViewById(R.id.viewPager1_kelantan);
        PagerAdapter_kelantan pagerAdapter = new PagerAdapter_kelantan(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager_kelantan.setAdapter(pagerAdapter);

        viewPager_kelantan.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                int currectitem = viewPager_kelantan.getCurrentItem();
                tablayout.setScrollPosition(currectitem,0,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_kelantan.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}