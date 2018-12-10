package ua.sourceit.loadermanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ua.sourceit.loadermanager.model.Cat;

public class DBCatDAOImpl implements CatDataAccessObject {

    private DatabaseHelper databaseHelper;
    private Context context;

    public DBCatDAOImpl(Context context) {
        this.context = context;

        databaseHelper = new DatabaseHelper(context);
    }

    @Override
    public boolean insertCat(Cat cat) {
        ContentValues values = new ContentValues();
        values.put(Cat.COLUMN_NAME, cat.getName());
        values.put(Cat.COLUMN_AGR, cat.getAge());
        values.put(Cat.COLUMN_BREED, cat.getBreed());

        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        long result = writableDatabase.insert(Cat.TABLE_NAME, null, values);

        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Cat> getAll() {
        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(Cat.TABLE_NAME, null,null,null,null,null,null);

        List<Cat> catList = new ArrayList<>();

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            int count = cursor.getCount();

            for (int i = 0; i < count; i++){
                String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGR));
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
    public int getSize() {
        List<Cat> cats = getAll();
        if (cats != null){
            return cats.size();
        } else {
            return 0;
        }
    }

    @Override
    public Cursor getCursorAll() {
        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(Cat.TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }
}
