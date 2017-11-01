package com.example.z.zcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author z
 */
public class ScrollviewActivity extends AppCompatActivity {


    @BindView(R.id.mysc1)
    com.example.z.zcustomview.widget.MyScrollView mysc1;
    @BindView(R.id.mysc2)
    com.example.z.zcustomview.widget.MyScrollView mysc2;
    @BindView(R.id.hosc1)
    HorizontalScrollView hosc1;
    @BindView(R.id.ll_sc_img)
    LinearLayout llScImg;
    @BindView(R.id.hosc2)
    HorizontalScrollView hosc2;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
        ButterKnife.bind(this);
        inflater = LayoutInflater.from(this);
        initData();
        setScrollView();
    }

    public void initData() {

        for (int i = 0; i < 100; i++) {

            View view = inflater.inflate(R.layout.scrollview_item_img, llScImg, false);
            ImageView imageView = view.findViewById(R.id.img_sc_item);

            imageView.setImageResource(R.mipmap.ic_launcher);

            llScImg.addView(view);
        }
    }

    public void setScrollView() {

        mysc1.setScrollView(mysc2);
        mysc2.setScrollView(mysc1);


    }
}
