package com.example.alaatask.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.alaatask.data.model.Data;
import com.example.alaatask.data.model.DataItem;
import com.example.alaatask.data.model.Sets;
import com.example.alaatask.data.repository.Repository;
import com.example.alaatask.network.AlaaTvApi;
import com.example.alaatask.network.RetrofitInstance;
import com.example.alaatask.utils.CheckingNetWork;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListFragmentViewModel extends AndroidViewModel {
    private Retrofit mRetrofit = RetrofitInstance.getRetrofitInstance();
    private AlaaTvApi mTvApi;
    private MutableLiveData<List<Sets>> mSetsMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Sets>> mSetsMutableLiveDataOffline = new MutableLiveData<>();
    private Repository mRepository = Repository.getInstance(getApplication());

    @Inject
    public ListFragmentViewModel(@NonNull Application application) {
        super(application);
        requestForData();
    }


    public void requestForData(){
        if (CheckingNetWork.isNetworkAvailable(getApplication())) {
            mTvApi = mRetrofit.create(AlaaTvApi.class);
            Call<Data> Call;

            Call = mTvApi.getAllData();
            Call.enqueue(new Callback<Data>() {
                @Override
                public void onResponse(retrofit2.Call<Data> call, Response<Data> response) {
                    if (response.isSuccessful()) {
                        Log.d("MAJID", "Successful");
                        List<Sets> setsList = new ArrayList<>();
                        List<DataItem> dataItems = response.body().getData();
                        for (int i = 0; i < dataItems.size(); i++) {
                            if (dataItems.get(i).getSets() != null) {
                                setsList.addAll(dataItems.get(i).getSets());
                            }
                        }
                        mSetsMutableLiveData.setValue(setsList);
                        mRepository.insetSets(setsList);
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<Data> call, Throwable t) {
                    Log.d("MAJID", "NotSuccessful", t);
                }
            });
        }else {
          mRepository.getSetsLiveData().getValue();
        }
    }

    public LiveData<List<Sets>> getDatabaseSets() {
        return mRepository.getSetsLiveData();
    }

    public Sets getSets(int position){
        return mSetsMutableLiveData.getValue().get(position);
    }

    public void setValueLiveData(List<Sets> sets){
        mSetsMutableLiveData.setValue(sets);
    }
    public LiveData<List<Sets>> getSetsMutableLiveData() {
       return mSetsMutableLiveData;
    }

    public MutableLiveData<List<Sets>> getSetsMutableLiveDataOffline() {
        return mSetsMutableLiveDataOffline;
    }
}
