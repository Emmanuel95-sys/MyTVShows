package com.example.mytvshows.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytvshows.R;
import com.example.mytvshows.Show;
import com.example.mytvshows.databinding.ActivityShowDetailBinding;
import com.example.mytvshows.model.TVShowDetails.TvShow;
import com.example.mytvshows.viewmodel.TvShowsViewModel;
import com.squareup.picasso.Picasso;

public class ShowDetailActivity extends AppCompatActivity {
    private static final String TAG = "ShowDetailActivity";

    TvShowsViewModel tvShowsViewModel;
    ImageView tv_show_name,iv_back_arrow,iv_share,iv_portrait_show_image,imageView_header;
    TextView tv_show_name_yellow,tv_description,tv_rating,tv_genre,tv_release_date;
    RecyclerView rv_capitulos;
    Show show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        ActivityShowDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_show_detail);
        Bundle extras = getIntent().getExtras();
        show = (Show) extras.getSerializable("show");
        binding.setShow(show);
        initLayoutViews();
        initViewModel();
        observeData();
        setClickListeners();
    }

    private void setClickListeners() {
        iv_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,"¡Hola! te recomiendo: " + show.getName() + " de " + show.getNetwork() + "\n" + show.getImage_thumbnail_path());
                startActivity(Intent.createChooser(shareIntent, "¡Recomienda este show! :D"));
            }
        });
    }

    private void observeData() {
        Bundle extras = getIntent().getExtras();

        show = (Show) extras.getSerializable("show");
        Log.d(TAG, "observeData: " + show);

        Long showId = show.getId();

        tvShowsViewModel.getShowDetails(showId);
        tvShowsViewModel.tvShowLiveData.observe(ShowDetailActivity.this, new Observer<TvShow>() {
            @Override
            public void onChanged(TvShow tvShow) {
                updateUI(tvShow);
            }
        });
    }

    private void updateUI(TvShow tvShow) {
        if(tvShow != null) {
//            tv_show_name.setText(tvShow.getName());
            tv_show_name_yellow.setText(tvShow.getName());
            tv_rating.setText(tvShow.getRating());
            tv_description.setText(tvShow.getDescription());
            tv_release_date.setText(tvShow.getStart_date());
            Picasso.get().load(show.getImage_thumbnail_path()).into(imageView_header);
            Picasso.get().load(show.getImage_thumbnail_path()).into(iv_portrait_show_image);
        }
    }

    private void initLayoutViews() {
        tv_release_date = findViewById(R.id.tv_release_date);
        iv_back_arrow = findViewById(R.id.iv_back_arrow);
        //= findViewById(R.id.);
        iv_share = findViewById(R.id.iv_share);
        iv_portrait_show_image = findViewById(R.id.iv_portrait_show_image);
        imageView_header = findViewById(R.id.imageView_header);
//        tv_show_name = findViewById(R.id.tv_show_name);
        tv_show_name_yellow = findViewById(R.id.tv_show_name_yellow);
        tv_description = findViewById(R.id.tv_description);
        tv_rating = findViewById(R.id.tv_rating);
        tv_genre = findViewById(R.id.tv_genre);
        rv_capitulos = findViewById(R.id.rv_capitulos);
    }

    private void initViewModel() {
        tvShowsViewModel = new ViewModelProvider(ShowDetailActivity.this).get(TvShowsViewModel.class);
    }
}