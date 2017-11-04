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

public class AboutGallery extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AboutGalleryAdapter mAdapter;
    private ArrayList<AboutGalleryItemType> mDataset;

    public AboutGallery() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AboutGallery newInstance() {
        AboutGallery fragment = new AboutGallery();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ab_gal=inflater.inflate(R.layout.fragment_about_gallery, container, false);


        mRecyclerView = (RecyclerView)ab_gal.findViewById(R.id.aboutGallery);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),4);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDataset = new ArrayList<AboutGalleryItemType>();

        mAdapter = new AboutGalleryAdapter(getActivity(),mDataset);

        mRecyclerView.setAdapter(mAdapter);

        initdata();



        // Inflate the layout for this fragment


        return  ab_gal;
    }

    private void initdata(){
        TypedArray catItemImg2 = getResources().obtainTypedArray(R.array.baliItemImg);

        mDataset.clear();
        for (int i=0; i<catItemImg2.length();i++){
        mDataset.add(new AboutGalleryItemType(catItemImg2.getResourceId(i,0)));
    }}

}
