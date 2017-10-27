package com.example.z.zcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author z
 */
public class CustomView1 extends AppCompatActivity {

    @BindView(R.id.cus1)
    com.example.z.zcustomview.widget.CustomView1 cus1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view1);
        ButterKnife.bind(this);

    }
}
