package com.example.mytvshows.data.repository.TvShowDetails;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mytvshows.data.repository.MyShowsApiService;
import com.example.mytvshows.data.repository.ShowsApi;
import com.example.mytvshows.model.TVShowDetails.TvShow;
import com.example.mytvshows.model.TVShowDetails.TvShowResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowDetailRepository {
    private static final String TAG = "ShowDetailRepository";
    public static ShowDetailRepository showDetailRepository;

    public static ShowDetailRepository getInstance(){

    if(showDetailRepository == null){
        showDetailRepository = new ShowDetailRepository();
    }
    return showDetailRepository;
    }

    private final ShowsApi showsApi;

    public ShowDetailRepository(){
        showsApi = MyShowsApiService.createService(ShowsApi.class);
    }

    public MutableLiveData<TvShow> getShowDetails(Long showId){

        MutableLiveData<TvShow> tvShowMLD = new MutableLiveData<>();

        showsApi.getShowDetails(showId).enqueue(new Callback<TvShowResponse>() {

            TvShow tvShow = new TvShow();

            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    tvShow = response.body().getTvShow();
                }
                tvShow.setCode(response.code());
                Log.d(TAG, "onResponse: " + response.code());
                tvShowMLD.setValue(tvShow);
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {
                tvShowMLD.setValue(null);
            }
        });
        return tvShowMLD;
    }

}
