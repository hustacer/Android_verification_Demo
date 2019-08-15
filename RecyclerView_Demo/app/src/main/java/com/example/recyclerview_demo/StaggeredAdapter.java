package com.example.recyclerview_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StaggeredAdapter extends SimpleAdapter {
    private List<Integer> mHeight;

    public StaggeredAdapter(Context mContext, List<String> mDatas) {
        super(mContext, mDatas);

        mHeight = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
            mHeight.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeight.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));
        setItemEvent(holder, position);
    }
}