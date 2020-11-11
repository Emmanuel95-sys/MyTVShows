package com.example.mytvshows.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mytvshows.data.repository.TvShowpage.ShowsPageRepository;
import com.example.mytvshows.model.TVShowPage.TVShowsPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchShowsRepository {
    private static final String TAG = "SearchShowsRepository";
    public static SearchShowsRepository searchShowsRepository;

    public static SearchShowsRepository getInstance(){
        if(searchShowsRepository == null){
            searchShowsRepository = new SearchShowsRepository();
        }
        return searchShowsRepository;
    }

    private ShowsApi showsApi;

    public SearchShowsRepository(){
        showsApi = MyShowsApiService.createService(ShowsApi.class);
    }

    public MutableLiveData<TVShowsPage> lookForShows(String query){

        MutableLiveData<TVShowsPage> tvShowPageMLD = new MutableLiveData<>();

        showsApi.lookForShows(query).enqueue(new Callback<TVShowsPage>() {

            TVShowsPage tvShowsPage = new TVShowsPage();

            @Override
            public void onResponse(Call<TVShowsPage> call, Response<TVShowsPage> response) {
                if(response.isSuccessful() && response.body() != null){
                    tvShowsPage = response.body();
                }
                tvShowsPage.setCode(response.code());
                Log.d(TAG, "onResponse: " + response.code());
                tvShowPageMLD.setValue(tvShowsPage);
            }

            @Override
            public void onFailure(Call<TVShowsPage> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                tvShowPageMLD.setValue(null);
            }
        });
        return tvShowPageMLD;
    }

}