package com.example.piaoxuehua.teamworldapplication;

import android.app.ProgressDialog;
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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class LoadingActivity extends AppCompatActivity {
    //    private BitmapShaders bitmapShaders = null;
    EditText editText;
    EditText editText_key;
    Button button;
    ProgressDialog waitingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        editText = (EditText) findViewById(R.id.edit_username);
        editText_key = (EditText) findViewById(R.id.edit_key);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWaitingDialog();
                String username = editText.getText().toString();
                String key = editText_key.getText().toString();

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("username", username);
                    jsonObject.put("password", key);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String loginurl = "http://182.254.152.99:8080/MyChat1/user/login";
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                JsonRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, loginurl, jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String code = "";
                        Log.d("Loading", "response -> " + response.toString());
                        try {
                            code = response.getString("code").toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (code.equals("S01")) {
                            Intent intent = new Intent(LoadingActivity.this,DirectActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoadingActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                            waitingDialog.dismiss();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LoadingActivity", error.getMessage(), error);
                        Toast.makeText(LoadingActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        waitingDialog.dismiss();
                    }
                });
                requestQueue.add(jsonRequest);
            }
        });
    }

    public void showWaitingDialog() {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件完成后，主动调用函数关闭该Dialog
     */
        waitingDialog = new ProgressDialog(LoadingActivity.this);
//        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("正在登陆...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }
}
