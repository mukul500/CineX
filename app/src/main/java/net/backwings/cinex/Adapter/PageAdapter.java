package net.backwings.cinex.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.backwings.cinex.Fragment.HighestratedMovies;
import net.backwings.cinex.Fragment.MostPopularMovies;

/**
 * Created by mukul on 1/25/2018.
 */

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            {
                return new HighestratedMovies();
            }
            default:
            {
                return new MostPopularMovies();
            }
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position)
        {
            case 0:
            {
                return "Highest Rated";
            }
            default:
            {
                return "Most Popular";
            }
        }
    }
    @Override
    public int getCount() {
        return 2;
    }
}
