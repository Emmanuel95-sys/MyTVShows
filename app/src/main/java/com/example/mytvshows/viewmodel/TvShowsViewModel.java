package com.example.mytvshows.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytvshows.data.repository.SearchShowsRepository;
import com.example.mytvshows.data.repository.TvShowDetails.ShowDetailRepository;
import com.example.mytvshows.data.repository.TvShowpage.ShowsPageRepository;
import com.example.mytvshows.model.TVShowDetails.TvShow;
import com.example.mytvshows.model.TVShowPage.TVShowsPage;

public class TvShowsViewModel extends ViewModel {

    ShowsPageRepository showsPageRepository = new ShowsPageRepository();
    public LiveData<TVShowsPage> tvShowsPageLiveData = new MutableLiveData<>();

    public void getShowPage(int page){
        tvShowsPageLiveData = showsPageRepository.getShowPage(page);
    }

    ShowDetailRepository showDetailRepository = new ShowDetailRepository();
    public  LiveData<TvShow> tvShowLiveData = new MutableLiveData<>();

    public void getShowDetails(Long showId){
        tvShowLiveData = showDetailRepository.getShowDetails(showId);
    }

    SearchShowsRepository searchShowsRepository = new SearchShowsRepository();

    public void lookForShows(String query){
        tvShowsPageLiveData = searchShowsRepository.lookForShows(query);
    }

}
