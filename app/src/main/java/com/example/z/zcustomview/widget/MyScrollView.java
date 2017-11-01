package com.example.z.zcustomview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

/**
 * @author z
 * @date 2017/11/1 下午1:21
 */

public class MyScrollView extends ScrollView {
    private static final String TAG = "MyScrollView";
    private View view;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        Log.d(TAG, "onScrollChanged: [" + l + " " + t + " " + oldl + " " + oldt + "]");
        if (this.view != null) {
                view.scrollTo(l, t);
        }
    }

    /**
     * 联动滚动
     *
     * @param view
     */
    public void setScrollView(View view) {
        this.view = view;

    }

}
