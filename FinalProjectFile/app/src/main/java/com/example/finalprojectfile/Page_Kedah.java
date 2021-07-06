package com.example.finalprojectfile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Page_Kedah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_kedah);

        TabLayout tablayout = findViewById((R.id.tabBar_kedah));
        TabItem tababout_kedah = findViewById((R.id.tabItem_About_kedah));
        TabItem tabfoods_kedah = findViewById((R.id.tabItem_Foods_kedah));
        TabItem tabcultures_kedah = findViewById((R.id.tabItem_Cultures_kedah));
        TabItem tabspot_kedah = findViewById((R.id.tabItem_Spot_kedah));
        ViewPager viewPager_kedah = findViewById(R.id.viewPager1_kedah);
        PagerAdapter_kedah pagerAdapter = new PagerAdapter_kedah(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager_kedah.setAdapter(pagerAdapter);
        viewPager_kedah.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                int currectitem = viewPager_kedah.getCurrentItem();
                tablayout.setScrollPosition(currectitem,0,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_kedah.setCurrentItem(tab.getPosition());
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