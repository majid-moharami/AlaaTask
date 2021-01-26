package com.example.alaatask.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "set_table")
public class Sets {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private int mId;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String mTitle;


    @ColumnInfo(name = "short_title")
    @SerializedName("short_title")
    @Expose
    private String mShortTitle;

    public Sets() {
    }

    public Sets(String title, String shortTitle) {
        mTitle = title;
        mShortTitle = shortTitle;
    }

    public Sets(int id, String title, String shortTitle) {
        mId = id;
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

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
