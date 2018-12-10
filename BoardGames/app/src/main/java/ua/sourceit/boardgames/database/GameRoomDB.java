package ua.sourceit.boardgames.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ua.sourceit.boardgames.model.Game;
import ua.sourceit.boardgames.room.GameRoomDAO;

@Database(entities = Game.class, version = 1)
public abstract class GameRoomDB extends RoomDatabase {
    public abstract GameRoomDAO gameDao();
}
