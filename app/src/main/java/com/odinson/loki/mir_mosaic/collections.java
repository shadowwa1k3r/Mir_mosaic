package com.odinson.loki.mir_mosaic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class collections extends Fragment {
    private RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
   public static final String Title="Collections";

    public static collections newInstance(){
        return new collections();
    }
    public collections() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View coll = inflater.inflate(R.layout.fragment_collections,container,false);
        // Inflate the layout for this fragment
        ArrayList<String> myDataset = getDataSet();

        mRecyclerView = (RecyclerView) coll.findViewById(R.id.recyview);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        return coll;
    }
    private ArrayList<String> getDataSet() {

        ArrayList<String> mDataSet = new ArrayList();

        for (int i = 0; i < 100; i++) {
            mDataSet.add(i, "item" + i);
        }
        mDataSet.add(mDataSet.size(), "пункт" + mDataSet.size() + 1);
        return mDataSet;
    }


}
