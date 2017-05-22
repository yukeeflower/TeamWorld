package com.example.piaoxuehua.teamworldapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by piaoxuehua on 2017/4/5.
 */

public class BitmapShaders extends View {
    private BitmapShader bitmapShader = null;
    private Bitmap bitmap = null;
    private ShapeDrawable shapeDrawable = null;
    private int BitmapWidth = 0;
    private int BitmapHeight = 0;

    public BitmapShaders(Context context) {
        super(context);
        //得到图像
        bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.home_user)).getBitmap();
        BitmapWidth = bitmap.getWidth();
        BitmapHeight = bitmap.getHeight();
        //构造渲染器BitmapShader
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.REPEAT);
    }
    public BitmapShaders(Context context,AttributeSet attrs){
        super(context,attrs);
        bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.home_user)).getBitmap();
        BitmapWidth = bitmap.getWidth();
        BitmapHeight = bitmap.getHeight();
        //构造渲染器BitmapShader
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.REPEAT);

    }
    public BitmapShaders(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.home_user)).getBitmap();
        BitmapWidth = bitmap.getWidth();
        BitmapHeight = bitmap.getHeight();
        //构造渲染器BitmapShader
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.REPEAT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将图片裁剪为椭圆形
        //构建ShapeDrawable对象并定义形状为椭圆
        shapeDrawable = new ShapeDrawable(new OvalShape());
        //得到画笔并设置渲染器
        Paint paint = shapeDrawable.getPaint();
        paint.setShader(bitmapShader);
        //设置显示区域
        shapeDrawable.setBounds(50, 50, BitmapWidth + 50, BitmapHeight + 50);
        //绘制shapeDrawable
        shapeDrawable.draw(canvas);
    }
}
