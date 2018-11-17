package ua.sourceit.listofcats;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CatsListAdapter extends ArrayAdapter<Cats> {
    private LayoutInflater layoutInflater;

    public CatsListAdapter(int resource, @NonNull Context context, @NonNull List<Cats> cats){
        super(context, resource, 0, cats);

        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){

        View view;

        if (convertView == null){
            view = layoutInflater.inflate(R.layout.cats_list, parent,false);
            Log.i("-----", String.format("Inflate view for position %d", position));
        } else {
            view = convertView;
        }

        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvAge = view.findViewById(R.id.tv_age);
        TextView tvBreed = view.findViewById(R.id.tv_breed);

        tvName.setText(getItem(position).getName()+ ", ");
        tvAge.setText(String.valueOf(getItem(position).getAge() + " years, "));
        tvBreed.setText(getItem(position).getBreed());

        return view;
    }
}
