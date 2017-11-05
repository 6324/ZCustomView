package com.example.z.zcustomview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * @author z
 * @date 2017/11/1 下午1:21
 */

public class MyHorizontalScrollView extends HorizontalScrollView {
    private static final String TAG = "MyScrollView";
    private View view;
    private OnHorizontalScrollListener listener;

    public MyHorizontalScrollView(Context context) {
        super(context);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnHorizontalScrollListener(OnHorizontalScrollListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (this.view != null) {

            view.scrollTo(l, t);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    /**
     * 联动滚动
     *
     * @param view
     */
    public void setScrollView(View view) {
        this.view = view;

    }

    @Override
    public void setFillViewport(boolean fillViewport) {
        super.setFillViewport(true);
    }

    public interface OnHorizontalScrollListener {
        void onHorizontalScrolled(MyHorizontalScrollView view, int l, int t, int oldl, int oldt);
    }
}
