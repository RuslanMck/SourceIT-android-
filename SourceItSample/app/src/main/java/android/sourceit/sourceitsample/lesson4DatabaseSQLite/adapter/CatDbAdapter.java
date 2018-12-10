package android.sourceit.sourceitsample.lesson4DatabaseSQLite.adapter;

import android.content.Context;
import android.sourceit.sourceitsample.R;
import android.sourceit.sourceitsample.model.Cat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Ruslan Ivakhnenko on 26.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class CatDbAdapter extends ArrayAdapter<Cat> {

    LayoutInflater layoutInflater;

    public CatDbAdapter(@NonNull Context context, @NonNull List<Cat> objects) {
        super(context, 0, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null){
            view = layoutInflater.inflate(R.layout.item_db_cat, parent, false);
        } else {
            view = convertView;
        }

        TextView tvName = view.findViewById(R.id.textViewName);
        TextView tvAge = view.findViewById(R.id.textViewAge);
        TextView tvBreed = view.findViewById(R.id.textViewBreed);
        Cat item = getItem(position);
        tvName.setText(item.getName());
        tvAge.setText(String.valueOf(item.getAge()));
        tvBreed.setText(item.getBreed());
        return view;
    }
}
