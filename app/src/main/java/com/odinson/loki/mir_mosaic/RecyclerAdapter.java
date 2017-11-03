package com.odinson.loki.mir_mosaic;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.odinson.loki.mir_mosaic.R.layout.item;

/**
 * Created by ergas on 10/28/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    //Member variables
    private ArrayList<itemtype> mMosaicData;
    private Context mContext;

    RecyclerAdapter(Context context, ArrayList<itemtype> mosaicData) {
        this.mMosaicData = mosaicData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create ViewHolder.
     */
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, final int position) {
        //Get current sport
        final itemtype currentMosaic = mMosaicData.get(position);
        Glide.with(mContext).load(currentMosaic.getThumbnail()).centerCrop().into(holder.banner);
        holder.bindTo(currentMosaic);
        final String item = mMosaicData.get(position).getName();


        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN ).replace(R.id.content,Categories.newInstance(item)).addToBackStack(null).commit();
            }
        });
        holder.mTitleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.content,Categories.newInstance(item)).addToBackStack(null).commit();
            }
        });
        holder.banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.content,Categories.newInstance(item)).addToBackStack(null).commit();
            }
        });
    }


    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mMosaicData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView
     */
    class ViewHolder extends RecyclerView.ViewHolder{

        //Member Variables for the TextViews
        private TextView mTitleText;
        private ImageView banner;
        private CardView cv;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        ViewHolder(final View itemView) {
            super(itemView);

             cv = (CardView)itemView.findViewById(R.id.gcard_view);


            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            banner = (ImageView)itemView.findViewById(R.id.thumbnail);

        }

        void bindTo(itemtype currentMosaic){
            //Populate the textviews with data
            mTitleText.setText(currentMosaic.getName());
            //mInfoText.setText(currentMosaic.getInfo());

        }
    }
}
