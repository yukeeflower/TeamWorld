package com.example.piaoxuehua.teamworldapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShequActivity extends AppCompatActivity {
    ListView listView;
    int[] userimages = new int[]{
            R.drawable.home_cell_logo_user1, R.drawable.home_cell_logo_user2, R.drawable.home_cell_logo_user3,
            R.drawable.home_cell_logo_user4
    };
    String[] usernames = new String[]{
            "三只小熊", "两只老鼠", "你好，笨笨",
            "下个路口相遇"
    };
    String[] schoolnames = new String[]{
            "中南民族大学", "海军工程大学", "武汉大学", "中国地质大学"
    };
    String[] contents = new String[]{
                    "首先，这三个框架是做什么的呢？现在流行的Java Web开发基本上是三层架构，一是与用户打交道的展示层（也就是Struts主要发挥其作用的地方，接收用户请求和返回请求结果），二是接收请求并处理返回数据的业务逻辑层，三是读取数据库中保存数据的数据访问层\n" +
                    "\n",

                    "H5这东西，在广告行业一直都有，原来叫做landing page或者着陆页。后来移动端的landing page越来越多，也不知怎么的就被挂上了“H5”的名号。\n" +
                    "\n" +
                    "短时间来看，H5确实是目前广告宣传设计行业发展迅速的一块。广告行业向来是追着目标人群走的，当广告主的目标人群高度依赖手机，借着移动社交媒体在手机上推广各种设计精良、交互新颖的H5广告，也在正常不过了。\n" +
                    "\n" ,


                    "我来推荐一款协作工具，因为自己带过创业团队，后来也在创业公司实习过，用过很多工具。所以对协作工具比较熟悉，总的来说，我直接推荐Teambition。\n" +
                    "\n" +
                    "Teambition是朋友介绍给我的，我感觉Teambition很适合一个程序员出身的创业者后者产品经理，至于适合不适合其他的行业的，大家可以自行尝试以下。Teambition的设计界面简洁，满足了我的审美需求。\n" +
                    "\n" ,

            "As far as I'm concerned, 阅读好项目源代码，有几个前提条件要做好：\n" +
                    "\n" +
                    "1）. 知道该项目的用途，是干什么的\n" +
                    "\n" +
                    "2）. 了解该项目的架构，包含什么模块，各模块是干什么的\n" +
                    "\n" +
                    "3）. 英文水平最低限度：阅读无障碍（因为在阅读源码的时候，你需要看英文注释来辅助理解）\n" +
                    "\n" +
                    "如果以上三个条件做好了，阅读源码事半功倍。\n"


    };
    String[] shoucangs = new String[]{
            "100", "220", "203", "214"
    }; String[] zans = new String[]{
            "80", "222", "143", "40"
    }; String[] pingluns = new String[]{
            "29", "82", "20", "55"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shequ);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0;i<userimages.length;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("userimage", userimages[i]);
            map.put("username",usernames[i]);
            map.put("schoolname", schoolnames[i]);
            map.put("content",contents [i]);
            map.put("shoucang", shoucangs[i]);
            map.put("zan", zans[i]);
            map.put("pinglun",pingluns[i]);
            list.add(map);
        }
//        mTextView = (TextView) view.findViewById(R.id.txt_content);
        //mTextView = (TextView)getActivity().findViewById(R.id.txt_content);
//        mTextView.setText(context);
        listView = (ListView)findViewById(R.id.shequ_listview);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.layout_shequ_cell, new String[]{"userimage", "username",
                "schoolname", "content", "shoucang","zan","pinglun"},
                new int[]{R.id.shequ_userimage, R.id.shequ_username, R.id.shequ_schoolname, R.id.shequ_project_content,
                        R.id.shoucang_num,R.id.zan_num,R.id.pinglun_num});
        simpleAdapter.notifyDataSetChanged();
        listView.setAdapter(simpleAdapter);
    }
}
