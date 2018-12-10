package ua.sourceit.loadermanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ua.sourceit.loadermanager.model.Cat;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Cats.db";
    public static final int DATABASE_VERSION = 1;

    private static final String EXEC_SQL = String.format("create table %s (%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER, %s TEXT)",
            Cat.TABLE_NAME, Cat._ID, Cat.COLUMN_NAME, Cat.COLUMN_AGR, Cat.COLUNM_BREED);

    public DatabaseHelper(Context context) {
        super(context, "Cat.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EXEC_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
