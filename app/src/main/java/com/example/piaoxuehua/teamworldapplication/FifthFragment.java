package com.example.piaoxuehua.teamworldapplication;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by piaoxuehua on 2017/5/18.
 */


@SuppressLint("ValidFragment")
public class FifthFragment extends Fragment {
    private String context;
    private TextView mTextView;

    public  FifthFragment(String context){
        this.context = context;
    }
    public FifthFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fifth_fragment,container,false);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);

        return view;  }
}
