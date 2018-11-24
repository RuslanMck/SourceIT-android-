package ua.sourceit.listofcats.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CatListAdapter extends ArrayAdapter<Cat> {

    private LayoutInflater layoutInflater;
    /** context указываем что мы даем разрешение на использование других ресурсов таких как цвет, размер и т.д.
     * Передаем методу CatListAdapter список котов List<Cat> catList**/
    public CatListAdapter(Context context, List<Cat> catList) {

        super(context, 0, catList);
        /** .from метод LayoutInflater'а. context обозначает что он получает возможность изменять параметры внешнего вида при создании **/
        layoutInflater = LayoutInflater.from(context);
    }
    /** Мы переопределяем getView поэтоу передаваемые параметры нужно указать родительские.
     * position отвечает за позицию в создаввемом списке. convertView используется для переиспользования созданного view **/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_cat, parent, false);
        } else {
            view = convertView;
        }
        Cat cat = getItem(position);

        TextView tvName = view.findViewById(R.id.textViewName);
        TextView tvAge = view.findViewById(R.id.textViewAge);
        TextView tvBreed = view.findViewById(R.id.textViewBreed);

        tvName.setText(cat.getName() + ", ");
        tvAge.setText(String.valueOf(cat.getAge() + " years, "));
        tvBreed.setText(cat.getBreed());

        return view;
    } {
}
