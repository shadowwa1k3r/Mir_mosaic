package com.odinson.loki.mir_mosaic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class product_list extends Fragment {




    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static product_list newInstance(){
        product_list itemOnFragment = new product_list();
        return itemOnFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View plist = inflater.inflate(R.layout.fragment_product_list,container,false);

        viewPager = (ViewPager)plist.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout)plist.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return plist;
    }
    private void setupViewPager(ViewPager viewPager){
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new ItemList(),"Collections");
        adapter.addFragment(new Filter(),"Filter");

        viewPager.setAdapter(adapter);

    }
    class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> FragmentList = new ArrayList<>();
        private final List<String> FragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentList.get(position);
        }

        @Override
        public int getCount() {
            return FragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            FragmentList.add(fragment);
            FragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return FragmentTitleList.get(position);
        }
    }



}
