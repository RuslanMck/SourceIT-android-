package android.sourceit.sourceitsample.adapter;

import android.content.Context;
import android.sourceit.sourceitsample.R;
import android.sourceit.sourceitsample.model.Cat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ruslan Ivakhnenko on 16.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class CatListAdapter extends ArrayAdapter<Cat> {

    private LayoutInflater layoutInflater;


    public CatListAdapter(Context context, List<Cat> catList){
        super(context, 0, catList);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;

        if (convertView ==null){
            view = layoutInflater.inflate(R.layout.item_cat,parent,false);
        } else {
            view = convertView;
        }

        Cat cat = getItem(position);

        TextView tvName = view.findViewById(R.id.textViewName);
        TextView tvAge = view.findViewById(R.id.textViewAge);
        TextView tvBreed = view.findViewById(R.id.textViewBeed);

        tvName.setText(cat.getName());
        tvAge.setText(String.valueOf(cat.getAge()));
        tvBreed.setText(cat.getBreed());

        return view;

    }

}
