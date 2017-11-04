package com.odinson.loki.mir_mosaic;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments()!=null)
            mSource=getArguments().getString(mykey);
        setHasOptionsMenu(true);
        setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemInfo = inflater.inflate(R.layout.fragment_item_info, container, false);
        // Inflate the layout for this fragment

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        initData(itemInfo);






        return itemInfo;
    }

    public void initData(View itemInfo){

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
        TextView itemcode = (TextView)itemInfo.findViewById(R.id.itemCode);
        TextView itemname = (TextView)itemInfo.findViewById(R.id.itemName);
        TextView itemnamee = (TextView)itemInfo.findViewById(R.id.itemNamee);
        TextView itemmaterial = (TextView)itemInfo.findViewById(R.id.itemMaterial);
        TextView itemcost = (TextView)itemInfo.findViewById(R.id.itemCost);

        TextView tt= (TextView)getActivity().findViewById(R.id.tite);
        TextView st= (TextView)getActivity().findViewById(R.id.subtite);
        st.setText("");
        tt.setText(mSource);

        for(int i=0;i<catItemCode.length;i++) {
            if (catItemName[i].equals(mSource)) {
                Glide.with(getActivity()).load(catItemImg.getResourceId(i,0)).into(itemImg);
                itemcode.setText(catItemCode[i]);
                itemname.setText(catItemName[i]);
                itemmaterial.setText(catItemMaterial[i]);
                itemcost.setText(catItemCost[i]);
                break;
            }
        }
        for (int i=0;i<catItemCode2.length;i++){
            if(catItemName2[i].equals(mSource)){
                Glide.with(getActivity()).load(catItemImg2.getResourceId(i,0)).into(itemImg);
                itemcode.setText(catItemCode2[i]);
                itemname.setText(catItemName2[i]);
                itemmaterial.setText(catItemMaterial2[i]);
                itemcost.setText(catItemCost2[i]);
                break;
            }
        }
        itemnamee.setText(itemname.getText());
        catItemImg.recycle();
        catItemImg2.recycle();

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
