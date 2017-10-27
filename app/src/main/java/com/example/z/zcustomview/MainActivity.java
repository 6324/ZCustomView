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

    @OnClick(R.id.btnmethod)
    public void startMethod() {
        startActivity(new Intent(this, CustomView1.class));
    }
}
