package com.example.z.zcustomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.z.zcustomview.util.UIUtil;
import com.example.z.zcustomview.widget.Zgrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZgridActivity extends AppCompatActivity {
    private List<List> listData;
    private List<String> listHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zgrid);
        initView();
    }

    public void initView() {
        listHeader = new ArrayList<>();
        listHeader.add("第一列");
        listHeader.add("第二列");
        listHeader.add("第三列");
        listHeader.add("第四列");
        listHeader.add("第五列");
        listHeader.add("第六列");

        listData = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            List list = new ArrayList();
            for (int j = 0; j < 6; j++) {
                list.add("第" + i + "行 第" + (j + 1 )+ "列");
            }
            listData.add(list);
        }

        View view = findViewById(R.id.ll_main);
        Zgrid.getInstance()
                .setContext(this)
                .setModel(Zgrid.GRID_MODEL_DEFAULT)//默认可以不设置
                .setHeadWidth(300)//单个网格的宽度,默认自适应
                .setHeadHight(200)
                .setHeaderBackgroundColor("#4591f5")
                .setHeaderTextColor("#FFFFFF")
                .setHeaderData(listHeader)
                .setData(listData)
                .viewParent((LinearLayout) view)
                .show();
        View view2 = findViewById(R.id.ll_main2);
        Zgrid.getInstance()
                .setContext(this)
//                .setModel(Zgrid.GRID_MODEL_DEFAULT)//默认可以不设置
//                .setHeadWidth(300)//单个网格的宽度,默认自适应
//                .setHeadHight(200)
//                .setHeaderBackgroundColor("#4591f5")
//                .setHeaderTextColor("#FFFFFF")
                .setHeaderData(listHeader)
                .setData(listData)
                .viewParent((LinearLayout) view2)
                .show();


    }
}
