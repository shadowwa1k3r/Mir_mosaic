package com.odinson.loki.mir_mosaic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabbedItemGallery extends Fragment {

    private static final String ARG_PARAM1 = "param1";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String cats;
    private String[] var = {"ALASKA","BALI"};
   // String[] categoryList1 =getResources().getStringArray(R.array.Natural);


    public TabbedItemGallery() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TabbedItemGallery newInstance(String param1) {
        TabbedItemGallery fragment = new TabbedItemGallery();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tabbedV = inflater.inflate(R.layout.tabbed_item_list,container,false);
        ViewPager tabpager = (ViewPager)tabbedV.findViewById(R.id.itempager);
        setupViewPager(tabpager);

        final TabLayout tL = (TabLayout)tabbedV.findViewById(R.id.itemtabs);

        final TextView tt= (TextView)getActivity().findViewById(R.id.tite);

        for(int i = 0; i<2;i++){
            if(var[i].equals(mParam1)) {

                tabpager.setCurrentItem(i);
                tabpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        tt.setText(var[tL.getSelectedTabPosition()]);

                       // Toast.makeText(getContext(),var[tL.getSelectedTabPosition()],Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onPageSelected(int position) {
                        tt.setText(var[tL.getSelectedTabPosition()]);
                      //  Toast.makeText(getContext(),var[tL.getSelectedTabPosition()],Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {


                    }
                });



            }
        }



        tL.setSelectedTabIndicatorColor(Color.parseColor("#1c313a"));
        tL.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tL.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#000a12"));

        tL.setupWithViewPager(tabpager);


        return tabbedV;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());


        adapter.addFrag(CategoryItems.newInstance(var[0]), "ALASKA");
        //Toast.makeText(getContext(),categoryList1[0],Toast.LENGTH_SHORT);
        adapter.addFrag(CategoryItems.newInstance(var[1]), "BALI");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

