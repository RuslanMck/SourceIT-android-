package ua.sourceit.dbcats.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ua.sourceit.dbcats.model.Cat;

public class DBCatDAOImpl implements CatDataAccessObject {

    private DatabaseHelper databaseHelper;
    private Context context;

    public DBCatDAOImpl(Context context){
        this.context = context;

        databaseHelper = new DatabaseHelper(context);
    }

    @Override
    public void insertCat(Cat cat) {
        ContentValues values = new ContentValues();
        values.put(Cat.COLUMN_NAME, cat.getName());
        values.put(Cat.COLUMN_AGE, cat.getAge());
        values.put(Cat.COLUMN_BREED, cat.getBreed());

        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        writableDatabase.insert(Cat.TABLE_NAME, null, values);
    }

    @Override
    public List<Cat> getAll() {
        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(Cat.TABLE_NAME,null, null, null, null, null,null);

        List<Cat> catList = new ArrayList<>();

        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();

            int count = cursor.getCount();
            for (int i = 0; i < count; i++){
                String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGE));
                String breed = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_BREED));

                Cat cat = new Cat(name, age, breed);
                catList.add(cat);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return null;
    }
}
