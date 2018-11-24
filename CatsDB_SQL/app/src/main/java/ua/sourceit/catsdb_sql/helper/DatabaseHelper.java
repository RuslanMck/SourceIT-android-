package ua.sourceit.catsdb_sql.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ua.sourceit.catsdb_sql.model.Cat;

public class DatabaseHelper extends SQLiteOpenHelper {

    /** Мы создаем класс DatabaseHelper в котором создаем базу данный, таблицу с колонками в ней.
     *  Создаем поля название базы данных и версию **/


    public static final String DATABESE_NAME = "cat.db";
    public static final int DATABASE_VERSION = 1;

    /** Создаем форматированныую строку %s - соотвествует заданным после запятой параметрам; первый %s = Cat.TABLE_NAME, второй %s = Cat._ID
     * EXEC_SQL - мы задаем параметры базы данных (таблицы). Первый столбец будет Cat.TABLE_NAME, аторой - Cat._ID  **/

    private static final String EXEC_SQL = String.format("create table %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEXT)",
            Cat.TABLE_NAME, Cat._ID, Cat.COLUMN_NAME, Cat.COLUMN_AGE, Cat.COLUMN_BREED);

    /** factory всегда null **/

    public DatabaseHelper(Context context) {
        super(context,"cat.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EXEC_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
