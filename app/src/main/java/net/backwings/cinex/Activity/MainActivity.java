package net.backwings.cinex.Activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import net.backwings.cinex.Adapter.PageAdapter;
import net.backwings.cinex.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TableLayout mTabLayout;
    private PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager= findViewById(R.id.vp_viewpager);
        mTabLayout= findViewById(R.id.tl_tabs);
        mPageAdapter= new PageAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mPageAdapter);



    }
}
