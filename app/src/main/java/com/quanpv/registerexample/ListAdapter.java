package com.quanpv.registerexample;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by QuanPV on 4/2/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Data> dataList;
    private Context context;

    public ListAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.tv_header.setText(data.getTitle());
//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

//        if (position == 0) {
//            holder.rcv_content.setLayoutManager(new GridLayoutManager(context, 2));
//        } else {
//            holder.rcv_content.setLayoutManager(new LinearLayoutManager(context));
//        }
        holder.rcv_content.setLayoutManager(new LinearLayoutManager(context));
        holder.rcv_content.setAdapter(new ContentAdapter(data.getContent()));


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_header;
        RecyclerView rcv_content;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_header = itemView.findViewById(R.id.tv_header);
            rcv_content = itemView.findViewById(R.id.rcv_content);
        }
    }

}
