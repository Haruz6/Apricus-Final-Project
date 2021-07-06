package com.example.finalprojectfile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Page_Pahang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_pahang);

        TabLayout tablayout = findViewById((R.id.tabBar_pahang));
        TabItem tababout_pahang = findViewById((R.id.tabItem_About_pahang));
        TabItem tabfoods_pahang = findViewById((R.id.tabItem_Foods_pahang));
        TabItem tabcultures_pahang = findViewById((R.id.tabItem_Cultures_pahang));
        TabItem tabspot_pahang = findViewById((R.id.tabItem_Spot_pahang));
        ViewPager viewPager_pahang = findViewById(R.id.viewPager1_pahang);
        PagerAdapter_pahang pagerAdapter = new PagerAdapter_pahang(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager_pahang.setAdapter(pagerAdapter);

        viewPager_pahang.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                int currectitem = viewPager_pahang.getCurrentItem();
                tablayout.setScrollPosition(currectitem,0,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_pahang.setCurrentItem(tab.getPosition());
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