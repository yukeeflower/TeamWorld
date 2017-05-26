package com.example.piaoxuehua.teamworldapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DemoActivity extends AppCompatActivity {
    private ListView listViewBasic =null;
    private String[] listViewData = new String[]{
            "计算机科学学院","公共管理学院","教育学院",
            "马克思主义学院","数学与统计学院" ,"信息管理学院",
            "文学与新闻传播学院",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
//        final ActionBar actionBar=getSupportActionBar();
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        actionBar.setCustomView(R.layout.actionbar);
        initView();




    }
    private void initView(){
        listViewBasic = (ListView)super.findViewById(R.id.demo_body);
        //设置listview中的内容
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        int id=bundle.getInt("logo");
        String name=bundle.getString("name");
        TextView textView=(TextView)findViewById(R.id.school_name);
        textView.setText(name);
        ImageView imageView=(ImageView)findViewById(R.id.school_logo);
        imageView.setImageResource(id);
        //if (intent.getStringExtra("position")) {
            listViewBasic.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listViewData));
        listViewBasic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(DemoActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        //}
    }
}





