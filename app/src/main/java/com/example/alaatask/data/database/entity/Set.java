package com.example.alaatask.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(tableName = "set_table")
public class Set {
    @ColumnInfo(name = "title")
    private String mTitle;
    @ColumnInfo(name = "short_title")
    private String mShortTitle;

    @Ignore
    public Set(String title, String shortTitle) {
        mTitle = title;
        mShortTitle = shortTitle;
    }

    public Set() {
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
