package net.backwings.cinex.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import net.backwings.cinex.Adapter.PageAdapter;
import net.backwings.cinex.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mToolbar= findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        mViewPager= findViewById(R.id.vp_viewpager);
        mTabLayout= findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        mPageAdapter= new PageAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mPageAdapter);
        mViewPager.setOffscreenPageLimit(2);



    }
}
