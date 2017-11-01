package com.odinson.loki.mir_mosaic;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by ergas on 11/1/2017.
 */

public class RACategoryItem extends RecyclerView.Adapter<RACategoryItem.ViewHD> {

    private ArrayList<CategoryItemsType> mData;
    private Context mContext;

    RACategoryItem (Context context,ArrayList<CategoryItemsType> data){
        this.mData=data;
        this.mContext=context;
    }

    @Override
    public RACategoryItem.ViewHD onCreateViewHolder(ViewGroup parent, int viewType){
        return new ViewHD(LayoutInflater.from(mContext).inflate(R.layout.categoryitem,parent,false));
    }

    @Override
    public void onBindViewHolder(final RACategoryItem.ViewHD holder,final int position){
        final CategoryItemsType currentCitem=mData.get(position);
        Glide.with(mContext).load(currentCitem.getImg()).into(holder.mImage);
        holder.bindTo(currentCitem);
        final String item = mData.get(position).getCode();

    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    class ViewHD extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private TextView mCode;
        private ImageView mImage;
        private TextView mCost;
        private TextView mName;
        private TextView mMaterial;

        ViewHD(final View itemview){
            super(itemview);

            mCardView = (CardView)itemview.findViewById(R.id.citemcard_view);
            mCode = (TextView)itemview.findViewById(R.id.catCode);
            mName = (TextView)itemview.findViewById(R.id.catName);
            mCost = (TextView)itemview.findViewById(R.id.catCost);
            mMaterial = (TextView)itemview.findViewById(R.id.catMat);
            mImage = (ImageView)itemview.findViewById(R.id.catItem);
        }

        void bindTo(CategoryItemsType current){
            mCode.setText(current.getCode());
            mName.setText(current.getName());
            mCost.setText(current.getCost());
            mMaterial.setText(current.getMaterial());

        }
    }
}
