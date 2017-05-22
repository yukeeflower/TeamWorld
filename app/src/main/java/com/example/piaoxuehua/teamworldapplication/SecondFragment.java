package com.example.piaoxuehua.teamworldapplication;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by piaoxuehua on 2017/5/4.
 */
@SuppressLint("ValidFragment")
public class SecondFragment extends Fragment {
    private String context;
    private TextView mTextView;

    public  SecondFragment(String context){
        this.context = context;
    }
    public SecondFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,container,false);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);

        return view;  }
}





