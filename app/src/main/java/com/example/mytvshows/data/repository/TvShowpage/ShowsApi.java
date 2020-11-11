package com.example.mytvshows.data.repository.TvShowpage;

import com.example.mytvshows.model.TVShowsPage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShowsApi {
    @Headers({
            "Content-Type: application/json",
            "Accept: */*"
    })

    @GET("most-popular")
    Call<TVShowsPage> getShowPage(@Query("page") int page);
}
