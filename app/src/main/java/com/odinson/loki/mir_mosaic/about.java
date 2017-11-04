package com.odinson.loki.mir_mosaic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class about extends Fragment {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;




    public about() {
        // Required empty public constructor
    }

    public static about newInstance(){
        about itemonfragment = new about();
        return itemonfragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View about = inflater.inflate(R.layout.fragment_about, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mViewPager = (ViewPager)about.findViewById(R.id.viewpagerab);
        setupVPager(mViewPager);
        mTabLayout = (TabLayout)about.findViewById(R.id.tabab);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#1c313a"));
        mTabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        mTabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#000a12"));



        return about;
    }


    private void setupVPager(ViewPager viewPager){
        mVPadapter mvpadapter = new mVPadapter(getChildFragmentManager());
        mvpadapter.addFragment(new AboutUs(),"ABOUT US");
        mvpadapter.addFragment(new AboutGallery(),"GALLERY");
        mvpadapter.addFragment(new AboutCatalog(),"CATALOG");
        mvpadapter.addFragment(new AboutGallery(),"INSTALLATION");
        viewPager.setAdapter(mvpadapter);

    }

    class mVPadapter extends FragmentPagerAdapter{
        private final List<Fragment> FragmentList = new ArrayList<>();
        private final List<String> FragmentTitleList = new ArrayList<>();


        public mVPadapter(FragmentManager fragmentManager){
            super(fragmentManager);
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
