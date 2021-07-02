package com.example.finalprojectfile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Page_Melaka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_melaka);

        TabLayout tablayout = findViewById((R.id.tabBar_melaka));
        TabItem tababout_melaka = findViewById((R.id.tabItem_About_melaka));
        TabItem tabfoods_melaka = findViewById((R.id.tabItem_Foods_melaka));
        TabItem tabcultures_melaka = findViewById((R.id.tabItem_Cultures_melaka));
        TabItem tabspot_melaka = findViewById((R.id.tabItem_Spot_melaka));
        ViewPager viewPager_melaka = findViewById(R.id.viewPager1_melaka);
        PagerAdapter_melaka pagerAdapter = new PagerAdapter_melaka(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager_melaka.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_melaka.setCurrentItem(tab.getPosition());
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