package com.example.mytvshows.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mytvshows.R;
import com.example.mytvshows.interfaces.clicklistener.ClickListener;
import com.example.mytvshows.model.TVShowPage.Show;
import com.example.mytvshows.model.TVShowPage.TVShowsPage;
import com.example.mytvshows.view.adapters.TvShowPageAdapter;
import com.example.mytvshows.viewmodel.TvShowsViewModel;

import java.util.ArrayList;

public class ShowPageActivity extends AppCompatActivity implements ClickListener<Show> , SearchView.OnQueryTextListener{
    private static final String TAG = "ShowPageActivity";
    ImageView iv_page_back, iv_page_forward;
    TextView tv_page_number;
    TvShowsViewModel tvShowsViewModel;
    RecyclerView tvShowsRv;
    TvShowPageAdapter tvShowPageAdapter;
    SearchView search_bar;
    static int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayoutViews();
        initViewModel();
        observeData();
    }

    private void observeData() {
        tvShowsViewModel.getShowPage(page);
        tvShowsViewModel.tvShowsPageLiveData.observe(ShowPageActivity.this, new Observer<TVShowsPage>() {
            @Override
            public void onChanged(TVShowsPage tvShowsPage) {
                tvShowPageAdapter = createAdapter(tvShowsPage.getShows());
                tvShowsRv.setAdapter(tvShowPageAdapter);
            }
        });
    }

    private TvShowPageAdapter createAdapter(ArrayList<Show> shows) {
        return new TvShowPageAdapter(shows, this);
    }

    private void initViewModel() {
        tvShowsViewModel = new ViewModelProvider(ShowPageActivity.this).get(TvShowsViewModel.class);
    }

    private void initLayoutViews() {
        iv_page_back = findViewById(R.id.iv_page_back);
        iv_page_forward = findViewById(R.id.iv_page_forward);
        tv_page_number = findViewById(R.id.tv_page_number);
        search_bar = findViewById(R.id.search_bar);
        search_bar.setOnQueryTextListener(ShowPageActivity.this);
        tvShowsRv= findViewById(R.id.tvShowsRv);
        setPageTv();
    }

    @Override
    public void onClick(Show show, int position) {
        Intent detailIntent = new Intent(ShowPageActivity.this, ShowDetailActivity.class);
        detailIntent.putExtra("show", show);
        startActivity(detailIntent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        tvShowsViewModel.lookForShows(query);
        tvShowsViewModel.tvShowsPageLiveData.observe(ShowPageActivity.this, new Observer<TVShowsPage>() {
            @Override
            public void onChanged(TVShowsPage tvShowsPage) {
                Log.d(TAG, "onChanged: " + tvShowsPage.getShows().size());
                tvShowPageAdapter = createAdapter(tvShowsPage.getShows());
                tvShowsRv.setAdapter(tvShowPageAdapter);
                tvShowPageAdapter.notifyDataSetChanged();
            }
        });

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(newText.equals("")){
            observePage();
        }
        return false;
    }

    private void observePage() {
        tvShowsViewModel.getShowPage(page);
        tvShowsViewModel.tvShowsPageLiveData.observe(ShowPageActivity.this, new Observer<TVShowsPage>() {
            @Override
            public void onChanged(TVShowsPage tvShowsPage) {
                Log.d(TAG, "onChanged: " + tvShowsPage.getShows().size());
                tvShowPageAdapter = createAdapter(tvShowsPage.getShows());
                tvShowsRv.setAdapter(tvShowPageAdapter);
                tvShowPageAdapter.notifyDataSetChanged();
            }
        });
    }

    public void incrementPage (View view){
        page++;
        observePage();
        setPageTv();
    }

    private void setPageTv() {
        tv_page_number.setText(String.valueOf(page));
    }

    public void decrementPage (View view){
        if(page == 1){
            page = 1;
        }else{
            page--;
        }
        observePage();
        setPageTv();
    }

}