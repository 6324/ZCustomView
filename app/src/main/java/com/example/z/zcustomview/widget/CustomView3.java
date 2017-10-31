package com.example.z.zcustomview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.z.zcustomview.R;

/**
 * @author z
 * @date 2017/10/29 下午12:43
 */

public class CustomView3 extends View {
    int mWidth, mHight;
    Picture picture = new Picture();
    Paint paint = new Paint();
    Bitmap bitmap;

    public void initPicture() {
        Canvas canvas = picture.beginRecording(0, 0);

        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5f);
        canvas.drawCircle(mWidth / 2, mHight / 2, 300, paint);
        picture.endRecording();
    }

    public void initBitmap() {
        bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.whss);
    }


    public CustomView3(Context context) {
        super(context);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPicture();
//        调用picture绘制方法下面两个都可以
//        picture.draw(canvas);//会影响canvas状态，一般不用

        canvas.drawPicture(picture);

        initBitmap();

        canvas.drawBitmap(bitmap, new Matrix(), paint);

        paint.setTextSize(50);
        paint.setColor(Color.WHITE);

        canvas.drawText("你个狗卵子,你就是个弟弟",100,600,paint);
    }
}
