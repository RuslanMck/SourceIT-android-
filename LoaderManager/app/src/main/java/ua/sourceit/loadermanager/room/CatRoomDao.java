package ua.sourceit.loadermanager.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ua.sourceit.loadermanager.model.Cat;

/** СОздаем набор методов которые мы будем использовать при работа с базой данных которую создаем в классе CatRoomDB
 * Необходимо класс Cat зааннотировать (@Entity) **/

@Dao
public interface CatRoomDao {

    /** Query - это аннотация означает что метод будет деать выборку (Есть вставка, удаление, выборка, обновление **/

    @Query("select * from Cat")
    List<Cat> getAll();

    @Insert
    void insertCat(Cat cat);
}
