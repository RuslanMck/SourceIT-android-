package android.sourceit.sourceitsample.lesson4DatabaseSQLite.adapter;

import android.content.Context;
import android.database.Cursor;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.provider.ContactsContract;
import android.sourceit.sourceitsample.R;
import android.sourceit.sourceitsample.databinding.ItemContactBinding;
import android.sourceit.sourceitsample.model.UserContact;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Ruslan Ivakhnenko on 23.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class CatCursorBindingAdapter extends CursorAdapter {

    private LayoutInflater layoutInflater;

    public CatCursorBindingAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        ItemContactBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_contact, viewGroup, false);
        return binding.getRoot();
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ItemContactBinding binding = DataBindingUtil.bind(view);
        String[] columnNames = cursor.getColumnNames();
        UserContact userContact = new UserContact();
        Cursor phoneCursor = context.getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                new String[]{cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))}, null);
        if (phoneCursor != null && phoneCursor.getCount() > 0 && phoneCursor.moveToFirst()){
            String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            userContact.setPhone(phoneNumber);
        }
        phoneCursor.close();
        userContact.setName(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
        userContact.setAddress(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID)));
        userContact.setImageUrl(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI)));
        userContact.setStarred(cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.STARRED)) == 1 ? true : false);
        binding.setUser(userContact);

    }

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView, String imageUri){
        if (imageUri != null) {
            imageView.setImageURI(Uri.parse(imageUri));
        } else {
            imageView.setImageURI(null);
        }
    }
}
