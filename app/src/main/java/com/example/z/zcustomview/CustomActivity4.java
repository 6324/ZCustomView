package com.example.z.zcustomview;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author z
 */
public class CustomActivity4 extends AppCompatActivity {

    @BindView(R.id.btncus4_1)
    Button btncus41;
    @BindView(R.id.btncus4_2)
    Button btncus42;

    int FLEX_FLAG = 0;
    @BindView(R.id.cd_cus4)
    CardView cdCus4;
    @BindView(R.id.ll_cus4)
    LinearLayout llCus4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom4);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btncus4_1, R.id.btncus4_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btncus4_1:

                if (FLEX_FLAG == 0) {
                    performAnimate(llCus4, llCus4.getMinimumHeight(), 200);

                    FLEX_FLAG = 1;
                } else {
                    performAnimate(llCus4, 200, llCus4.getMinimumHeight());

                    FLEX_FLAG = 0;
                }
                break;
            case R.id.btncus4_2:

                if (FLEX_FLAG == 0) {
                    performAnimate(cdCus4, cdCus4.getMinimumHeight(), 200);
                    FLEX_FLAG = 1;

                } else {
                    performAnimate(cdCus4, 200, cdCus4.getMinimumHeight());
                    FLEX_FLAG = 0;
                }


                break;

            default:
                break;
        }
    }

    private void performAnimate(final View target, final int start, final int end) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            //持有一个IntEvaluator对象，方便下面估值的时候使用
            private IntEvaluator mEvaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                //获得当前动画的进度值，整型，1-100之间
                int currentValue = (Integer) animator.getAnimatedValue();

                //计算当前进度占整个动画过程的比例，浮点型，0-1之间
                float fraction = currentValue / 100f;

                //这里我偷懒了，不过有现成的干吗不用呢
                //直接调用整型估值器通过比例计算出宽度，然后再设给Button
                target.getLayoutParams().height = mEvaluator.evaluate(fraction, start, end);
                target.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setTarget(target);
        valueAnimator.setDuration(200).start();
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        System.out.println("++++++++" + scale);
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
