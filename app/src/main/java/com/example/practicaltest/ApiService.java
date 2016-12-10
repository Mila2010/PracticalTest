package com.example.practicaltest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Millochka on 12/10/16.
 */

public interface ApiService {

    @GET("918753190470619136")
    Call<ResponseBody> fetchResponse();
}
