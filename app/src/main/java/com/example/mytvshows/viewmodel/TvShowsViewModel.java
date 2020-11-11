package com.example.mytvshows.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytvshows.data.repository.TvShowpage.ShowsPageRepository;
import com.example.mytvshows.model.TVShowsPage;

public class TvShowsViewModel extends ViewModel {

    ShowsPageRepository showsPageRepository = new ShowsPageRepository();
    public LiveData<TVShowsPage> tvShowsPageLiveData = new MutableLiveData<>();

    public void getShowPage(int page){
        tvShowsPageLiveData = showsPageRepository.getShowPage(page);
    }

}
