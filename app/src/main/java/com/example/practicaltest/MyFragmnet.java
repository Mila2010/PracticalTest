package com.example.practicaltest;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

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

//                    Model model=new Model();
//                    model =

                    try {
                        ResponseBody responseBody = response.body();
                        Log.d(TAG,responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.d(TAG,"Failed");

            }
        });

    }
}
