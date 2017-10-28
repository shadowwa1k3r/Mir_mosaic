package com.odinson.loki.mir_mosaic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ergas on 10/28/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private static int TAB_COUNT = 2;
    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){

        switch (position){
            case 0:
                return collections.newInstance();
            case 1:
                return product_filter.newInstance();
        }
        return null;
    }
    @Override
    public int getCount(){
        return TAB_COUNT;
    }
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return collections.Title;
            case 1:
                return product_filter.Title;
        }
        return super.getPageTitle(position);
    }
}
