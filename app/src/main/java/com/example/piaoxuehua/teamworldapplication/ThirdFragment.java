package com.example.piaoxuehua.teamworldapplication;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by piaoxuehua on 2017/5/4.
 */
@SuppressLint("ValidFragment")

public class ThirdFragment extends Fragment {
    private String context;
    private TextView mTextView;
    private ImageButton buttonzudui;

    public  ThirdFragment(String context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment,container,false);
//        mTextView = (TextView)view.findViewById(R.id.txt_content);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
//        mTextView.setText(context);
        return view;

    }
    public ThirdFragment(){}

    @Override
    public void onStart() {
        super.onStart();
        ImageButton buttonzudui=(ImageButton)getActivity().findViewById(R.id.more_zudui);
//        Intent intent =new Intent(getActivity(),JoinActivity.class);
//        startActivity(intent);
        buttonzudui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),JoinActivity.class);
                startActivity(intent);

            }
        });

    }


    }

