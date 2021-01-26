package com.example.alaatask.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sets {
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("short_title")
    @Expose
    private String mShortTitle;

    public Sets() {
    }

    public Sets(String title, String shortTitle) {
        mTitle = title;
        mShortTitle = shortTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getShortTitle() {
        return mShortTitle;
    }

    public void setShortTitle(String shortTitle) {
        mShortTitle = shortTitle;
    }
}
