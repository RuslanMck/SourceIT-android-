package ua.sourceit.dbcats.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ua.sourceit.dbcats.model.Cat;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Cats.db";
    public static final int DATABASE_VERSION = 1;

    private static final String EXEC_SQL = String .format("create table %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEST)",
            Cat.TABLE_NAME, Cat._ID, Cat.COLUMN_NAME, Cat.COLUMN_AGE, Cat.COLUMN_BREED);

    public DatabaseHelper(Context context) {
        super(context, "Cats.db", null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EXEC_SQL);
    }
}

