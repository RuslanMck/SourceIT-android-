package ua.sourceit.catsdb_sql.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;

import ua.sourceit.catsdb_sql.R;
import ua.sourceit.catsdb_sql.model.Cat;

public class CatListAdapter extends ArrayAdapter<Cat> {

    private LayoutInflater layoutInflater;

    public CatListAdapter(Context context, List<Cat> catList) {
        super(context,0,catList);

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.view_item, parent, false);
        } else {
            view = convertView;
        }
        return view;
    }
}

