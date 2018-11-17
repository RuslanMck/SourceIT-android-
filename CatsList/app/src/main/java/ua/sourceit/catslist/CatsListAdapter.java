package ua.sourceit.catslist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

//public class CatsListAdapter extends BaseAdapter{
//
//    private Context mContext;
//    private List<Cats> mCatsList;
//
//    public CatsListAdapter(Context mContext, List<Cats> mCats) {
//        this.mContext = mContext;
//        this.mCatsList = mCats;
//    }
//
//    @Override
//    public int getCount() {
//        return mCatsList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mCatsList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        @SuppressLint("ViewHolder") View view = View.inflate(mContext, R.layout.cats_list, null);
//        TextView tvName = (TextView)view.findViewById(R.id.tv_name);
//        TextView tvAge = (TextView)view.findViewById(R.id.tv_age);
//        TextView tvBreed = (TextView)view.findViewById(R.id.tv_breed);
//
//        tvName.setText(mCatsList.get(position).getName());
//        tvAge.setText(String.valueOf(mCatsList.get(position).getAge())+ "years");
//        tvBreed.setText(mCatsList.get(position).getName());
//
//        return null;
//    }
//}

public class CatsListAdapter extends ArrayAdapter<String> {

    private LayoutInflater layoutInflater;
    private List<Cats> catsList;

    public CatsListAdapter(int resource, @NonNull Context context, @NonNull List<Cats> cats){
        super(context, resource);
        this.catsList = cats;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View view;

        if (convertView == null){
            view = layoutInflater.inflate(R.layout.cats_list, parent);
            Log.i("-----", String.format("Inflate view for position %d", position));
        } else {
            view = convertView;
        }
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvAge = view.findViewById(R.id.tv_age);
        TextView tvBreed = view.findViewById(R.id.tv_breed);

        tvName.setText(catsList.get(position).getName());
        tvAge.setText(String.valueOf(catsList.get(position).getAge() + " years, "));
        tvBreed.setText(catsList.get(position).getBreed());

        return view;
    }
}
