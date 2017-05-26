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
    String context;
    ListView listView;

    public SecondFragment(String context) {
        this.context = context;
    }

    public SecondFragment() {
    }

    int[] userlogos = new int[]{
            R.drawable.home_cell_logo_user1, R.drawable.home_cell_logo_user2, R.drawable.home_cell_logo_user3,
            R.drawable.home_cell_logo_user4
    };
    String[] usernames = new String[]{
            "三只小熊", "两只老鼠", "你好，笨笨",
            "下个路口相遇"
    };
    String[] moneys = new String[]{"10","20","1000","21"};
    String[] questions= new String[]{
            "SATA 的信号线为什么没有双绞？", "你的偶像在48G队/团/河里有怎样的人设定位？你希望她有怎样的人设定位？",
            "所谓「正宗西关音」同广州、香港目前流行的粤语语音语调上分别有什么区别？", "身体障碍、流浪者等弱势群体可以通过哪些途径寻求救助？"
    };
    String[] answers = new String[]{
            "双绞线是因为那是差分信号，没什么屏蔽不屏蔽。sata其实也是差分信号，但是因为频率太高，要保证一定的阻抗，所以要用类似同轴线的方式传输,并且双绞线的抗干扰能力不如屏蔽线，特别是在机箱内部，这种干扰异常多的地方。\n",
            "每日吹鹅(1/1)\n" +
                    "全团唯一最拽人设，笑声只服她。\n" +
                    "Nice body担当\n" +
                    "傻白甜担当\n" +
                    "颜值担当\n" +
                    "还有重友情重义气。\n" +
                    "性感与可爱反差萌结合体。\n" +
                    "\n" +
                    "期望\n" +
                    "我希望她能多唱点歌，毕竟是真歌姬(⁎⁍̴̛ᴗ⁍̴̛⁎)",
            "高降調合併了。以前姓張個張、豆漿個漿，前者高降後者陰平。",
            "救助站，托养中心这些啊，但是我总觉得政府应该想点长远的办法，对于有劳动能力的残障人士以及流浪者提供工作的岗位，保障他们劳动的权益，对于没有劳动能力的，给予他们很好很健全的保障。弱势不弱势，其实在很大程度上取决于整个社会的做法与态度，能不能通过某些措施消除这种弱势的标签，因为从某种意义上说，把共同生活在这个社会里的某些人定为弱势群体，本来就是一种不公平，人类与社会的发展中必然要经历承受诸如残疾这样的苦痛，作为政府首先就要对他们进行保障，提供各种便利与机会，使他们平等参与社会，生活得到保障，这是最基本的，国以养民为本\n" +
                    "\n" +
                    "作者：梦想成真\n" +
                    "链接：https://www.zhihu.com/question/57415059/answer/153132334\n" +
                    "来源：知乎\n" +
                    "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。"

    };
    String[] agrees = new String[]{"12","222","22211","2121"};
    String[] pingluns = new String[]{"111","222","2221","21"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i<userlogos.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("userlogo", userlogos[i]);
            map.put("username", usernames[i]);
            map.put("money", moneys[i]);
            map.put("question", questions[i]);
            map.put("answer", answers[i]);
            map.put("agree", agrees[i]);
            map.put("pinglun", pingluns[i]);
            list.add(map);
        }
        listView = (ListView) getActivity().findViewById(R.id.list_xuanshang);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this.getActivity(), list, R.layout.layout_xuanshang_cell,
                new String[]{"userlogo", "username", "money", "question", "answer","agree","pinglun"},
                new int[]{R.id.xuanshang_cell_userlogo, R.id.xuanshang_cell_username, R.id.xuanshang_cell_money,
                        R.id.xuanshang_cell_question, R.id.xuanshang_cell_answer,R.id.xuanshang_cell_agree,R.id.xuanshang_cell_pinglun});
        simpleAdapter.notifyDataSetChanged();
        listView.setAdapter(simpleAdapter);
    }
}





