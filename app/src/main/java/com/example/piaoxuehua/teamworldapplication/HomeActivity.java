package com.example.piaoxuehua.teamworldapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView topBar;
    private TextView tabHome;
    private TextView tabMore;
    private TextView tabMy;
    private TextView tabVs;
    private TextView tabXuanshang;

    private FrameLayout ly_content;

    private FirstFragment f1;
    private ThirdFragment f3;
    private FourthFragment f4;
    private SecondFragment f2;
    private FifthFragment f5;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        bindView();


    }
    public HomeActivity(){}

    private void bindView() {
        topBar = (TextView) this.findViewById(R.id.txt_top);
        tabHome = (TextView) this.findViewById(R.id.txt_home);
        tabMore = (TextView) this.findViewById(R.id.txt_more);
        tabMy = (TextView) this.findViewById(R.id.txt_my);
        tabVs = (TextView) this.findViewById(R.id.txt_vs);
        tabXuanshang = (TextView) this.findViewById(R.id.txt_xuanshang);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabHome.setOnClickListener(this);
        tabMore.setOnClickListener(this);
        tabMy.setOnClickListener(this);
        tabVs.setOnClickListener(this);
        tabXuanshang.setOnClickListener(this);
        onClick(tabHome);
    }

    public void selected() {
        tabHome.setSelected(false);
        tabMore.setSelected(false);
        tabMy.setSelected(false);
        tabVs.setSelected(false);
        tabXuanshang.setSelected(false);
    }

    public void hideAllFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            transaction.hide(f1);
        }
        if (f2 != null) {
            transaction.hide(f2);
        }
        if (f3 != null) {
            transaction.hide(f3);
        }
        if (f4 != null) {
            transaction.hide(f4);
        }
        if (f5 != null) {
            transaction.hide(f5);
        }
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()) {
            case R.id.txt_home:
                selected();
                tabHome.setSelected(true);
                if (f1 == null) {
                    f1 = new FirstFragment("第一个Fragment");
                    transaction.add(R.id.fragment_container, f1);
                } else {
                    transaction.show(f1);
                }
                break;

            case R.id.txt_xuanshang:
                selected();
                tabXuanshang.setSelected(true);
                if (f2 == null) {
                    f2 = new SecondFragment("第二个Fragment");
                    transaction.add(R.id.fragment_container, f2);
                } else {
                    transaction.show(f2);
                }
                break;

            case R.id.txt_more:
                selected();
                tabMore.setSelected(true);
                if (f3 == null) {
                    f3 = new ThirdFragment("第三个Fragment");
                    transaction.add(R.id.fragment_container, f3);
                } else {
                    transaction.show(f3);
                }
                break;

            case R.id.txt_vs:
                selected();
                tabVs.setSelected(true);
                if (f4 == null) {
                    f4 = new FourthFragment("第四个Fragment");
                    transaction.add(R.id.fragment_container, f4);
                } else {
                    transaction.show(f4);
                }
                break;
            case R.id.txt_my:
                selected();
                tabMy.setSelected(true);
                if (f5 == null) {
                    f5 = new FifthFragment("第五个Fragment");
                    transaction.add(R.id.fragment_container, f5);
                } else {
                    transaction.show(f5);
                }
                break;
            default:
                break;
        }

        transaction.commit();
    }



}
