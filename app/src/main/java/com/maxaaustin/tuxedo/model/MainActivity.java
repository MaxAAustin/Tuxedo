package com.maxaaustin.tuxedo.model;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maxaaustin.tuxedo.R;
import com.maxaaustin.tuxedo.model.TweetFragment.OnFragmentInteractionListener;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, OnFragmentInteractionListener, PreferencesFragment.OnFragmentInteractionListener /*implements MainActivityInterface*/{

    //com.maxaaustin.tuxedo.model.LoginActivity login = getIntent().getParcelableExtra("User");

    public static MainActivity instance;
    TabLayout mAllTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        //Creates a new TabLayout object and adds three tabs labelled with the following CharSequences.
        mAllTabs = (TabLayout) findViewById(R.id.main_tabs);
        mAllTabs.addTab(mAllTabs.newTab().setText("Home"));
        mAllTabs.addTab(mAllTabs.newTab().setText("Tweets"));
        mAllTabs.addTab(mAllTabs.newTab().setText("Lifestyle"));

        mAllTabs.setTabGravity(android.support.design.widget.TabLayout.GRAVITY_FILL);
        mAllTabs.setTabMode(android.support.design.widget.TabLayout.MODE_FIXED);

        final ViewPager mViewPager = (ViewPager) findViewById(R.id.tab_pager);
        final ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mAllTabs.getTabCount());
        mViewPager.setAdapter(pagerAdapter);

        mViewPager.setOnPageChangeListener(new android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener(mAllTabs));

        mAllTabs.setOnTabSelectedListener(new android.support.design.widget.TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(android.support.design.widget.TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(android.support.design.widget.TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(android.support.design.widget.TabLayout.Tab tab) {

            }
        });

//        String username = getIntent().getStringExtra("username");
//        TextView mainUsername = (TextView) findViewById(R.id.main_username);
//        mainUsername.setText(username);
    }

    public static MainActivity getInstance(){
        return instance;
    }

    @Override
    public void onFragmentInteraction(android.net.Uri uri) {

    }


//    @Override
//    public void hideActionBar() {
//        getSupportActionBar().addOnMenuVisibilityListener(new ActionBar.OnMenuVisibilityListener() {
//            @Override
//            public void onMenuVisibilityChanged(boolean isVisible) {
//
//            }
//        });
//    }

    private class ViewPagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {

        int tabNum;

        private final java.util.List<android.support.v4.app.Fragment> mFragmentList = new java.util.ArrayList<>();
        private final java.util.List<String> mFragNameList = new java.util.ArrayList<>();

        public ViewPagerAdapter(android.support.v4.app.FragmentManager manager, int tabNum) {

            super(manager);
            this.tabNum = tabNum;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
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

        public void add(android.support.v4.app.Fragment mFrag, String title) {
            mFragmentList.add(mFrag);
            android.support.v4.app.FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            trans.commit();
            mFragNameList.add(title);
        }

        public CharSequence getTabTitle(int position){
            return mFragNameList.get(position);
        }
    }

}
