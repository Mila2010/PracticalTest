package com.example.practicaltest;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Millochka on 12/10/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    View mView;
    TextView mUserName;
    TextView mLiked;
    LinearLayout mRecord;

    public MyViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView=itemView;

        mUserName= (TextView) mView.findViewById(R.id.user_name);
        mLiked = (TextView)mView.findViewById(R.id.been_liked);
        mRecord=(LinearLayout)mView.findViewById(R.id.record_item);

    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.recycler_view, parent, false);

    }


    protected void onBind(Record record ) {

        mUserName.setText(record.getUsername());
        mLiked.setText("Liked: "+record.getLiked());
        String color=record.getProfileBackground().substring(2);
        mRecord.setBackgroundColor(Color.parseColor("#"+color));

    }
}

