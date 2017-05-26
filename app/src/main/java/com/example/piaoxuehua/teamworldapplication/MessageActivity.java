package com.example.piaoxuehua.teamworldapplication;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class MessageActivity extends AppCompatActivity {
    ImageButton imageButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        imageButton = (ImageButton)findViewById(R.id.message_back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }

    public void back(){
        Intent intent = new Intent(MessageActivity.this,HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back();
        }
        return false;
    }
}
