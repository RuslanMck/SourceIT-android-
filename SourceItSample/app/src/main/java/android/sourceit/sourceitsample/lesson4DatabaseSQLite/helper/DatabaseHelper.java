package android.sourceit.sourceitsample.lesson4DatabaseSQLite.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.sourceit.sourceitsample.model.Cat;
import android.support.annotation.Nullable;

/**
 * Created by Ruslan Ivakhnenko on 23.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "cat.db";

    private static final String EXEC_SQL =
    String.format
    ("create table %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEXT)",
            Cat.TABLE_NAME, Cat._ID, Cat.COLUMN_NAME, Cat.COLUMN_AGE, Cat.COLUMN_BREED);

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EXEC_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
