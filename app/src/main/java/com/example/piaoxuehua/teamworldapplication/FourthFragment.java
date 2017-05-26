package com.example.piaoxuehua.teamworldapplication;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by piaoxuehua on 2017/5/18.
 */

@SuppressLint("ValidFragment")
public class FourthFragment extends Fragment {
    String context;
    ListView listView;
    RelativeLayout relativeLayout;

    public FourthFragment() {
    }

    public FourthFragment(String context) {
        this.context = context;
    }


    String[] titles = new String[]{
            "2017中国手机创新周暨第五届中国手机设计与应用创新大赛", "“我与数据库的故事”主题征文比赛",
            "2017年第三届全国移动互联创新大赛【最新官方线上宣讲会信息，见底部】", "第五届“英特尔杯”全国并行应用挑战赛（PAC）"
    };
    String[] times = new String[]{
            "2017年10月15日", "6月2日24:00", "2017年8月", "2017年7月31日"
    };
    int[] images = new int[]{
            R.drawable.one, R.drawable.two,
            R.drawable.three, R.drawable.four
    };

    String[] jieshaos = new String[]{
            "  5月17日，值第49届世界电信和信息社会日之际，2017中国手机创新周暨第五届中国手机设计与应用创新大赛(简称“创新周暨手机大赛”)正式启动，中国手机设计与应用创新最高奖“天鹅奖”角逐正式拉开帷幕。同期，创新周暨手机大赛新版官方网站(www.cmcontest.com)正式上线。\n" +
                    "        第五届中国手机设计与应用创新大赛作为2017中国手机创新周重要载体活动，按照“免费报名、鼓励创新、公平公正、专业权威”的基本原则，面向与手机及应用相关的机构和个人，公开征集参赛产品方案作品。",
            "大赛背景：中国社科院社会科学文献出版社“社科数托邦”微信公众号自2016年11月正式上线运营以来，有幸受到各界朋友的认可与赞誉，同时也得到了广大“皮粉儿”们鼓励与支持，这份“深情厚爱”中国社科院社会科学文献出版社一直谨记在心，为了不负此情，也为了更好地服务用户，中国社科院社会科学文献出版社想多多创造机会，聆听每一位“皮粉儿”的需求与建议",
            "全国移动互联创新大赛是由国家工业和信息化部、中国科学技术协会指导，中国通信学会、全国移动互联网产业孵化中心联合主办的国家级赛事。\n" +
                    "2015年11月成功举办首届大赛，并取得丰硕成果： IBM中国研究院为大赛学生提供了实习就业机会，IBM SmartCamp为大赛中的“趣舍”、“方舟万宝可穿戴设备系统”、“幼儿云”三个项目提供一年2.4万美元的免费云服务资源；麟玺创投、前海凤凰谷都宣布投资“摄汇主义O2O摄影项目”，并宣布对“那位app”的投资意向；来自北京联合大学的“不离”APP获得Pre-angel 特别奖及现场投资。“果仁宝”项目获得高榕资本的投资、“趣舍”获得中科乐创的投资、“新能源汽车超级充电系统”获得汉能集团的跟进及前海凤凰谷的投资；“英卓墨武士智能车载”获得汉能集团的跟进；此外，“天天农庄”、“我是翻译”项目宣布入驻创业公社，研鸿车联网项目、多点触控智能显示屏项目宣布入驻房山良乡高教园区。\n" +
                    "全国移动互联创新大赛的宗旨是提高全民创新、创业的意识和能力，以“互联网+”思维促进创新产品的市场转化；特点是依托工业和信息化部的产业优势，前期搭建校企合作、互相交流的平台，后期更加注重大赛成果的落地和转化。",
            " \"英特尔杯\"全国并行应用挑战赛（简称PAC）旨在通过培养选拨学生“理论实践相结合”的能力，寻找最佳应用，发现顶尖优化人才！以赛促学，以赛促教。自2013年起，PAC已成功举办四届，“高性能计算产业、学校、社会企业三方合作的生态系统”渐趋成型。\n" +
                    "PAC2017正式起航，本届主题为“智引天下，算出精彩”首增“人工智能”组别，只等你来战！本届所有获奖证书更获得教育部计算机类专业教学指导委员会的认证，欢迎积极报名参赛。本届比赛采用微信报名，即日起关注微信公众号“PACChina-HPC”进行报名即可参赛。"

    };
    String[] urls = new String[]{
           "http://www.52jingsai.com/article-3623-1.html","http://www.52jingsai.com/article-3624-1.html" ,
            "http://www.52jingsai.com/article-3612-1.html","http://www.52jingsai.com/article-3627-1.html"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fourth_fragment, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0;i<titles.length;i++ ) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", titles[i]);
            map.put("time", "截止时间："+times[i]);
            map.put("image", images[i]);
            map.put("jieshao", jieshaos[i]);
            list.add(map);
        }
        listView = (ListView) getActivity().findViewById(R.id.PK_listview);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this.getActivity(), list, R.layout.layout_pk_cell,
                new String[]{"title", "time", "image", "jieshao"},
                new int[]{R.id.pk_cell_title, R.id.pk_cell_time, R.id.pk_cell_image,
                        R.id.pk_cell_jieshao});
        simpleAdapter.notifyDataSetChanged();
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),DetailInfoActivity.class);
                intent.putExtra("url",urls[position]);
                startActivity(intent);
                startActivityForResult(intent,1);
                getActivity().overridePendingTransition(R.anim.right_in,R.anim.left_oout);
            }
        });
//        relativeLayout = (RelativeLayout) getActivity().findViewById(R.id.pk_cell_all);
//        relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "点击了第" + v + "个比赛", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}

