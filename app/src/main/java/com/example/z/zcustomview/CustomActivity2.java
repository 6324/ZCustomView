package com.example.z.zcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.z.zcustomview.widget.CustomView2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * canvas画布操作
 *
 * @author z
 */
public class CustomActivity2 extends AppCompatActivity {

    @BindView(R.id.cus2)
    CustomView2 cus2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom2);
        ButterKnife.bind(this);
    }
}
