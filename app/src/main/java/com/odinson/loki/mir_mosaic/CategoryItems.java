package com.odinson.loki.mir_mosaic;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class CategoryItems extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RACategoryItem mAdapter;
    private ArrayList<CategoryItemsType> mDataset;
    private static String myparam = "Name";
    private String mSource;







    public static CategoryItems newInstance(String param1) {
        CategoryItems fragment = new CategoryItems();
        Bundle args = new Bundle();
        args.putString(myparam,param1);
        fragment.setArguments(args);

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null)
            mSource = getArguments().getString(myparam);
        setHasOptionsMenu(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();

                //Toast.makeText(getContext(),"asd",Toast.LENGTH_LONG).show();
                return true;

        }
        return false;
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdapter = new RACategoryItem(getActivity(),mDataset);

        mRecyclerView.setAdapter(mAdapter);
        //TextView tt = (TextView)catIteL.findViewById(R.id.subtite);
        //tt.setText(mSource);

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
        String[] catItemId = getResources().getStringArray(R.array.alaskaid);
        //String[] sportsInfo = getResources().getStringArray(R.array.sports_info);
        String[] catItemName2 = getResources().getStringArray(R.array.baliItemName);
        String[] catItemCode2 = getResources().getStringArray(R.array.baliItemCode);
        String[] catItemCost2 = getResources().getStringArray(R.array.baliItemCost);
        String[] catItemMaterial2 = getResources().getStringArray(R.array.baliItemMaterial);
        TypedArray catItemImg2 = getResources().obtainTypedArray(R.array.baliItemImg);
        String[] catItemId2 = getResources().getStringArray(R.array.baliid);

        mDataset.clear();
        TextView st= (TextView)getActivity().findViewById(R.id.subtite);
        TextView tt= (TextView)getActivity().findViewById(R.id.tite);
        tt.setText(mSource);
        //tt.setText("MirMosaic");

        //Clear the existing data (to avoid duplication)


        //Create the ArrayList of Sports objects with the titles and information about each sport

        switch (mSource){
            case "ALASKA": mDataset.clear();for(int i=0;i<catItemCode.length;i++){
                mDataset.add(new CategoryItemsType(catItemId[i],catItemName[i],catItemCode[i],catItemCost[i],catItemMaterial[i],catItemImg.getResourceId(i,0)));}
                catItemImg.recycle();
                break;
            case "BALI" : mDataset.clear();for(int i=0;i<catItemCode2.length;i++){
                mDataset.add(new CategoryItemsType(catItemId2[i],catItemName2[i],catItemCode2[i],catItemCost2[i],catItemMaterial2[i],catItemImg2.getResourceId(i,0)));}
                catItemImg2.recycle();
                break;

        }

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

}
