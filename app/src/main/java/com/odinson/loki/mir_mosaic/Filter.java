package com.odinson.loki.mir_mosaic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by ergas on 10/30/2017.
 */

public class Filter extends Fragment {
    public Filter(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View fl = inflater.inflate(R.layout.filter,container,false);
        return fl;
    }
}
