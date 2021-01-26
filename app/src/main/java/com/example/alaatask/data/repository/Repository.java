package com.example.alaatask.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.alaatask.data.database.dao.SetsItemDao;
import com.example.alaatask.data.database.database.SetDatabase;
import com.example.alaatask.data.database.entity.Set;

import java.util.List;

public class Repository {
    private static Repository mRepositoryInstance;
    private SetsItemDao mDao;
    private Context mContext;

    public static synchronized Repository getInstance(Context context){
        if (mRepositoryInstance == null)
            mRepositoryInstance = new Repository(context);
        return mRepositoryInstance;
    }

    private Repository(Context context) {
        mContext = context;
        SetDatabase setDatabase = SetDatabase.getDataBase(mContext);
        mDao = setDatabase.getSetDAO();
    }

    public LiveData<List<Set>> getSetsLiveData(){
        return mDao.getSets();
    }

    public LiveData<Set> getSetLiveData(String title){
        return mDao.getSet(title);
    }

    public void  insertSet(Set set){
        SetDatabase.dataBaseWriteExecutor.execute(() -> mDao.insertSet(set));
    }

    public void insetSets(List<Set> sets){
        SetDatabase.dataBaseWriteExecutor.execute(() -> mDao.insertSet(sets.toArray(new Set[]{})));
    }
    public void updateCrime(Set set) {
        SetDatabase.dataBaseWriteExecutor.execute(() -> mDao.updateSet(set));
    }

    public void deleteCrime(Set set) {
        SetDatabase.dataBaseWriteExecutor.execute(() -> mDao.deleteSet(set));
    }

}
