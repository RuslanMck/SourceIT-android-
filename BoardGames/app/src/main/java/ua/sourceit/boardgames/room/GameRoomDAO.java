package ua.sourceit.boardgames.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ua.sourceit.boardgames.model.Game;

@Dao
public interface GameRoomDAO {

    @Query("select * from Game")
    List<Game> getAll();

    @Insert
    void insertGame (Game game);
}
