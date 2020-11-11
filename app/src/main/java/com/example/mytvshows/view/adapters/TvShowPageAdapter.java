package com.example.mytvshows.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytvshows.R;
import com.example.mytvshows.interfaces.clicklistener.ClickListener;
import com.example.mytvshows.model.TVShowPage.Show;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TvShowPageAdapter extends RecyclerView.Adapter<TvShowPageAdapter.TvShowPageViewHolder> {

    ArrayList<Show> shows;
    ClickListener<Show> clickListener;

    public TvShowPageAdapter(ArrayList<Show> shows, ClickListener<Show> clickListener){
        this.shows = shows;
        this.clickListener = clickListener;
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
        holder.cl_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick(currentShow, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public static class TvShowPageViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout cl_item_layout;
        ImageView iv_show_image;
        TextView tv_item_name;
        public TvShowPageViewHolder(@NonNull View itemView) {
            super(itemView);
            cl_item_layout = itemView.findViewById(R.id.cl_item_layout);
            iv_show_image = itemView.findViewById(R.id.iv_show_image);
            tv_item_name = itemView.findViewById(R.id.tv_item_name);
        }
    }

}
