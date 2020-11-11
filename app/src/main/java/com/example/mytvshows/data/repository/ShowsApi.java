package com.example.mytvshows.data.repository;

import com.example.mytvshows.model.TVShowDetails.TvShow;
import com.example.mytvshows.model.TVShowDetails.TvShowResponse;
import com.example.mytvshows.model.TVShowPage.TVShowsPage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ShowsApi {
    @Headers({
            "Content-Type: application/json",
            "Accept: */*"
    })

    /* Peticion para obtener la lista de shows mas populares por pagina(@page)*/

    @GET("most-popular")
    Call<TVShowsPage> getShowPage(@Query("page") int page);

    /** obtener detalles del show por id*/

    @GET("show-details")
    Call<TvShowResponse> getShowDetails(@Query("q") Long showId);

    /** buscar shos por search view*/

    @GET("search")
    Call<TVShowsPage> lookForShows(@Query("q") String query);

}
