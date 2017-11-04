package com.odinson.loki.mir_mosaic;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by ergas on 10/31/2017.
 */

public class RAdapterCategory extends RecyclerView.Adapter<RAdapterCategory.ViewH>{

    private ArrayList<CategoryType> mCategoryData;
    private Context mContext;

    RAdapterCategory(Context context, ArrayList<CategoryType> mCategoryData){
        this.mCategoryData = mCategoryData;
        this.mContext = context;
    }


    @Override
    public RAdapterCategory.ViewH onCreateViewHolder(ViewGroup parent, int viewType){
        return new ViewH(LayoutInflater.from(mContext).inflate(R.layout.category,parent,false));
    }

    @Override
    public void onBindViewHolder(RAdapterCategory.ViewH holder, int position) {
        CategoryType currentCategory = mCategoryData.get(position);
        holder.bindTo(currentCategory);
        final String item = mCategoryData.get(position).getName();

        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left,R.anim.slide_in_right,R.anim.slide_in_left,R.anim.slide_in_right).replace(R.id.content,CategoryItems.newInstance(item)).addToBackStack(null).commit();

            }
        });
    }
    @Override
    public int getItemCount(){
        return mCategoryData.size();

    }

    class ViewH extends RecyclerView.ViewHolder{
        private Button mButton;


        ViewH(View itemView){
            super(itemView);
            mButton = (Button)itemView.findViewById(R.id.mBC);
        }

        void bindTo(CategoryType currentCategory){
            mButton.setText(currentCategory.getName());
        }
    }
}
