package ua.sourceit.catapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ua.sourceit.catapp.model.Cat;

@Database(entities = {Cat.class}, version = 1)
public abstract class CatRoomDB extends RoomDatabase {
    public abstract CatDao catDao();
}
