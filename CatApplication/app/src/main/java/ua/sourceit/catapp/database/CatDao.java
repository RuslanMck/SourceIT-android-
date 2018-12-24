package ua.sourceit.catapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import java.util.List;

import ua.sourceit.catapp.model.Cat;

/** Указываем какие действия мы будем произволить с нашей базой данных
 * аннотация @Dao нужня для работы с Room **/

@Dao
public interface CatDao {

    /** После вызова метода Cursor getAll(); нам вернется курсор со всеми котами
     * аннотация @Query нужня для работы с Room
     * "select * from Cat" это SQL запрос который обозначает мы делаем выборку из экземпляров класса Cat**/

    @Query("select * from Cat")
    Cursor getAll();

    @Insert
    void insertCat (List<Cat> catList);

    @Query("select * from Cat where id=:catId")
    Cat getCat(int catId);


}
