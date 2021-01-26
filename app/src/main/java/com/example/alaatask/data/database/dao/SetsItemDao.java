package com.example.alaatask.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.alaatask.data.database.entity.Set;

import java.util.List;

@Dao
public interface SetsItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSet(Set... sets);

    @Update
    void updateSet(Set... sets);

    @Delete
    void deleteSet(Set... sets);

    @Query("select * from set_table")
    LiveData<List<Set>> getSets();

    @Query("select * from SET_TABLE where title = :titles")
    LiveData<Set> getSet(String titles);
}
