package android.sourceit.sourceitsample.lesson4DatabaseSQLite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.sourceit.sourceitsample.model.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslan Ivakhnenko on 23.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class DatabaseCatDaoImpl implements CatDao {

    private DatabaseHelper databaseHelper;

    private Context context;

    public DatabaseCatDaoImpl(Context context){
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
        Cursor cursor = readableDatabase.query(Cat.TABLE_NAME,
                null, null, null, null,
                null, null);

        List<Cat> catList = new ArrayList<>();
        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i ++){
                String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGE));
                String breed = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_BREED));
                Cat cat = new Cat(name, age, breed);
                catList.add(cat);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return catList;
    }

    @Override
    public Cursor getCursorAll() {
        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(Cat.TABLE_NAME,
                null, null, null, null,
                null, null);
        return cursor;
    }
}
