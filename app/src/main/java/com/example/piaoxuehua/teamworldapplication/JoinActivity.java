package com.example.piaoxuehua.teamworldapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.piaoxuehua.teamworldapplication.R.id.button;

public class JoinActivity extends AppCompatActivity {
    EditText editText_school;
    EditText editText_jianjie;
    EditText editText_username;
    Button   button_tijiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        editText_school=(EditText)findViewById(R.id.join_schoolname);
        editText_jianjie=(EditText)findViewById(R.id.join_neirong);
        editText_username=(EditText)findViewById(R.id.join_username);
        button_tijiao=(Button)findViewById(R.id.join_button_tijiao);
        button_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("BROADCAST_ACTION");
                intent.putExtra("school",editText_school.getText().toString());
                intent.putExtra("jianjie",editText_jianjie.getText().toString());
                intent.putExtra("username",editText_username.getText().toString());
                sendBroadcast(intent);
                Intent intent1 = new Intent(JoinActivity.this,HomeActivity.class);
                startActivity(intent1);
            }
        });


//        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        actionBar.setCustomView(R.layout.actionbar);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(JoinActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        return false;
    }


}

