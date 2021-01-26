package com.example.alaatask.data.database.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.alaatask.data.database.dao.SetsItemDao;
import com.example.alaatask.data.database.entity.Set;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {Set.class},
        version = 1,
        exportSchema = false)
public abstract class SetDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "AlaaTv.db";
    public static ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(4);

    public abstract SetsItemDao getSetDAO();

    public static SetDatabase getDataBase(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                SetDatabase.class,
                SetDatabase.DATABASE_NAME).allowMainThreadQueries().build();
    }
}
