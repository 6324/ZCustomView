package com.example.z.zcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.z.zcustomview.widget.CustomView3;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author z
 */
public class CustomActivity3 extends AppCompatActivity {

    @BindView(R.id.cus3)
    CustomView3 cus3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom3);
        ButterKnife.bind(this);
    }
}
