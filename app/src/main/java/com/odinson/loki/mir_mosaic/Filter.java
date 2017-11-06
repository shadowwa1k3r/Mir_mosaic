package com.odinson.loki.mir_mosaic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

/**
 * Created by ergas on 10/30/2017.
 */

public class Filter extends Fragment {

    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5;
    Button button1,button2,button3,button4;


    public Filter(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View fl = inflater.inflate(R.layout.filter,container,false);
        button1 =(Button)fl.findViewById(R.id.expandableButton1);
        button2 =(Button)fl.findViewById(R.id.expandableButton2);
        button3 =(Button)fl.findViewById(R.id.expandableButton3);
        button4 =(Button)fl.findViewById(R.id.expandableButton4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableButton1(fl);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableButton2(fl);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableButton3(fl);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableButton4(fl);
            }
        });

        return fl;
    }
    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButton4(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }
}

