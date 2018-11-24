package ua.sourceit.catsdb_sql.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ua.sourceit.catsdb_sql.model.Cat;

public class DatabaseCatDaoImlp implements CatDao {

    /**DatabaseCatDaoImlp класс для доспупа к базе данных, получения данных и записи данных **/

    private DatabaseHelper databaseHelper;

    private  Context context;

    public DatabaseCatDaoImlp(Context context){
        this.context = context;

        databaseHelper = new DatabaseHelper(context);
    }

    @Override
    public void insertCat(Cat cat) {

        /** класс ContentValues используется для заполнения колонки  **/

        ContentValues values = new ContentValues();

        /** Первый параметр - название колонки которую мы хотим заполнить Cat.COLUMN_NAME
         * Второй параметр - то чем мы будем заполнять эту кролонку cat.getName **/

        values.put(Cat.COLUMN_NAME, cat.getName());
        values.put(Cat.COLUMN_AGE, cat.getAge());
        values.put(Cat.COLUMN_BREED, cat.getBreed());

        /** создаем экземпляр метода writableDatabase и  получаем ссылку на нашу базу данных чтобы записать в нее данные **/

        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();

        /** используем метод insert, у которого два параметра (название таблицы, второй всегда null,
         * третий - ContentValues values = new ContentValues(); **/

        writableDatabase.insert(Cat.TABLE_NAME, null, values);
    }

    @Override
    public List<Cat> getAll() {

        /** Метод будет выдавать нам всю базу данных. Мы указываем null везде кроме имени таблицы, так как у нас нет специальных параметров выбора.
         * При таких условиях нам выведется вся таблица полностью **/

        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();

        /**Создаем курсор который будет проходить по нашей базе данных.
         * С помощью метода  query читаем базу данных исходя из параметров**/

        Cursor cursor = readableDatabase.query(Cat.TABLE_NAME, null, null,null,null,null,null);

        List<Cat> catList = new ArrayList<>();

        if(cursor != null && cursor.getCount() > 0){

            /**cursor.moveToFirst вызывается в самом начале чтобы курсор был вверху  **/

            cursor.moveToFirst();

            /** cursor.getCount() возвращает колличество элементов в колонке**/

            int count = cursor.getCount();
            for (int i = 0; i < count; i++){

                /** В name с помощью метода cursor.getString(cursor.getColumnIndex получаем индекс колонки
                 * В самом начале курсор находиться в первой строке таблицы и охватывает всю строку полностью.**/

                /** запрашиваем у курсора данные которые находятся в колонке Cat.COLUMN_NAME **/
                String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGE));
                String breed = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_BREED));

                /** создаем экземпляр кота, которому будут передаваться параметры из базы данных **/

                Cat cat = new Cat(name, age, breed);

                /** добавление кота в созданный ранее список catList **/

                catList.add(cat);

                /**cursor.moveToNext() просим курсор переместиться на следующую строку  **/

                cursor.moveToNext();


            }

            /** cursor - это ресурс, а все ресурся должны быть закрыты после завершения работы с ним  **/
            cursor.close();

        }
        return null;
    }
}
