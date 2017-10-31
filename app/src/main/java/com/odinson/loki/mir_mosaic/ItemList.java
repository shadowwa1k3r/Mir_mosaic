package com.odinson.loki.mir_mosaic;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ItemList extends Fragment {

    private RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
    private ArrayList<itemtype> myDataset;

    public static ItemList newInstance(){
        ItemList itemOnFragment = new ItemList();
        return itemOnFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View il = inflater.inflate(R.layout.fragment_item_list,container,false);


        mRecyclerView = (RecyclerView) il.findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        myDataset = new ArrayList<>();

        mAdapter = new RecyclerAdapter(getActivity(),myDataset);

        mRecyclerView.setAdapter(mAdapter);

        initializeData();;

        return il;
    }

    private void initializeData() {
        //Get the resources from the XML file
        String[] mosaicList = getResources().getStringArray(R.array.titles);
        TypedArray bannerresource = getResources().obtainTypedArray(R.array.banner);
        //String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        //Clear the existing data (to avoid duplication)
        myDataset.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for(int i=0;i<mosaicList.length;i++){
            myDataset.add(new itemtype(mosaicList[i],bannerresource.getResourceId(i,0)));
        }
        bannerresource.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }




}
