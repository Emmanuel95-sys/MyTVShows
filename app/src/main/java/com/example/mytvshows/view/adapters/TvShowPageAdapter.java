package com.example.mytvshows.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytvshows.R;
import com.example.mytvshows.model.Show;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TvShowPageAdapter extends RecyclerView.Adapter<TvShowPageAdapter.TvShowPageViewHolder> {

    ArrayList<Show> shows;

    public TvShowPageAdapter(ArrayList<Show> shows){
        this.shows = shows;
    }

    @NonNull
    @Override
    public TvShowPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tv_show_item, parent, false);
        return new TvShowPageAdapter.TvShowPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowPageViewHolder holder, int position) {
        Show currentShow = shows.get(position);
        holder.tv_item_name.setText(currentShow.getName());
        Picasso.get().load(currentShow.getImage_thumbnail_path()).into(holder.iv_show_image);
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public static class TvShowPageViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_show_image;
        TextView tv_item_name;
        public TvShowPageViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_show_image = itemView.findViewById(R.id.iv_show_image);
            tv_item_name = itemView.findViewById(R.id.tv_item_name);
        }
    }

}
