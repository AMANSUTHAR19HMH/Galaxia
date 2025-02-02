package com.mazor.galaxia.ApiService;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    // Use the new API endpoint
    @GET("cgi-bin/nstedAPI/nph-nstedAPI?table=cumulative&where=koi_prad<2 and koi_teq>180 and koi_teq<303 and koi_disposition like 'CANDIDATE'&format=json")
    Call<JsonArray> getExoplanets();  // Fetch JSON array of exoplanets
}
