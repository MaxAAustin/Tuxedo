package com.maxaaustin.tuxedo.model;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 11/29/2017.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragNameList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void add(Fragment mFrag, String title) {
        mFragmentList.add(mFrag);
        mFragNameList.add(title);
    }

    public CharSequence getTabTitle(int position){
        return mFragNameList.get(position);
    }
}
