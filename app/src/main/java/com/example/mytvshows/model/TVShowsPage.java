package com.example.mytvshows.model;

import java.util.ArrayList;

public class TVShowsPage {
    private String total = "";
    private int page;
    private int pages;
    private ArrayList<Show> tv_shows;
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public ArrayList<Show> getShows() {
        return tv_shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.tv_shows = shows;
    }
}
