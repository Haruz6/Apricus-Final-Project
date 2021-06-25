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

        TabLayout tablayout = findViewById((R.id.tabBar_Johor));
        TabItem tababout_johor = findViewById((R.id.tabItem_About_Johor));
        TabItem tabfoods_johor = findViewById((R.id.tabItem_Foods_Johor));
        TabItem tabcultures_johor = findViewById((R.id.tabItem_Cultures_Johor));
        TabItem tabspot_johor = findViewById((R.id.tabItem_Spot_Johor));
        ViewPager viewPager_johor = findViewById(R.id.viewPager1_Johor);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());
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