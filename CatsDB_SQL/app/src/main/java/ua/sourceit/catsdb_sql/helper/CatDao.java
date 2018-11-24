package ua.sourceit.catsdb_sql.helper;

import java.util.List;

import ua.sourceit.catsdb_sql.model.Cat;

public interface CatDao {

    /** Метод для добавления в базу данныйх **/

    void insertCat(Cat cat);

    /** Метод для вывода базы данных **/

    List<Cat> getAll();
}
