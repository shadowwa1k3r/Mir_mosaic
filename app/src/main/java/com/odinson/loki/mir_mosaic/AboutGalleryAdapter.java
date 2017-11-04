package com.odinson.loki.mir_mosaic;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by ergas on 11/4/2017.
 */

public class AboutGalleryAdapter extends RecyclerView.Adapter<AboutGalleryAdapter.ViewHDab> {

    private ArrayList<AboutGalleryItemType> mData;
    private Context mContext;

    AboutGalleryAdapter (Context context,ArrayList<AboutGalleryItemType> data){
        this.mData=data;
        this.mContext=context;
    }

    @Override
    public AboutGalleryAdapter.ViewHDab onCreateViewHolder(ViewGroup parent, int viewType){
        return new ViewHDab(LayoutInflater.from(mContext).inflate(R.layout.about_gallery_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final AboutGalleryAdapter.ViewHDab holder,final int position){
        final AboutGalleryItemType currentCitem=mData.get(position);
       Glide.with(mContext).load(currentCitem.getImg()).centerCrop().into(holder.mImage);
        holder.bindTo(currentCitem);



    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    class ViewHDab extends RecyclerView.ViewHolder{
        private CardView mCardView;

        private ImageView mImage;


        ViewHDab(final View itemview){
            super(itemview);

            mCardView = (CardView)itemview.findViewById(R.id.ab_cv);
            mImage = (ImageView)itemview.findViewById(R.id.ab_img);
        }

        void bindTo(AboutGalleryItemType current){


        }
    }
}