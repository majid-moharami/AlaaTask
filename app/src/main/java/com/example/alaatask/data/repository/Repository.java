package com.example.alaatask.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.alaatask.data.database.dao.SetsItemDao;
import com.example.alaatask.data.database.database.SetDatabase;
import com.example.alaatask.data.model.Sets;

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

    public LiveData<List<Sets>> getSetsLiveData(){
        return mDao.getSets();
    }

    public LiveData<Sets> getSetLiveData(String title){
        return mDao.getSet(title);
    }

    public void  insertSet(Sets set){
        SetDatabase.dataBaseWriteExecutor.execute(() -> mDao.insertSet(set));
    }

    public void insetSets(List<Sets> sets){
        SetDatabase.dataBaseWriteExecutor.execute(() -> mDao.insertSet(sets.toArray(new Sets[]{})));
    }
    public void updateCrime(Sets sets) {
        SetDatabase.dataBaseWriteExecutor.execute(() -> mDao.updateSet(sets));
    }

    public void deleteCrime(Sets set) {
        SetDatabase.dataBaseWriteExecutor.execute(() -> mDao.deleteSet(set));
    }

}
