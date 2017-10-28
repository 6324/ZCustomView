package com.example.z.zcustomview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.z.zcustomview.data.CustomView1Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author z
 * @date 2017/10/26 下午7:11
 */

public class CustomView1 extends View {

    Paint paint = new Paint();
    List<CustomView1Data> listData;

    private void initPaint() {
        paint.setColor(Color.BLACK);       //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        paint.setStrokeWidth(1f);         //设置画笔宽度为10px
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
    protected void onDraw(final Canvas canvas) {
        System.out.println("------->onDraw");
        //点
        paint.setStrokeWidth(3f);
        float[] floats = new float[]{20, 20, 30, 30, 40, 40, 70, 100};
        canvas.drawPoints(floats, paint);

        //线
        paint.setColor(Color.RED);
        canvas.drawLine(800, 0, 300, 90, paint);

        paint.setStrokeWidth(1f);         //设置画笔宽度为10px

        //矩形1
        paint.setColor(Color.parseColor("#569597"));
        canvas.drawRect(80, 80, 180, 130, paint);

        //矩形2
        paint.setColor(Color.parseColor("#43454a"));
        Rect rect = new Rect(100, 150, 400, 200);
        canvas.drawRect(rect, paint);

        //圆角矩形1
        RectF rectF = new RectF(100, 250, 400, 350);
        paint.setColor(Color.parseColor("#a54358"));
        canvas.drawRoundRect(rectF, 30, 30, paint);

        //圆角矩形2
        paint.setColor(Color.parseColor("#e9db39"));
        canvas.drawRoundRect(100, 400, 400, 530, 30, 30, paint);

        //圆角矩形3
        paint.setColor(Color.parseColor("#363532"));
        canvas.drawRect(100, 600, 400, 800, paint);

        //嵌在矩形里的椭圆
        paint.setColor(Color.parseColor("#d54b44"));
        canvas.drawRoundRect(100, 600, 400, 800, 300, 200, paint);

        //椭圆
        paint.setColor(Color.parseColor("#fcb1aa"));
        RectF rectF1 = new RectF(100, 820, 400, 900);
        canvas.drawOval(rectF1, paint);

        //圆
        paint.setColor(Color.parseColor("#c4473d"));
        canvas.drawCircle(200, 1000, 100, paint);

        //背景
        paint.setColor(Color.parseColor("#cccccc"));
        RectF rectF2 = new RectF(450, 100, 550, 200);
        canvas.drawRect(rectF2, paint);
        //圆弧
        paint.setColor(Color.parseColor("#119780"));
        canvas.drawArc(rectF2, 0, 350, true, paint);

        //背景
        paint.setColor(Color.parseColor("#cccccc"));
        RectF rectF3 = new RectF(450, 250, 550, 350);
        canvas.drawRect(rectF3, paint);
        //圆弧
        paint.setColor(Color.parseColor("#119780"));
        canvas.drawArc(rectF3, 60, 350, true, paint);


        //背景
        paint.setColor(Color.parseColor("#cccccc"));
        RectF rectF4 = new RectF(450, 400, 550, 500);
        canvas.drawRect(rectF4, paint);
        //圆弧
        paint.setColor(Color.parseColor("#119780"));
        canvas.drawArc(rectF4, 60, 120, false, paint);

        //背景
        paint.setColor(Color.parseColor("#cccccc"));
        RectF rectF5 = new RectF(450, 550, 550, 650);
        canvas.drawRect(rectF5, paint);
        //圆弧
        paint.setColor(Color.parseColor("#119780"));
        canvas.drawArc(rectF5, 0, 120, false, paint);

        //背景
        paint.setColor(Color.parseColor("#cccccc"));
        RectF rectF6 = new RectF(450, 700, 550, 800);
        canvas.drawRect(rectF6, paint);
        //圆弧
        paint.setColor(Color.parseColor("#119780"));
        canvas.drawArc(rectF6, 0, 120, true, paint);

        paint.setColor(Color.parseColor("#ffffff"));
        RectF rectF7 = new RectF(450, 820, 700, 1070);
        canvas.drawRect(rectF7, paint);
        //圆
        canvas.drawCircle(575, 945, 125, paint);

        initData();
        if (listData == null || listData.isEmpty()) {
            System.out.println("------->空");
            return;
        } else {

            //总价格
            float num = 0;
            for (int i = 0; i < listData.size(); i++) {
                num += listData.get(i).getNum();
            }
            //颜色
            String[] color = new String[]{"#5CF2E8", "#F0CEA0", "#FE9000", "#29335C", "#C1292E"};

            float jj = 0;//角度叠加
            for (int i = 0; i < listData.size(); i++) {
                float jd;
                jd = (listData.get(i).getNum() / num) * 360;
                System.out.println(listData.get(i).getName() + ":" + jd);
                paint.setColor(Color.parseColor(color[i]));


                canvas.drawArc(rectF7, jj, jd, true, paint);

                jj += jd;
            }
        }


    }

    public void initData() {
        CustomView1Data data = new CustomView1Data("电子", 5602);
        CustomView1Data data1 = new CustomView1Data("服饰", 4030);
        CustomView1Data data2 = new CustomView1Data("网络", 500);
        CustomView1Data data3 = new CustomView1Data("交通", 3400);
        CustomView1Data data4 = new CustomView1Data("图书", 200);

        listData = new ArrayList<>();
        listData.add(data);
        listData.add(data1);
        listData.add(data2);
        listData.add(data3);
        listData.add(data4);


    }
}
