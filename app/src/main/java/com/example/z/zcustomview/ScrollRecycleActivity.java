package com.example.z.zcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.z.zcustomview.widget.MyRecycleView;
import com.example.z.zcustomview.widget.MyHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollRecycleActivity extends AppCompatActivity {


//    DataAdapter dataAdapter;

    List mListData;
    @BindView(R.id.lv_left)
    MyRecycleView lvLeft;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.lin_year_title)
    LinearLayout linYearTitle;
    @BindView(R.id.header_horizontal)
    MyHorizontalScrollView headerHorizontal;
    @BindView(R.id.lin_header_content)
    LinearLayout linHeaderContent;
    @BindView(R.id.lv_data)
    MyRecycleView lvData;
    @BindView(R.id.data_horizontal)
    MyHorizontalScrollView dataHorizontal;
    @BindView(R.id.lin_data_content)
    LinearLayout linDataContent;
    @BindView(R.id.scroll_content)
    ScrollView scrollContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_recycle);
        ButterKnife.bind(this);
        dataHorizontal.setScrollView(headerHorizontal);
        headerHorizontal.setScrollView(dataHorizontal);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lvData.setLayoutManager(linearLayoutManager);
        DataAdapter dataAdapter = new DataAdapter();
        lvData.setAdapter(dataAdapter);



        mListData = new ArrayList<>();
        mListData.add("1");
        mListData.add("2");
        mListData.add("3");
        mListData.add("4");
        mListData.add("5");
        mListData.add("6");
        mListData.add("7");
        mListData.add("8");
        mListData.add("9");
        mListData.add("10");
        mListData.add("11");
        mListData.add("12");
        mListData.add("13");
        dataAdapter.setData(mListData);

        
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        lvLeft.setLayoutManager(linearLayoutManager2);
        LeftAdapter leftAdapter = new LeftAdapter();
        lvLeft.setAdapter(leftAdapter);
        leftAdapter.setData(mListData);
    }


    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

        private List list;

        public void setData(List list) {

            this.list = list;

            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycleview, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        private static final String TAG = "DataAdapter";
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Log.d(TAG, "onBindViewHolder: "+position);
        }


        @Override
        public int getItemCount() {
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_data)
            TextView tvData;
            @BindView(R.id.lin_content)
            LinearLayout linContent;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }


}
