package com.example.z.zcustomview.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.z.zcustomview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author z
 * @date 2017/11/4 下午2:33
 */

public class Zgrid {
    // TODO: 2017/11/5 下午10:06  1.自适应网格线对不齐


    public static final int GRID_MODEL_DEFAULT = 0;//左侧、上侧固定
    public static final int GRID_MODEL_NO_LEFT = 1;//不含左侧
    public static final int WRAP_CONTENT = -2;
    public static final int MATCH_PARENT = -1;
    public static final String DEFAULT_LINE_COLOR = "#333333";//全局分割线颜色
    public static final String DEFAULT_GRID_BACKGROUND_COLOR = "#FFFFFF";//表格背景颜色
    public static final String DEFAULT_TEXT_COLOR = "#FF888888";//全局文字颜色
    public static final String DEFAULT_NULL = "无";
    public static final int TEXT_SIZE = 14;//全局默认字体大小

    private Context context;
    private LinearLayout view;//表格主布局
    private ViewGroup viewParent;//表格需要附加的布局
    private boolean isZebra = false;//斑马线
    LayoutInflater inflater;
    MyLm lm;
    private int gridModel = GRID_MODEL_DEFAULT;//模式
    private static int maxWidth = 0;
    private int dataIndexLength = 1;

    //header
    private LinearLayout ll_header, ll_header_title;
    private TextView tv_header_title;

    private String headTitle = "项目";//标题
    private List headerData = new ArrayList();//header数据
    private String headerBackGroundColor = DEFAULT_GRID_BACKGROUND_COLOR//背景颜色
            , headTextColor = DEFAULT_TEXT_COLOR//文字颜色
            , headLineColor = DEFAULT_LINE_COLOR;//分割线颜色
    private int headWidth = WRAP_CONTENT, headHight = WRAP_CONTENT;

    //dataGrid
    private MyRecycleView rvLeft, rvData;
    private MyHorizontalScrollView scrollViewHead, scrollViewData;
    private List<List> listData = new ArrayList<>();//内容数据
    private String dataBackgrountColor = DEFAULT_GRID_BACKGROUND_COLOR//表格背景颜色
            , dataTextColor = DEFAULT_TEXT_COLOR//表格文本颜色
            , dataLineColor = DEFAULT_LINE_COLOR;//表格分割线颜色
    private int dataWidth = WRAP_CONTENT, dataHight = WRAP_CONTENT;

    //left
    private int leftWidth = WRAP_CONTENT;
    private String leftBackgrountColor = DEFAULT_GRID_BACKGROUND_COLOR;
    Map mapLayoutPrams = new HashMap();

    public static Zgrid getInstance() {
        return new Zgrid();
    }


    /**
     * @param context
     * @return 设置上下文 必须设置
     */
    public Zgrid setContext(Context context) {
        this.context = context;
        return this;
    }

    /**
     * @param view
     * @return 父布局 必须设置
     */
    public Zgrid viewParent(LinearLayout view) {
        this.viewParent = view;
        return this;
    }

    /**
     * @param listHeader
     * @return header数据 必须设置
     */
    // TODO: 2017/11/5 下午10:26  根据list类型判断显示层数
    public Zgrid setHeaderData(List listHeader) {
        this.headerData = listHeader;
        return this;
    }

    /**
     * @param listData
     * @return 设置数据区的数据 必须设置
     */
    public Zgrid setData(List listData) {
        this.listData = listData;
        return this;
    }

//------------------------------------------------------------------------

    /**
     * @param headTitle
     * @return 左上角标题
     */
    public Zgrid setTitle(String headTitle) {
        this.headTitle = headTitle;
        return this;
    }


    /**
     * @param color
     * @return 设置header背景颜色
     */
    public Zgrid setHeaderBackgroundColor(String color) {
        this.headerBackGroundColor = color;
        return this;
    }

    /**
     * @param headTextColor
     * @return 设置header文字颜色
     */
    public Zgrid setHeaderTextColor(String headTextColor) {
        this.headTextColor = headTextColor;
        return this;
    }

    /**
     * @param color
     * @return 设置header分割线颜色
     */
    public Zgrid setHeaderLineColor(String color) {
        this.headLineColor = color;
        return this;
    }


    /**
     * @param width
     * @return 设置header每个格子的宽度 默认跟随data区格子变化
     */
//    public Zgrid setHeadWidth(int width) {
//        this.headWidth = width;
//        return this;
//    }

    /**
     * @param hight
     * @return 设置header每个格子的高度
     */
    public Zgrid setHeadHight(int hight) {
        this.headHight = hight;
        return this;
    }

//-------------------------------------

    /**
     * @param color
     * @return 设置数据区的背景颜色 如果设置斑马线样式，会覆盖此样式
     */
    public Zgrid setDataBackgrountColor(String color) {
        this.dataBackgrountColor = color;
        return this;
    }

    /**
     * @param color
     * @return 设置数据区文本颜色
     */
    public Zgrid setDataTextColor(String color) {
        this.dataTextColor = color;
        return this;
    }

    /**
     * @param color
     * @return 设置数据区分割线颜色
     */
    public Zgrid setDataLineColor(String color) {
        this.dataLineColor = color;
        return this;
    }

    /**
     * @param width
     * @return 设置数据区每个格子的宽度
     */
    public Zgrid setDataWidth(int width) {
        this.dataWidth = width;
        return this;
    }

    /**
     * @param height
     * @return 设置数据区每个格子的高度
     */
    public Zgrid setDataHight(int height) {
        this.dataHight = height;
        return this;
    }

//    ----------------------------------------


    /**
     * @param width
     * @return 设置左侧宽度
     */
    public Zgrid setLeftWidth(int width) {
        this.leftWidth = width;
        return this;
    }

    /**
     * @param color
     * @return 设置左侧背景颜色
     */
    public Zgrid setLeftBackgroundColor(String color) {
        this.leftBackgrountColor = color;
        return this;
    }

    /**
     * @param model
     * @return 设置表格模式
     */
    public Zgrid setModel(int model) {
        this.gridModel = model;
        return this;
    }

    /**
     * @param isZebra
     * @return 斑马线样式
     */
    public Zgrid setIsZebra(boolean isZebra) {
        this.isZebra = isZebra;
        return this;
    }


    public void show() {
        //初始化所有布局
        initView();

        switch (gridModel) {
            case GRID_MODEL_DEFAULT:
                //先设置数据区
                setDataView();
                //设置左侧区
                setLeftView();
                break;
            case GRID_MODEL_NO_LEFT:
                dataIndexLength = 0;
                ll_header_title.setVisibility(View.GONE);//隐藏左上角
                //先设置数据区
                setDataView();
                break;
        }


        //设置头
        setHeader();

        scrollViewHead.setScrollView(scrollViewData);
        scrollViewData.setScrollView(scrollViewHead);


    }

    public void initView() {
        inflater = LayoutInflater.from(context);
        view = (LinearLayout) inflater.inflate(R.layout.activity_scroll_recycle, null);
        //初始化主布局
        ll_header = view.findViewById(R.id.ll_header);//header
        ll_header_title = view.findViewById(R.id.ll_head_title);//左上角
        tv_header_title = view.findViewById(R.id.tv_header_title);//左上角文字

        rvLeft = view.findViewById(R.id.rv_left);//左侧recycleview
        rvData = view.findViewById(R.id.rv_data);//右侧recycleview

        scrollViewHead = view.findViewById(R.id.mhz_header);//header scrollview
        scrollViewData = view.findViewById(R.id.mhz_data);//data scrollview

        viewParent.addView(view);

    }


    public void setHeader() {

        tv_header_title.setText(headTitle);
        tv_header_title.setTextColor(Color.parseColor(headTextColor));
        if (headerData != null && !headerData.isEmpty()) {
            tv_header_title.setText(headerData.get(0).toString());
            //从1开始,0为固定的title
            for (int i = dataIndexLength; i < headerData.size(); i++) {
                View view = inflater.inflate(R.layout.item_gride, ll_header, false);

                LinearLayout ll_grid = view.findViewById(R.id.ll_grid);
                TextView tv_data = ll_grid.findViewById(R.id.tv_data);
                tv_data.setTextColor(Color.parseColor(headTextColor));

                tv_data.setText(headerData.get(i).toString());
                ll_header_title.setBackgroundColor(Color.parseColor(headerBackGroundColor));
                ll_header.setBackgroundColor(Color.parseColor(headerBackGroundColor));
                LinearLayout.LayoutParams layoutParams_ll_header_title = null;
                FrameLayout.LayoutParams layoutParams_ll_header = null;

                switch (gridModel) {
                    case GRID_MODEL_DEFAULT:

                        layoutParams_ll_header_title = new LinearLayout.LayoutParams(leftWidth, headHight);
                        switch (dataWidth) {
                            case WRAP_CONTENT:
                                layoutParams_ll_header = new FrameLayout.LayoutParams((Integer) mapLayoutPrams.get(i), headHight);
                                break;
                            default:
                                layoutParams_ll_header = new FrameLayout.LayoutParams(dataWidth, headHight);
                                break;

                        }
                        break;

                    case GRID_MODEL_NO_LEFT:

                        switch (dataWidth) {
                            case WRAP_CONTENT:
                                layoutParams_ll_header_title = new LinearLayout.LayoutParams((Integer) mapLayoutPrams.get(i), headHight);
                                layoutParams_ll_header = new FrameLayout.LayoutParams((Integer) mapLayoutPrams.get(i), headHight);
                                break;
                            default:
                                layoutParams_ll_header_title = new LinearLayout.LayoutParams(dataWidth, headHight);
                                layoutParams_ll_header = new FrameLayout.LayoutParams(dataWidth, headHight);
                                break;
                        }

                        break;
                }


                ll_grid.setLayoutParams(layoutParams_ll_header);
                ll_header_title.setLayoutParams(layoutParams_ll_header_title);

                ll_header.addView(ll_grid);
            }

        } else {
            System.out.println("------>未设置header");
        }


    }

    public void setLeftView() {

        //防止滑动卡顿
        rvLeft.setNestedScrollingEnabled(false);
        lm = new MyLm(context);
        rvLeft.setLayoutManager(lm);
        LeftAdapter leftAdapter = new LeftAdapter();
        rvLeft.setAdapter(leftAdapter);
        rvLeft.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        switch (leftWidth) {
            case WRAP_CONTENT:
                getLeftParams();
                break;
            default:

                break;
        }
        leftAdapter.setData(listData);

    }

    public void setDataView() {
        //防止滑动卡顿
        rvData.setNestedScrollingEnabled(false);
        lm = new MyLm(context);
        rvData.setLayoutManager(lm);
        DataAdapter dataAdapter = new DataAdapter();
        rvData.setAdapter(dataAdapter);
        rvData.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        switch (dataWidth) {
            case WRAP_CONTENT:
                getLayoutPrams();
                break;

        }

        dataAdapter.setData(listData);
    }

    public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {


        private List<List> list;

        public void setData(List list) {
            this.list = list;
            this.notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_gride, parent, false);
            ViewHolder viewHolder =
                    new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            LinearLayout.LayoutParams layoutParams;
            switch (leftWidth) {
                case WRAP_CONTENT:
                    layoutParams = new LinearLayout.LayoutParams(WRAP_CONTENT, dataHight);
                    break;
                default:
                    layoutParams = new LinearLayout.LayoutParams(leftWidth, dataHight);
                    break;
            }


            holder.llGrid.setLayoutParams(layoutParams);
            holder.tv_data.setText(list.get(position).get(0).toString());
        }


        @Override
        public int getItemCount() {
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.ll_grid)
            LinearLayout llGrid;
            @BindView(R.id.tv_data)
            public
            TextView tv_data;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }

    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

        private List<List> list;

        public void setData(List list) {
            this.list = list;
            notifyDataSetChanged();
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_data_recycle, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        private static final String TAG = "DataAdapter";


        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {


            for (int i = dataIndexLength; i < list.get(position).size(); i++) {
                View view = inflater.inflate(R.layout.item_gride, holder.ll_data, false);
                final LinearLayout grid = view.findViewById(R.id.ll_grid);
                TextView textView = grid.findViewById(R.id.tv_data);
                textView.setText(list.get(position).get(i).toString());
                LinearLayout.LayoutParams layoutParams;
                switch (dataWidth) {
                    case WRAP_CONTENT:
                        Log.d(TAG, "onBindViewHolder: WRAP_CONTENT");
                        layoutParams = new LinearLayout.LayoutParams((Integer) mapLayoutPrams.get(i), dataHight);
                        break;
                    default:
                        Log.d(TAG, "onBindViewHolder: dataWidth:" + dataWidth);
                        layoutParams = new LinearLayout.LayoutParams(dataWidth, dataHight);
                        break;
                }

                grid.setLayoutParams(layoutParams);
                holder.ll_data.addView(grid);
            }


        }


        @Override
        public int getItemCount() {
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }


        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.ll_data_recycle)
            LinearLayout ll_data;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }


    public class MyLm extends LinearLayoutManager {
        private static final String TAG = "MyLm";

        public MyLm(Context context) {
            super(context);
        }

        public MyLm(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        public MyLm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {

            super.onMeasure(recycler, state, widthSpec, heightSpec);
        }

    }

    private static final String TAG = "Zgrid";

    public void getLayoutPrams() {
        Log.e(TAG, "getLayoutPrams: WrapContent");

        for (int position = 0; position < listData.size(); position++) {
            for (int i = dataIndexLength; i < listData.get(position).size(); i++) {
                View view = inflater.inflate(R.layout.item_gride, null);
                final LinearLayout grid = view.findViewById(R.id.ll_grid);
                TextView textView = grid.findViewById(R.id.tv_data);
                textView.setText(listData.get(position).get(i).toString());

                grid.measure(0, 0);
                int width = grid.getMeasuredWidth();

                if (mapLayoutPrams.get(i) == null || (int) mapLayoutPrams.get(i) < width) {
                    mapLayoutPrams.put(i, width);
                }
                System.out.println(mapLayoutPrams);
            }
        }

    }


    public void getLeftParams() {
        for (int i = dataIndexLength; i < listData.size(); i++) {
            View view = inflater.inflate(R.layout.item_gride, null);
            final LinearLayout grid = view.findViewById(R.id.ll_grid);
            TextView textView = grid.findViewById(R.id.tv_data);
            textView.setText(listData.get(i).get(0).toString());

            grid.measure(0, 0);
            int width = grid.getMeasuredWidth();

            if (leftWidth < width) {
                leftWidth = width;
            }
        }
    }

}
