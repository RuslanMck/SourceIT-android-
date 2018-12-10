package ua.sourceit.dbcatssecond.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ua.sourceit.dbcatssecond.R;
import ua.sourceit.dbcatssecond.model.Cat;

public class    CatListAdapter extends ArrayAdapter<Cat> {
    LayoutInflater layoutInflater;

    public CatListAdapter(Context context, List<Cat> catList) {
        super(context, 0, catList);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null){
            view = layoutInflater.inflate(R.layout.view_item, parent, false);
        } else {
            view = convertView;
        }
        Cat cat = getItem(position);

        TextView name = view.findViewById(R.id.textViewName);
        TextView age = view.findViewById(R.id.textViewAge);
        TextView breed = view.findViewById(R.id.textViewBreed);

        name.setText(cat.getName());
        age.setText(String.valueOf(cat.getAge()));
        breed.setText(cat.getBreed());
        return view;
    }
}
