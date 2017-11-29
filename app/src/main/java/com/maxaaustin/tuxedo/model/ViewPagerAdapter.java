package com.maxaaustin.tuxedo.model;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 11/29/2017.
 */

class ViewPagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {

    int tabNum;

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragNameList = new ArrayList<>();

    public ViewPagerAdapter(android.support.v4.app.FragmentManager manager, int tabNum) {

        super(manager);
        this.tabNum = tabNum;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: HomeFragment nHomeFrag = new HomeFragment();
                    return nHomeFrag;
            case 1: TweetFragment nTweetFrag = new TweetFragment();
                    return nTweetFrag;
            case 2: PreferencesFragment nPrefFrag = new PreferencesFragment();
                    return  nPrefFrag;
            default:
                return null;
        }

//        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return tabNum;
    }

    public void add(Fragment mFrag, String title) {
        mFragmentList.add(mFrag);
        mFragNameList.add(title);
    }

    public CharSequence getTabTitle(int position){
        return mFragNameList.get(position);
    }
}
