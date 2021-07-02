package com.example.finalprojectfile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Page_Negeri_Sembilan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_negeri_sembilan);

        TabLayout tablayout = findViewById((R.id.tabBar_negeri_sembilan));
        TabItem tababout_negeri_sembilan = findViewById((R.id.tabItem_About_negeri_sembilan));
        TabItem tabfoods_negeri_sembilan = findViewById((R.id.tabItem_Foods_negeri_sembilan));
        TabItem tabcultures_negeri_sembilan = findViewById((R.id.tabItem_Cultures_negeri_sembilan));
        TabItem tabspot_negeri_sembilan = findViewById((R.id.tabItem_Spot_negeri_sembilan));
        ViewPager viewPager_negeri_sembilan = findViewById(R.id.viewPager1_negeri_sembilan);
        PagerAdapter_negeri_sembilan pagerAdapter = new PagerAdapter_negeri_sembilan(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager_negeri_sembilan.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_negeri_sembilan.setCurrentItem(tab.getPosition());
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