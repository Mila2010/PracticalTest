package com.example.practicaltest;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Millochka on 12/10/16.
 */
public class MyFragmnet extends Fragment {

    public final String TAG="com.example.MyFragment";

    Retrofit mRetrofit;

    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.my_fragment, container, false);

        return view;


    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRetrofit = new Retrofit.Builder().baseUrl("https://vine.co/api/timelines/users/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService= mRetrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.fetchResponse();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        ResponseBody responseBody = response.body();

                        String input = responseBody.string();

                        Gson gson = new Gson();

                        Model model = gson.fromJson(input, Model.class);

                        Data data = model.getData();

                        List<Record> records = data.getRecords();
                        Log.d(TAG,Integer.toString(records.size()));

                        initRecyclerV(view, data,getActivity());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }




//



                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.d(TAG,"Failed");

            }
        });

    }

    public void initRecyclerV(View view,Data myData, Activity myActivity ){

        mRecyclerView=(RecyclerView) view.findViewById(R.id.recview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerView.setAdapter(new MyAdapter(myData, myActivity));}
}
