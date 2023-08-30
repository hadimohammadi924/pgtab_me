package com.example.pgtabme.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment>fragment;
    String[]title;



    public ViewPagerAdapter(FragmentManager fm,List<Fragment>fragment,String[]title) {
        super(fm);
        this.fragment=fragment;
        this.title=title;

    }

    @Override
    public Fragment getItem(int i) {
        return fragment.get(i);
    }


    @Override
    public int getCount() {
        return fragment.size();
    }
    public CharSequence getPageTitle(int position) {
        return  title[position];
    }

}