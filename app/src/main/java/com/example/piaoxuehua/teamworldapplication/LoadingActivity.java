package com.example.piaoxuehua.teamworldapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoadingActivity extends AppCompatActivity {
//    private BitmapShaders bitmapShaders = null;
    EditText editText;
    EditText editText_key;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        bitmapShaders = new BitmapShaders(this);
//        setContentView(bitmapShaders);
        setContentView(R.layout.activity_loading);
        editText=(EditText)findViewById(R.id.edit_username);
        editText_key=(EditText)findViewById(R.id.edit_key);

        button=(Button)findViewById(R.id.button) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String username=editText.getText().toString();
                 String key=editText_key.getText().toString();
                if ("pxh".equals(username) && "123".equals(key)) {
                    Intent intent = new Intent(LoadingActivity.this, DirectActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoadingActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
