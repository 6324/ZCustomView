package com.example.z.zcustomview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 *    贝塞尔曲线1
 *
 * @author z
 * @date 2017/10/30 下午5:29
 */

public class BezierView1 extends View {

    private int centerX, centerY;
    private Paint paint = new Paint();

    private PointF start, end, control;

    public void initView() {
        paint.setStrokeWidth(20f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);

        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control = new PointF(0, 0);
    }

    public BezierView1(Context context) {
        super(context);
        initView();

    }

    public BezierView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BezierView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        start.x = centerX - 400;
        start.y = centerY;
        end.x = centerX + 400;
        end.y = centerY;

        control.x = centerX;
        control.y = centerY;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPoint(start.x, start.y, paint);
        canvas.drawPoint(end.x, end.y, paint);
        canvas.drawPoint(control.x, control.y, paint);

        paint.setStrokeWidth(5f);
        canvas.drawLine(start.x, start.y, control.x, control.y, paint);
        canvas.drawLine(end.x, end.y, control.x, control.y, paint);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(15f);

        Path path = new Path();
        path.moveTo(start.x, start.y);

        path.quadTo(control.x, control.y, end.x, end.y);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        control.x=event.getX();
        control.y=event.getY();
        invalidate();
        return true;
    }
}
