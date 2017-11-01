package com.example.z.zcustomview;

import android.support.v7.widget.RecyclerView;
import android.util.EventLogTags;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * @author z
 * @date 2017/11/1 下午6:43
 */

public  class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    private static final String TAG = "LeftAdapter";

    private List list;

    public void setData(List list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rowtitle, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvLeft.setText("第" + list.get(position).toString() + "行");
    }


    @Override
    public int getItemCount() {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_left)
        TextView tvLeft;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}