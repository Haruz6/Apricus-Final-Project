package com.example.finalprojectfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Page_Johor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_johor);

        TabLayout tablayout = findViewById((R.id.tabBar_johor));
        TabItem tababout_johor = findViewById((R.id.tabItem_About_johor));
        TabItem tabfoods_johor = findViewById((R.id.tabItem_Foods_johor));
        TabItem tabcultures_johor = findViewById((R.id.tabItem_Cultures_johor));
        TabItem tabspot_johor = findViewById((R.id.tabItem_Spot_johor));
        ViewPager viewPager_johor = findViewById(R.id.viewPager1_johor);
        PagerAdapter_johor pagerAdapter = new PagerAdapter_johor(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager_johor.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_johor.setCurrentItem(tab.getPosition());
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