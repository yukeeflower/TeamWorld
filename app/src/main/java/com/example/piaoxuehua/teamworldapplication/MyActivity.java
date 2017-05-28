package com.example.piaoxuehua.teamworldapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class MyActivity extends AppCompatActivity {
    private ImageButton backbutton;
    private ImageButton setbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        setbutton =(ImageButton)findViewById(R.id.my_icon_set);
        setbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyActivity.this,My_shezhiActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        backbutton =(ImageButton)findViewById(R.id.my_back_button);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }
    public void back(){
        Intent intent = new Intent(MyActivity.this,HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in,R.anim.left_oout);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
           back();
        }
        return false;
    }
}
