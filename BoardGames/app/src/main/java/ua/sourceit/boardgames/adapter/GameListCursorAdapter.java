package ua.sourceit.boardgames.adapter;

import android.content.Context;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ua.sourceit.boardgames.R;
import ua.sourceit.boardgames.databinding.GamelistItemViewBinding;
import ua.sourceit.boardgames.model.Game;

public class GameListCursorAdapter extends CursorAdapter {

    private LayoutInflater layoutInflater;

    public GameListCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        GamelistItemViewBinding binding =  DataBindingUtil.inflate(layoutInflater, R.layout.gamelist_item_view, viewGroup, false);
        return DataBindingUtil.inflate(layoutInflater, R.layout.gamelist_item_view, viewGroup, false).getRoot();
//        return layoutInflater.inflate(R.layout.gamelist_item_view, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        GamelistItemViewBinding binding = DataBindingUtil.bind(view);
        String name = cursor.getString(cursor.getColumnIndex(Game.COLUMN_NAME));
        int img = cursor.getInt(cursor.getColumnIndex(Game.COLUMN_IMGURL));
//        Game game = new Game(1, name, img);
//        binding.setGame(game);

        TextView tvName = view.findViewById(R.id.tvGameName);
        ImageView ivGame = view.findViewById(R.id.ivGameImg);

        tvName.setText(name);
        ivGame.setImageResource(img);
    }
}
