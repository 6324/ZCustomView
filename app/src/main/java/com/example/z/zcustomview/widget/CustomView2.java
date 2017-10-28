package com.example.z.zcustomview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * canvans画布操作
 *
 * @author z
 * @date 2017/10/28 下午1:30
 */

public class CustomView2 extends View {
    private Paint paint = new Paint();
    private int mWidth, mHeght;

    public CustomView2(Context context) {
        super(context);
        paint.setStrokeWidth(50f);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeght = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        位移
        paint.setColor(Color.parseColor("#000000"));
        canvas.translate(100, 100);
        canvas.drawCircle(0, 0, 100, paint);


        //位移是叠加的
        paint.setColor(Color.parseColor("#99339966"));
        canvas.translate(200, 0);
        canvas.drawCircle(0, 0, 100, paint);

        //放大
        paint.setColor(Color.parseColor("#9958355E"));
        canvas.translate(300, 0);
        canvas.scale(2, 2);
        canvas.drawCircle(0, 0, 100, paint);


        //缩小
        paint.setColor(Color.parseColor("#99FF3B1D"));
        canvas.translate(150, 0);
        canvas.scale(0.5f, 0.5f);
        canvas.drawCircle(0, 0, 100, paint);

        //恢复初始坐标
        canvas.translate(-900, -100);

        //旋转
        RectF rectF = new RectF(0, 200, 100, 300);
        canvas.scale(1, 1);
        canvas.drawRect(rectF, paint);

        //旋转
        RectF rectF1 = new RectF(200, 200, 300, 300);
        canvas.rotate(45, 250, 250);
        canvas.drawRect(rectF1, paint);

        //旋转可叠加
        RectF rectF2 = new RectF(400, 300, 500, 400);
        canvas.rotate(10, 450, 350);
        canvas.drawRect(rectF2, paint);

        canvas.rotate(-55);
        paint.setStrokeWidth(10f);
        paint.setStyle(Paint.Style.STROKE);
        canvas.translate(mWidth / 2, mHeght / 2);
        canvas.drawCircle(0, 0, 300, paint);
        canvas.drawCircle(0, 0, 340, paint);

        for (int i = 0; i <36 ; i++) {
           canvas.drawLine(0,300,0, 340,paint);
           canvas.rotate(10);


        }

    }
}
