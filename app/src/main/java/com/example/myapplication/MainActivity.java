package com.example.myapplication;

import static com.example.myapplication.R.id.toolbars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,mscience,mentertainment,mheatlh,msports,mtechnology;
    PagerAdapter pagerAdapter;
  Toolbar mtoolbar;
  String api ="c8c48dfa60234a398d81ab7160c16859";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar =findViewById(R.id.toolbars);
        setSupportActionBar(mtoolbar);
        mhome = findViewById(R.id.home);
        mentertainment = findViewById(R.id.entertainment);
        mheatlh = findViewById(R.id.health);
        msports = findViewById(R.id.sport);
        mscience = findViewById(R.id.science);
        mtechnology = findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.faragmentcontainer);
        tabLayout=findViewById(R.id.include);


        pagerAdapter = new com.example.myapplication.PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)
                {
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}