package com.odinson.loki.mir_mosaic;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class ItemInfo extends Fragment {


    private String mSource;
    private static String mykey = "Id";
    private ArrayList<ItemInfoModel> mDataset;



    public static ItemInfo newInstance(String param1){
        ItemInfo fragment = new ItemInfo();
        Bundle args = new Bundle();
        args.putString(mykey,param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments()!=null)
            mSource=getArguments().getString(mykey);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemInfo = inflater.inflate(R.layout.fragment_item_info, container, false);
        // Inflate the layout for this fragment

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
        String []catItemId2 = getResources().getStringArray(R.array.baliid);


        ImageView itemImg = (ImageView)itemInfo.findViewById(R.id.itemImg);
        String[][] s = new String[1][];
        s[0][] = getResources().getStringArray(R.array.alaskaItemCode);


        for(int i=0;i<s.length;i++) {
            if (s[i].equals(mSource)) {
                Glide.with(getActivity()).load(catItemImg.getResourceId(i,0)).into(itemImg);


            }
        }
        catItemImg.recycle();
        catItemImg2.recycle();




        return itemInfo;
    }

    private String[] concat(String[] A, String[] B) {
        int aLen = A.length;
        int bLen = B.length;
        String[] C= new String[aLen+bLen];
        System.arraycopy(A, 0, C, 0, aLen);
        System.arraycopy(B, 0, C, aLen, bLen);
        return C;
    }


}
