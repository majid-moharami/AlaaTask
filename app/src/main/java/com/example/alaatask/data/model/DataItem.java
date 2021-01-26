package com.example.alaatask.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataItem {
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("sets")
    @Expose
    private List<Sets> mSets;

    public DataItem() {
    }

    public DataItem(int id, List<Sets> sets) {
        mId = id;
        mSets = sets;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public List<Sets> getSets() {
        return mSets;
    }

    public void setSets(List<Sets> sets) {
        mSets = sets;
    }
}
