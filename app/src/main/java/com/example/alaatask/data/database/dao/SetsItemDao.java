package com.example.alaatask.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.alaatask.data.model.Sets;

import java.util.List;

@Dao
public interface SetsItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSet(Sets... sets);

    @Update
    void updateSet(Sets... sets);

    @Delete
    void deleteSet(Sets... sets);

    @Query("select * from set_table")
    LiveData<List<Sets>> getSets();

    @Query("select * from SET_TABLE where title = :titles")
    LiveData<Sets> getSet(String titles);
}
