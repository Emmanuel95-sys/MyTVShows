package com.example.mytvshows.model.TVShowDetails;

import com.google.gson.annotations.SerializedName;


public class TvShow {

    private Long id;
    private String name;
    private String permalink;
    private String url;
    private String description;
    private String description_source;
    private String start_date;
    private String end_date;
    private String country;
    private String status;
    private int runtime;
    private String network;
    private String youtube_link;
    private String image_path;
    private String image_thumbnail_path;
    private String rating;
    private String rating_count;
//    private String countdown;
//    private String [] genres;
//    private String [] episodes;
//    private String [] pictures;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription_source() {
        return description_source;
    }

    public void setDescription_source(String description_source) {
        this.description_source = description_source;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getYoutube_link() {
        return youtube_link;
    }

    public void setYoutube_link(String youtube_link) {
        this.youtube_link = youtube_link;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getImage_thumbnail_path() {
        return image_thumbnail_path;
    }

    public void setImage_thumbnail_path(String image_thumbnail_path) {
        this.image_thumbnail_path = image_thumbnail_path;
    }

    public String getRating_count() {
        return rating_count;
    }

    public void setRating_count(String rating_count) {
        this.rating_count = rating_count;
    }

//    public String getCountdown() {
//        return countdown;
//    }
//
//    public void setCountdown(String countdown) {
//        this.countdown = countdown;
//    }

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

//    public String[] getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(String[] pictures) {
//        this.pictures = pictures;
//    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

//    public String[] getGenres() {
//        return genres;
//    }
//
//    public void setGenres(String[] genres) {
//        this.genres = genres;
//    }
//
//    public String[] getEpisodes() {
//        return episodes;
//    }
//
//    public void setEpisodes(String[] episodes) {
//        this.episodes = episodes;
//    }

}
