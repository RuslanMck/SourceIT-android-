package android.sourceit.sourceitsample.lesson4DatabaseSQLite.adapter;

import android.content.Context;
import android.database.Cursor;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.provider.ContactsContract;
import android.sourceit.sourceitsample.R;
import android.sourceit.sourceitsample.databinding.ItemContactBinding;
import android.sourceit.sourceitsample.model.Cat;
import android.sourceit.sourceitsample.model.UserContact;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ruslan Ivakhnenko on 23.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class CatCursorAdapter extends CursorAdapter {

    private LayoutInflater layoutInflater;

    public CatCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        layoutInflater = LayoutInflater.from(context);
    }

    /**Логика создания такая же как и в создании ArrayAdapter который делали для котов.
     * Только в двух методах и не нужно создавать if для проверки на null **/

    @Override
    /** Создает вью **/
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.item_db_cat, viewGroup, false);
//        ItemContactBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_contact, viewGroup, false);
//        return binding.getRoot();
    }

    @Override
    /** Заполняет новый вью созданные в newView**/
    public void bindView(View view, Context context, Cursor cursor) {
//        ItemContactBinding binding = DataBindingUtil.bind(view);
        String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
        int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGE));
        String breed = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_BREED));
        TextView tvName = view.findViewById(R.id.textViewName);
        TextView tvAge = view.findViewById(R.id.textViewAge);
        TextView tvBreed = view.findViewById(R.id.textViewBreed);

        tvName.setText(name);
        tvAge.setText(String.valueOf(age));
        tvBreed.setText(breed);
    }

    /**НА данном этапе не использается **/

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView, String imageUri){
        if (imageUri != null) {
            imageView.setImageURI(Uri.parse(imageUri));
        } else {
            imageView.setImageURI(null);
        }
    }
}
