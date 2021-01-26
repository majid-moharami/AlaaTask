package com.example.alaatask.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("data")
    @Expose
    private List<DataItem> mData;

    public Data() {
    }

    public Data(List<DataItem> data) {
        mData = data;
    }

    public List<DataItem> getData() {
        return mData;
    }

    public void setData(List<DataItem> data) {
        mData = data;
    }
}
