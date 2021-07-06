package com.example.finalprojectfile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Page_Penang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_penang);

        TabLayout tablayout = findViewById((R.id.tabBar_penang));
        TabItem tababout_penang = findViewById((R.id.tabItem_About_penang));
        TabItem tabfoods_penang = findViewById((R.id.tabItem_Foods_penang));
        TabItem tabcultures_penang = findViewById((R.id.tabItem_Cultures_penang));
        TabItem tabspot_penang = findViewById((R.id.tabItem_Spot_penang));
        ViewPager viewPager_penang = findViewById(R.id.viewPager1_penang);
        PagerAdapter_penang pagerAdapter = new PagerAdapter_penang(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager_penang.setAdapter(pagerAdapter);

        viewPager_penang.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                int currectitem = viewPager_penang.getCurrentItem();
                tablayout.setScrollPosition(currectitem,0,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_penang.setCurrentItem(tab.getPosition());
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