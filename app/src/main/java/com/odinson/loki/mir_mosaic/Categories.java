package com.odinson.loki.mir_mosaic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Categories extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RAdapterCategory mRAdapterCategory;
    private ArrayList<CategoryType> mDataset;
    private static String myparam="Name";
    private String sSource;
    TextView st;



    // TODO: Rename and change types and number of parameters
    public static Categories newInstance(String param1) {
        Categories fragment = new Categories();
        Bundle args = new Bundle();
        args.putString(myparam,param1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null)
            sSource=getArguments().getString(myparam);
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

        View categories = inflater.inflate(R.layout.fragment_categories,container,false);

        mRecyclerView = (RecyclerView)categories.findViewById(R.id.my_recycler_view_categories);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        mDataset = new ArrayList<CategoryType>();
        mRAdapterCategory = new RAdapterCategory(getActivity(),mDataset);

        mRecyclerView.setAdapter(mRAdapterCategory);
        initializeData();

        return categories;
    }
    public void initializeData(){
        String[] categoryList1 =getResources().getStringArray(R.array.Natural);
        String[] categoryList2 =getResources().getStringArray(R.array.Skalini);
        String[] categoryList3 =getResources().getStringArray(R.array.Alma);
        String[] categoryList4 =getResources().getStringArray(R.array.Closeouts);
        mDataset.clear();

        Toast.makeText(getContext(),sSource,Toast.LENGTH_LONG).show();

        st= (TextView)getActivity().findViewById(R.id.subtite);
        st.setText(sSource);
        TextView tt= (TextView)getActivity().findViewById(R.id.tite);
        tt.setText("MirMosaic");


        switch (sSource){
            case "Natural": mDataset.clear();for (int i=0; i<categoryList1.length;i++){
                mDataset.add(new CategoryType(categoryList1[i]));
            } break;
            case "Skalini": mDataset.clear();for (int i=0; i<categoryList2.length;i++){
                mDataset.add(new CategoryType(categoryList2[i]));
            } break;
            case "Alma": mDataset.clear();for (int i=0; i<categoryList3.length;i++){
                mDataset.add(new CategoryType(categoryList3[i]));
            } break;
            case "Closeouts": mDataset.clear();for (int i=0; i<categoryList4.length;i++){
                mDataset.add(new CategoryType(categoryList4[i]));
            } break;
        }

        mRAdapterCategory.notifyDataSetChanged();
    }


}
