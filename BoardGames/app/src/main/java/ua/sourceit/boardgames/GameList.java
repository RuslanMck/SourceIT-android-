package ua.sourceit.boardgames;

import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import ua.sourceit.boardgames.adapter.GameListCursorAdapter;
import ua.sourceit.boardgames.database.GameRoomDB;
import ua.sourceit.boardgames.databinding.ActivityGameListBinding;
import ua.sourceit.boardgames.model.Game;

public class GameList extends AppCompatActivity {

    GameRoomDB gameRoomDB;
    ActivityGameListBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game_list);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_list);

        gameRoomDB = Room.databaseBuilder(this, GameRoomDB.class, "game.db").allowMainThreadQueries().build();



        List<Game> gameList = gameRoomDB.gameDao().getAll();

        Game game = new Game(1, "domino", R.drawable.domino);

        gameList.add(game);

        if (gameList != null){
            Game game1 = gameList.get(gameList.size());
            mBinding.setGame(game1);
        }

        // для добавления игры нужно сделать arrayAdapter
        final ListView listView = findViewById(R.id.lw_game_list);
        final GameListCursorAdapter cursorAdapter = new GameListCursorAdapter(this, );

        listView.setAdapter(cursorAdapter);

    }
}
