package com.example.youtubesearchapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YouTubeApiService {


    @GET("search?part=snippet&type=video")
    Call<youtuberesponse> searchVideos(
            @Query("q") String query,
            @Query("maxResults") int maxResults,
            @Query("key") String apiKey
    );
}