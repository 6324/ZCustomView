package com.example.z.zcustomview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author z
 * @date 2017/10/26 下午7:11
 */

public class CustomView1 extends View {

    Paint paint = new Paint();

    private void initPaint() {
        paint.setColor(Color.BLACK);       //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        paint.setStrokeWidth(5f);         //设置画笔宽度为10px
    }

    public CustomView1(Context context) {
        super(context);
        initPaint();

    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        System.out.println("------->onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        System.out.println("-------->onSizeChanged [" + w + "," + h + "," + oldh + "," + oldw + "]");
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        System.out.println("-------->onLayout");
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("------->onDraw");
        canvas.drawLine(0, 300, 350, 20, paint);
        paint.setColor(Color.RED);
        canvas.drawRoundRect(100, 100, 800, 400, 200,200, paint);

    }
}
