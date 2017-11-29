package com.maxaaustin.tuxedo.model;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maxaaustin.tuxedo.R;

public class MainActivity extends AppCompatActivity /*implements MainActivityInterface*/{

    public static MainActivity instance;
    TabLayout mAllTabs;
    ViewPagerAdapter pagerAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        ViewPager mViewPager = (ViewPager) findViewById(R.id.tab_pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.add(new HomeFragment(), "Home");
        pagerAdapter.add(new TweetFragment(), "Responses");
        pagerAdapter.add(new PreferencesFragment(),"Lifestyle");

        mViewPager.setAdapter(pagerAdapter);
        mAllTabs = (TabLayout) findViewById(R.id.main_tabs);
        mAllTabs.setupWithViewPager(mViewPager);



//        String username = getIntent().getStringExtra("username");
//        TextView mainUsername = (TextView) findViewById(R.id.main_username);
//        mainUsername.setText(username);
    }

    public static MainActivity getInstance(){
        return instance;
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
