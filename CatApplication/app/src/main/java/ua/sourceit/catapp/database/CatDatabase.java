package ua.sourceit.catapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import ua.sourceit.catapp.model.Cat;

public class CatDatabase implements CatDao {

    private DBHelper dbHelper;
    private Context context;

    public CatDatabase(DBHelper dbHelper) {
        this.dbHelper = dbHelper;

        dbHelper = new DBHelper(context);
    }

    @Override
    public Cursor getAll() {
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(Cat.TABLE_NAME, null, null, null, null, null, null);

        return cursor;
    }

    @Override
    public void insertCat(Cat cat) {
        ContentValues values = new ContentValues();
        values.put(Cat.COLUMN_NAME, cat.getName());
        values.put(Cat.COLUMN_AGE, cat.getAge());
        values.put(Cat.COLUMN_BREED, cat.getBreed());
        values.put(Cat.COLUMN_IMGURL, cat.getImgUrl());
        values.put(Cat.COLUMN_DESCRIPTION, cat.getDescription());

        SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
        writableDatabase.insert(Cat.TABLE_NAME, null, values);
    }

    @Override
    public Cat getCat(int catId) {
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(Cat.TABLE_NAME, new String[] {Cat.COLUMN_ID}, "catId = ?", new String[] {String.valueOf(catId)},
                null, null, null);

        Cat cat = new Cat();

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            int count = cursor.getCount();

            for (int i = 0; i < count; i++) {
                int id = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_ID));
                int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGE));
                String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
                String breed = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_BREED));
                String imgUrl = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_IMGURL));
                String description = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_DESCRIPTION));

                cat.setId(id);
                cat.setName(name);
                cat.setAge(age);
                cat.setBreed(breed);
                cat.setImgUrl(imgUrl);
                cat.setDescription(description);
            }
            cursor.close();
        }
        return cat;
    }
}
