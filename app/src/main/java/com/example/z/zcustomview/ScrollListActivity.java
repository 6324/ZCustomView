package com.example.z.zcustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.z.zcustomview.widget.MyHorizontalScrollView;
import com.example.z.zcustomview.widget.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author z
 */
public class ScrollListActivity extends AppCompatActivity {


    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.lin_year_title)
    LinearLayout linYearTitle;
    @BindView(R.id.header_horizontal)
    MyHorizontalScrollView headerHorizontal;
    @BindView(R.id.lin_header_content)
    LinearLayout linHeaderContent;
    @BindView(R.id.lv_left)
    MyListView lvLeft;
    @BindView(R.id.lv_data)
    MyListView lvData;
    @BindView(R.id.data_horizontal)
    MyHorizontalScrollView dataHorizontal;
    @BindView(R.id.lin_data_content)
    LinearLayout linDataContent;
    @BindView(R.id.scroll_content)
    ScrollView scrollContent;
    private List<String> mListData;

    private LeftAdapter mLeftAdapter;

    private DataAdapter mDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_list);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        headerHorizontal.setScrollView(dataHorizontal);
        dataHorizontal.setScrollView(headerHorizontal);

        mListData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mListData.add("data"+i);
        }



        mLeftAdapter = new LeftAdapter();
        lvLeft.setAdapter(mLeftAdapter);

        mDataAdapter = new DataAdapter();
        lvData.setAdapter(mDataAdapter);
    }

    class LeftAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(ScrollListActivity.this).inflate(R.layout.item_rowtitle, null);
                holder.tvLeft = convertView.findViewById(R.id.tv_left);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvLeft.setText("第" + position + "行");

            return convertView;
        }

        class ViewHolder {
            TextView tvLeft;
        }
    }

    class DataAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(ScrollListActivity.this).inflate(R.layout.item_data, null);
                holder.tvData = (TextView) convertView.findViewById(R.id.tv_data);
                holder.linContent = (LinearLayout) convertView.findViewById(R.id.lin_content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            return convertView;
        }

        class ViewHolder {
            TextView tvData;
            LinearLayout linContent;
        }
    }
}
