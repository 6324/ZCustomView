package com.example.z.zcustomview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.z.zcustomview.widget.Zgrid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        long a = System.currentTimeMillis();
        listHeader = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listHeader.add("第" + i + "列");
        }


        listData = new ArrayList<>();

        int max = 5;
        int min = 1;
        Random random = new Random();


        String str = "哈";

        for (int i = 0; i < 100; i++) {
            List list = new ArrayList();
            for (int j = 0; j < 10; j++) {
                String aa = "";
                int s = random.nextInt(max) % (max - min + 1) + min;
                for (int k = 0; k < s; k++) {
                    aa += str;
                }
                list.add(aa);
//                list.add("第" + i + "行 第" + (j + 1) + "列");
            }
            listData.add(list);
        }


        View view = findViewById(R.id.ll_main);
        Zgrid.getInstance()
                .setContext(this)
                .setHeadHight(200)
//                .setLeftWidth(500)
                .setHeaderBackgroundColor("#4591f5")
                .setHeaderTextColor("#FFFFFF")
                .setHeaderData(listHeader)
                .setData(listData)
                .viewParent((LinearLayout) view)
                .show();


        Toast.makeText(this, "耗时 " + (System.currentTimeMillis() - a), Toast.LENGTH_SHORT).show();
    }

}
