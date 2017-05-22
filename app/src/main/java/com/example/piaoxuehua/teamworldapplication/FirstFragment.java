package com.example.piaoxuehua.teamworldapplication;

import android.annotation.SuppressLint;
import android.app.Fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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

@SuppressLint("ValidFragment")
public class FirstFragment extends Fragment {
    private String context;
    private ListView listView;
    private ImageView imageView;
    private TextView textView;
    int[] images = new int[]{
            R.drawable.home_cell_logo_user1, R.drawable.home_cell_logo_user2, R.drawable.home_cell_logo_user3,
            R.drawable.home_cell_logo_user4
    };
    int[] seximages = new int[]{
            R.drawable.home_cell_sex_women, R.drawable.home_cell_sex_men,
            R.drawable.home_cell_sex_men, R.drawable.home_cell_sex_women
    };
    String[] names = new String[]{
            "三只小熊", "两只老鼠", "你好，笨笨",
            "下个路口相遇"
    };
    String[] schoolname = new String[]{
            "中南民族大学", "海军工程大学", "武汉大学", "中国地质大学"
    };
    String[] content = new String[]{
            "设计有关分享生活的交流平台",
            "做出用于电影票、演出票的订购平台",
            "做出集购买车票、订购景点门票、美食折扣与一体的平台",
            "组织做出类似淘宝的购物APP"

    };
    private List<Model> modelList = new ArrayList<>();
    MyBroadcastReceiver myBroadcastReceiver;

    public FirstFragment(String context) {
        this.context = context;
    }

    public FirstFragment() {
    }

    @Nullable

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
         myBroadcastReceiver = new FirstFragment.MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("BROADCAST_ACTION");
        getActivity().registerReceiver(myBroadcastReceiver, filter);
        for (int i = 0; i < names.length; i++) {
            Model model = new Model();
            model.setName(names[i]);
            model.setImage(images[i]);
            model.setJianjie(content[i]);
            model.setSchool(schoolname[i]);
            model.setSeximage(seximages[i]);
            modelList.add(model);
        }


        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = modelList.size()-1; i >-1; i--) {
            Map<String, Object> map = new HashMap<>();
            map.put("logo", modelList.get(i).getImage());
            map.put("name", modelList.get(i).getName());
            map.put("sex", modelList.get(i).getSeximage());
            map.put("school", modelList.get(i).getSchool());
            map.put("text", modelList.get(i).getJianjie());
            list.add(map);
        }
//        mTextView = (TextView) view.findViewById(R.id.txt_content);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
//        mTextView.setText(context);
        listView = (ListView) getActivity().findViewById(R.id.first_fraggement_list);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this.getActivity(), list, R.layout.layout_home_cell, new String[]{"logo", "name", "sex", "school", "text"},
                new int[]{R.id.home_userimage, R.id.home_username, R.id.home_usersex, R.id.home_schoolname, R.id.home_project_content});
        simpleAdapter.notifyDataSetChanged();
        listView.setAdapter(simpleAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(DirectActivity.this,DemoActivity.class);
//                Bundle bundle=new Bundle();
//                bundle.putInt("logo",images[position]);
//                bundle.putString("name",names[position]);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });
    }

    class MyBroadcastReceiver extends BroadcastReceiver {
        public MyBroadcastReceiver() {
        }

        public static final String TAG = "MyBroadcastReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d(TAG, "huuuu");
            String school = intent.getStringExtra("school");
            String jianjie = intent.getStringExtra("jianjie");
            String username = intent.getStringExtra("username");
            Model model = new Model();
            model.setSchool(school);
            model.setJianjie(jianjie);
            model.setImage(images[0]);
            model.setName(username);
            model.setSeximage(seximages[0]);
            modelList.add(model);

            for (Model model1 :modelList){
                Log.d(TAG,model1.toString());
            }

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(myBroadcastReceiver);
    }
}


