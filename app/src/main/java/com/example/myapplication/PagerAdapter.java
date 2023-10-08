package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.fragment.entertainmentfragment;
import com.example.myapplication.fragment.healthfragment;
import com.example.myapplication.fragment.homefragment;
import com.example.myapplication.fragment.sciencefragment;
import com.example.myapplication.fragment.sportsfragment;
import com.example.myapplication.fragment.technologyfragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new homefragment();
            case 1:
                return new sportsfragment();
            case 2:
                return new healthfragment();
            case 3:
                return new sciencefragment();
            case 4:
                return new entertainmentfragment();
            case 5:
                return new technologyfragment();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
