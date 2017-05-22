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
    private TextView textView;

    String[]from={ "userimages","usernames","moneys","questions","answers","guanzhu","pinglun_num"};
    int[] to={R.id.xuanshang_cell_userlogo,R.id.xuanshang_cell_username,R.id.xuanshang_cell_money,R.id.xuanshang_cell_question,R.id.xuanshang_cell_answer,
    R.id.xuanshang_cell_agree,R.id.xuanshang_cell_pinglun};

    int[] userimages = new int[]{
            R.drawable.home_cell_logo_user1, R.drawable.home_cell_logo_user2, R.drawable.home_cell_logo_user3,
            R.drawable.home_cell_logo_user4
    };
    String[] usernames = new String[]{
            "user1", "user2", "user3",
            "user4"
    };
    String[] moneys = new String[]{
            "10", "30", "10", "50"
    };
    String[] questions = new String[]{
            "question1",
            "question2",
            "question3",
            "question4"

    };
    String[] answers = new String[]{
            "answer1",
            "answer2",
            "answer3",
            "answer4"

    };
    String[] guanzhu = new String[]{
            "260",
            "340",
            "110",
            "320"

    };
    String[] pinglun_num = new String[]{
            "4",
            "3",
            "4",
            "2"

    };
    ArrayList<HashMap<String,String>> list=null;
    HashMap<String,String> map=null;


    public SecondFragment(String context) {
        this.context = context;
    }


    public SecondFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
}





