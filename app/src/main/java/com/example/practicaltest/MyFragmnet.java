package com.example.practicaltest;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import retrofit2.Retrofit;

/**
 * Created by Millochka on 12/10/16.
 */
public class MyFragmnet extends Fragment {

    public final String TAG="com.example.MyFragment";

    View mView;

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
        mView = view;
        DownloadFilesTask runner = new DownloadFilesTask();

        runner.execute();





    }

    public void initRecyclerV(Data myData){

        mRecyclerView=(RecyclerView) mView.findViewById(R.id.recview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new MyAdapter(myData));}

    public String getStringFromUrl(){

    StringBuilder content = new StringBuilder();

    try
    {
        URL url = null;
        try {
            url = new URL("https://vine.co/api/timelines/users/918753190470619136" );

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        URLConnection urlConnection = url.openConnection();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            content.append(line + "\n");
        }
        bufferedReader.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return content.toString();}


    protected class DownloadFilesTask extends AsyncTask<URL, View, String> {



        @Override
        protected String doInBackground(URL... urls) {

            String result = getStringFromUrl();

            Log.d(TAG,"Failed");


            return result;
        }

        @Override
        protected void onPostExecute(String result){

            Gson gson = new Gson();

            Model model = gson.fromJson(result, Model.class);

            Data data = model.getData();

            initRecyclerV(data);

        }
    }
}


