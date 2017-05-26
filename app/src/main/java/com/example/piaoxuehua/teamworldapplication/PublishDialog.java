package com.example.piaoxuehua.teamworldapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.text.format.Time;

/**
 * Created by apple on 2017/5/23.
 */

public class PublishDialog extends Dialog {
    private Context context;
    private Handler handler;
    private TextView day, yearandmonth, xingqi;
    private RelativeLayout relMain, relZudui, relLuntan, relBisai, relShoucang, relMy, relMore;
    private ImageView imgClose;

    public PublishDialog(Context context) {
        this(context, R.style.main_publishdialog_style);
    }

    private PublishDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
        init();
    }

    private void init() {
        handler = new Handler();
        //填充视图
        setContentView(R.layout.third_fragment);
        relMain = (RelativeLayout) findViewById(R.id.more_rela_main);
        relZudui = (RelativeLayout) findViewById(R.id.more_rela_zudui);
        relLuntan = (RelativeLayout) findViewById(R.id.more_rela_luntan);
        relBisai = (RelativeLayout) findViewById(R.id.more_rela_bisai);
        relShoucang = (RelativeLayout) findViewById(R.id.more_rela_shoucang);
        relMy = (RelativeLayout) findViewById(R.id.more_rela_my);
        relMore = (RelativeLayout) findViewById(R.id.more_rela_more);
        imgClose = (ImageView) findViewById(R.id.more_img_close);


        imgClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                outputDialog();
            }
        });
        relMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                outputDialog();
            }
        });
    }

    /**
     * 取消对话框（带动画）
     */
    private void outputDialog() {
        //退出动画
        relMain.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_fade_out));
        imgClose.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_rotate_left));
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                dismiss();
            }
        }, 400);
        relZudui.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
        relZudui.setVisibility(View.INVISIBLE);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relLuntan.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
                relLuntan.setVisibility(View.INVISIBLE);
            }
        }, 50);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relBisai.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
                relBisai.setVisibility(View.INVISIBLE);
            }
        }, 100);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relShoucang.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
                relShoucang.setVisibility(View.INVISIBLE);
            }
        }, 150);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relMy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
                relMy.setVisibility(View.INVISIBLE);
            }
        }, 150);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relMore.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
                relMore.setVisibility(View.INVISIBLE);
            }
        }, 150);
    }


    private void inputDialog() {
        relZudui.setVisibility(View.INVISIBLE);
        relLuntan.setVisibility(View.INVISIBLE);
        relBisai.setVisibility(View.INVISIBLE);
        relShoucang.setVisibility(View.INVISIBLE);
        relMy.setVisibility(View.INVISIBLE);
        relMore.setVisibility(View.INVISIBLE);
        //背景动画
        relMain.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_fade_in));
        //菜单按钮动画
        imgClose.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_rotate_right));
        //选项动画
        relZudui.setVisibility(View.VISIBLE);
        relZudui.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relLuntan.setVisibility(View.VISIBLE);
                relLuntan.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
            }
        }, 100);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relBisai.setVisibility(View.VISIBLE);
                relBisai.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
            }
        }, 200);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relShoucang.setVisibility(View.VISIBLE);
                relShoucang.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
            }
        }, 300);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relMy.setVisibility(View.VISIBLE);
                relMy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
            }
        }, 300);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                relMore.setVisibility(View.VISIBLE);
                relMore.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
            }
        }, 300);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isShowing()) {
            outputDialog();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public void show() {
        super.show();
        inputDialog();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        day = (TextView) findViewById(R.id.more_text_day);
        yearandmonth = (TextView) findViewById(R.id.more_text_yearandmonth);
        xingqi = (TextView) findViewById(R.id.more_text_xingqi);
        Time time = new Time("GTM+8");
        time.setToNow();
        day.setText(time.monthDay + "");
        xingqi.setText("星期" + timeCast(time.weekDay));
        yearandmonth.setText(time.year + "-" +addZero(time.month));
//        yearandmonth.setText(date.getYear()+"/"+date.getMonth());
//        xingqi.setText("星期一");
    }

    public PublishDialog setZuBtnClickListener(android.view.View.OnClickListener clickListener) {
        relZudui.setOnClickListener(clickListener);
        return this;
    }

    public PublishDialog setLunBtnClickListener(android.view.View.OnClickListener clickListener) {
        relLuntan.setOnClickListener(clickListener);
        return this;
    }

    public PublishDialog setBiBtnClickListener(android.view.View.OnClickListener clickListener) {
        relBisai.setOnClickListener(clickListener);
        return this;
    }

    public PublishDialog setShouBtnClickListener(android.view.View.OnClickListener clickListener) {
        relShoucang.setOnClickListener(clickListener);
        return this;
    }

    public PublishDialog setMyBtnClickListener(android.view.View.OnClickListener clickListener) {
        relMy.setOnClickListener(clickListener);
        return this;
    }

    public PublishDialog setMoreBtnClickListener(android.view.View.OnClickListener clickListener) {
        relMore.setOnClickListener(clickListener);
        return this;
    }

    public static String timeCast(int day){
        String result = "一";
        switch (day){
            case 1:
                result = "一";
                break;
            case 2:
                result = "二";
                break;
            case 3:
                result = "三";
                break;
            case 4:
                result = "四";
                break;
            case 5:
                result = "五";
                break;
            case 6:
                result = "六";
                break;
            case 7:
                result = "日";
                break;
        }
        return result;
    }
    public static String addZero(int day){
        String result = "";
        if (day<10){
            result = "0"+day;
        }
        return result;
    }
}
