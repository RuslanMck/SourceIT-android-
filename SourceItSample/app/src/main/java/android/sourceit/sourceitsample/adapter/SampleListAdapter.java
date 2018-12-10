package android.sourceit.sourceitsample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ruslan Ivakhnenko on 12.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class SampleListAdapter extends ArrayAdapter<String> {

    private LayoutInflater layoutInflater;



    public SampleListAdapter(@NonNull Context context,
                             int resource,
                             @NonNull List<String> objects) {
        super(context, resource, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        View view;
        if (convertView == null){
            view = layoutInflater.inflate(android.R.layout.simple_list_item_1,
                    parent,
                    false);
            Log.i("-----",
                    String.format("Inflate view for position %d", position));
        } else {
            view = convertView;
        }

        TextView tv = view.findViewById(android.R.id.text1);
        String item = getItem(position);
        tv.setText(item);
        return view;
    }

//    @Override
//    public int getCount() {
//        Log.i("-----", "getCount()");
//        return super.getCount();
//    }
//
//    @Nullable
//    @Override
//    public String getItem(int position) {
//        Log.i("-----", "getItem()");
//        return super.getItem(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        Log.i("-----", "getItemId");
//        return super.getItemId(position);
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        Log.i("-----", "getItemViewType()");
//        return super.getItemViewType(position);
//    }
}