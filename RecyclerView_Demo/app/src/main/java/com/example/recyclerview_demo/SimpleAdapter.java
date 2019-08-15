package com.example.recyclerview_demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context mContext;
    protected List<String> mDatas;
    private LayoutInflater mLayoutInflater;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public SimpleAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_single_textview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        setItemEvent(holder, position);
    }

    protected void setItemEvent(final MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addData(int position) {
        mDatas.add(position, "Insert one");
        notifyItemInserted(position);
    }

    public void deleteData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}


class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.id_tv);
    }
}