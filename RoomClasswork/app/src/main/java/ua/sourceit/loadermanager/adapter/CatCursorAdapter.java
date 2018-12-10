package ua.sourceit.loadermanager.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import ua.sourceit.loadermanager.R;
import ua.sourceit.loadermanager.model.Cat;

public class CatCursorAdapter extends CursorAdapter {

    private LayoutInflater layoutInflater;

    public CatCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.item_view, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
        int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGR));
        String breed = cursor.getString(cursor.getColumnIndex(Cat.COLUNM_BREED));

        TextView tvName = view.findViewById(R.id.textViewName);
        TextView tvAge = view.findViewById(R.id.textViewAge);
        TextView tvBreed = view.findViewById(R.id.textViewBreed);

        tvName.setText(name);
        tvAge.setText(String.valueOf(age));
        tvBreed.setText(breed);
    }
}
