package com.example.piaoxuehua.teamworldapplication;

import android.app.LauncherActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DirectActivity extends AppCompatActivity {
    private ListView listView;
    private ImageView imageView;
    private TextView textView;
    int [] images= new int[]{
            R.drawable.direct_cell_logo,R.drawable.direct_cell_logo_qinghua,R.drawable.direct_cell_logo_beijing,
            R.drawable.direct_cell_logo_wuda ,R.drawable.direct_cell_logo_huake ,R.drawable.direct_cell_logo_dizhi,
            R.drawable.direct_cell_logo_zhongnan,R.drawable.direct_cell_logo_caida,R.drawable.direct_cell_logo_xiada
    };
    String[]names=new String[]{
            "中南民族大学","清华大学","北京大学",
            "武汉大学","华中科技大学","中国地质大学",
            "中南大学","中南财经政法大学","厦门大学"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct);
        List<Map<String,Object>>list=new ArrayList<>();
        for (int i=0;i<9;i++){
            Map<String,Object>map=new HashMap<>();
            map.put("logo",images[i]);
            map.put("name",names[i]);
            list.add(map);
            }

        listView=(ListView)findViewById(R.id.direct_listview);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.layout_direct_cell,new String[]{"logo","name"},
                new int[]{R.id.direct_cell_logo,R.id.direct_cell_schoolname});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(DirectActivity.this,DemoActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("logo",images[position]);
                bundle.putString("name",names[position]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}


