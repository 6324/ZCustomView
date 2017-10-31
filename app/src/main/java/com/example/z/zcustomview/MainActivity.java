package com.example.z.zcustomview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    //
    @OnClick(R.id.btngoxy)
    public void startXy() {
        startActivity(new Intent(this, CoordinateActivity.class));
    }

    @OnClick(R.id.btncus1)
    public void startcus1() {
        startActivity(new Intent(this, CustomActivity1.class));
    }

    @OnClick(R.id.btncus2)
    public void startcus2() {
        startActivity(new Intent(this, CustomActivity2.class));
    }

    @OnClick(R.id.btncus3)
    public void startcus3() {
        startActivity(new Intent(this, CustomActivity3.class));
    }

    @OnClick(R.id.btncus4)
    public void startcus4() {
        startActivity(new Intent(this, CustomActivity4.class));
    }

    @OnClick(R.id.btncus5)
    public void startcus5() {
        startActivity(new Intent(this, BezierActivity1.class));
    }
}
