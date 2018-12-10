package ua.sourceit.loadermanager.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ua.sourceit.loadermanager.model.Cat;
import ua.sourceit.loadermanager.room.CatRoomDao;


/** СОздаем базу данных
 * Для работы с Room этот класс должен быть абстрактным
 * В entitie мы указываем класс со списком наших таблиц**/

@Database(entities = {Cat.class}, version = 1)
public abstract class CatRoomDB extends RoomDatabase {

    /** Создаем абстрактный метод **/
    public abstract CatRoomDao catDao();
}
