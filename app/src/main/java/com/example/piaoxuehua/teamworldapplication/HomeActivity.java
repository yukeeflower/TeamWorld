package com.example.piaoxuehua.teamworldapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView topBar;
    private TextView tabHome;
    private ImageView tabMore;
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

    PublishDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        bindView();

        tabMore = (ImageView) this.findViewById(R.id.txt_more);
        tabMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pDialog == null) {
                    pDialog = new PublishDialog(HomeActivity.this);
                    pDialog.setZuBtnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent =new Intent(HomeActivity.this,JoinActivity.class);
                            startActivity(intent);
                            pDialog.hide();
                        }
                    });
                    pDialog.setLunBtnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent =new Intent(HomeActivity.this,ShequActivity.class);
                            startActivity(intent);
                            pDialog.hide();
                        }
                    });
                    pDialog.setBiBtnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Toast.makeText(HomeActivity.this, "比赛按钮被点击啦", Toast.LENGTH_LONG).show();
                        }
                    });
                    pDialog.setMoreBtnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Toast.makeText(HomeActivity.this, "更多按钮被点击啦", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                pDialog.show();
            }
        });


    }
    public HomeActivity(){}

    private void bindView() {
        topBar = (TextView) this.findViewById(R.id.txt_top);
        tabHome = (TextView) this.findViewById(R.id.txt_home);
        tabMy = (TextView) this.findViewById(R.id.txt_my);
        tabVs = (TextView) this.findViewById(R.id.txt_vs);
        tabXuanshang = (TextView) this.findViewById(R.id.txt_xuanshang);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabHome.setOnClickListener(this);
        tabMy.setOnClickListener(this);
        tabVs.setOnClickListener(this);
        tabXuanshang.setOnClickListener(this);
        onClick(tabHome);
    }

    public void selected() {
        tabHome.setSelected(false);
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
//        if (f3 != null) {
//            transaction.hide(f3);
//        }
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
//            case R.id.txt_more:
//                selected();
//                tabMore.setSelected(true);
//
//                break;
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


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return false;
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
