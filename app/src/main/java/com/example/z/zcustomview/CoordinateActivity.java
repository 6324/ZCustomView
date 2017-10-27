package com.example.z.zcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * 坐标系
 *
 * @author z
 */
public class CoordinateActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.tvposition)
    TextView tvposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn1)
    public void showXy1() {

        Toast.makeText(this, "坐标[" + btn1.getLeft() + "," + btn1.getRight() +
                "," + btn1.getTop() + "," + btn1.getBottom() + "]", Toast.LENGTH_SHORT).show();


    }

    @OnTouch(R.id.btn2)
    public boolean showXy2(View v, MotionEvent event) {
        tvposition.setText("[" + event.getRawX() + "," + event.getRawY() + "],["+event.getX()+","+event.getY()+"]");

//        Toast.makeText(this, "坐标[" + btn2.getPivotX() + "," + btn2.getY() + "]", Toast.LENGTH_SHORT).show();

        return true;
    }
}
