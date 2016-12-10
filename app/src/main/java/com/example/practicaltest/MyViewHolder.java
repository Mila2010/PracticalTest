package com.example.practicaltest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Millochka on 12/10/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    View mView;
    TextView mUserName;

    public MyViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView=itemView;

        mUserName= (TextView) mView.findViewById(R.id.user_name);

    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.recycler_view, parent, false);

    }


    protected void onBind(Record record ) {

        mUserName.setText(record.getUsername());

    }
}

