package com.example.practicaltest;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Millochka on 12/10/16.
 */
public class MyAdapter extends RecyclerView.Adapter {

    List<Record> mRecords = new ArrayList<>();


    public MyAdapter(Data myData) {

        this.mRecords=myData.getRecords();


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       MyViewHolder myViewHolder= (MyViewHolder) holder;
       myViewHolder.onBind(mRecords.get(position));


    }

    @Override
    public int getItemCount() {
        return mRecords.size();
    }
}
