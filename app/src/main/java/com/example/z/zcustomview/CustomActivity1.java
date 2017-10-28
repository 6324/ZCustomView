package com.example.z.zcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * canvas绘制基本图形
 * @author z
 */
public class CustomActivity1 extends AppCompatActivity {

    @BindView(R.id.cus1)
    com.example.z.zcustomview.widget.CustomView1 cus1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view1);
        ButterKnife.bind(this);

    }
}
