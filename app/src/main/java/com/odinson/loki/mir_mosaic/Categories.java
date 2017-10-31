package com.odinson.loki.mir_mosaic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Categories extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RAdapterCategory mRAdapterCategory;
    private ArrayList<CategoryType> mDataset;



    // TODO: Rename and change types and number of parameters
    public static Categories newInstance(String param1, String param2) {
        Categories fragment = new Categories();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View categories = inflater.inflate(R.layout.fragment_categories,container,false);

        mRecyclerView = (RecyclerView)categories.findViewById(R.id.my_recycler_view_categories);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDataset = new ArrayList<CategoryType>();
        mRAdapterCategory = new RAdapterCategory(getActivity(),mDataset);

        mRecyclerView.setAdapter(mRAdapterCategory);
        initializeData();

        return categories;
    }
    public void initializeData(){
        String[] categoryList =getResources().getStringArray(R.array.Natural);
        mDataset.clear();

        for (int i=0; i<categoryList.length;i++){
            mDataset.add(new CategoryType(categoryList[i]));
        }
        mRAdapterCategory.notifyDataSetChanged();
    }


}
