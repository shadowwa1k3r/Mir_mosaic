package com.odinson.loki.mir_mosaic;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CategoryItems extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RACategoryItem mAdapter;
    private ArrayList<CategoryItemsType> mDataset;







    public static CategoryItems newInstance() {
        CategoryItems fragment = new CategoryItems();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View catIteL = inflater.inflate(R.layout.fragment_category_items, container, false);

        mRecyclerView = (RecyclerView)catIteL.findViewById(R.id.categoryiteml);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDataset = new ArrayList<CategoryItemsType>();

        mAdapter = new RACategoryItem(getActivity(),mDataset);

        mRecyclerView.setAdapter(mAdapter);

        initializeData();


        // Inflate the layout for this fragment
        return catIteL;
    }

    private void initializeData() {
        //Get the resources from the XML file
        String[] catItemName = getResources().getStringArray(R.array.alaskaItemName);
        String[] catItemCode = getResources().getStringArray(R.array.alaskaItemCode);
        String[] catItemCost = getResources().getStringArray(R.array.alaskaItemCost);
        String[] catItemMaterial = getResources().getStringArray(R.array.alaskaItemMaterial);
        TypedArray catItemImg = getResources().obtainTypedArray(R.array.alaskaItemImg);
        //String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        //Clear the existing data (to avoid duplication)
        mDataset.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for(int i=0;i<catItemCode.length;i++){
            mDataset.add(new CategoryItemsType(catItemName[i],catItemCode[i],catItemCost[i],catItemMaterial[i],catItemImg.getResourceId(i,0)));
        }
        catItemImg.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

}
