package com.example.mytvshows.data.repository.TvShowpage;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mytvshows.model.TVShowsPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowsPageRepository {
    private static final String TAG = "ShowsPageRepository";
    public static ShowsPageRepository showsPageRepository;

    public static ShowsPageRepository getInstance(){
        if(showsPageRepository == null){
            showsPageRepository = new ShowsPageRepository();
        }
        return showsPageRepository;
    }

    private final ShowsApi showsApi;

    public ShowsPageRepository(){
        showsApi = MyShowsApiService.createService(ShowsApi.class);
    }

    public MutableLiveData<TVShowsPage> getShowPage(int page){

        final MutableLiveData<TVShowsPage> tvShowPageMLD = new MutableLiveData<>();

        showsApi.getShowPage(page).enqueue(new Callback<TVShowsPage>() {

            TVShowsPage tvShowsPage = new TVShowsPage();

            @Override
            public void onResponse( Call<TVShowsPage> call, Response<TVShowsPage> response) {
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
