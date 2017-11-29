package com.maxaaustin.tuxedo.model;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maxaaustin.tuxedo.R;
import com.maxaaustin.tuxedo.model.TweetFragment.OnFragmentInteractionListener;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, OnFragmentInteractionListener, PreferencesFragment.OnFragmentInteractionListener /*implements MainActivityInterface*/{

    public static MainActivity instance;
    TabLayout mAllTabs;
    ViewPagerAdapter pagerAdapter;




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

}
