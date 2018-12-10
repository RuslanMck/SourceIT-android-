package ua.sourceit.catapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ua.sourceit.catapp.model.Cat;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Cats.db";
    public static final int DATABASE_VERSION = 1;

    private static final String EXEC_SQL = String.format("create table %s(%s INTEGER PRIMARY KEY AUTOINCREMENT,% INTEGER," +
            "%TEXT, %TEXT, %TEXT, %TEXT)", Cat.TABLE_NAME, Cat.COLUMN_ID, Cat.COLUMN_AGE, Cat.COLUMN_NAME, Cat.COLUMN_BREED,
            Cat.COLUMN_IMGURL, Cat.COLUMN_DESCRIPTION);

    public DBHelper(Context context){
        super(context, "Cats.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EXEC_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
