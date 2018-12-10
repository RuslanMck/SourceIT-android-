package ua.sourceit.catapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import ua.sourceit.catapp.model.Cat;
import ua.sourceit.catapplication.R;
import ua.sourceit.catapplication.databinding.ViewItemBinding;

/** CatAdapter будет обращаться к базе данных, которая будет находиться на устройстве,
 *  получать один элемент и передавать его во view_item - один элемент из нащего списка**/

public class CatAdapter extends CursorAdapter {

    OnCatClickListener listener;

    public CatAdapter(Context context, Cursor c, boolean autoRequery, OnCatClickListener clickListener) {
        super(context, c, autoRequery);
        listener = clickListener;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup ViewGroup) {

        /**ViewItemBinding название нашего файла view_item.xml
         * Обращаемся к классу DataBindingUtil и вызываем у него метод inflate в котором указываем inflater - переводит xml файлы во view, **/

        ViewItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_item, ViewGroup, false);
        return binding.getRoot();
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        /** bindView будет полученные данные записывать в экземпляр класса Cat и выводить его во view
         * Конвертирует из Курсора в Кота **/

        ViewItemBinding binding = DataBindingUtil.bind(view);

        /** Курсор проходит и получает из колонки (Cat.COLUMN_NAME) мы получаем данные из курсора (cursor.getString)
         *  и записываем их в переменную (name) **/
        int id = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_ID));
        int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGE));
        String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
        String breed = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_BREED));
        String imgUrl = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_IMGURL));
        String description = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_DESCRIPTION));

        final Cat cat = new Cat();
        cat.setId(id);
        cat.setAge(age);
        cat.setName(name);
        cat.setBreed(breed);
        cat.setImgUrl(imgUrl);
        cat.setDescription(description);

        binding.setCat(cat);

        /** Когда мы будем кликать по вью, мы будем обращаться к нашему созданному OnCatClickListener, а сам listener будет выводить нам кота**/

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onCatClick(cat);
                }
            }
        });
    }
}
