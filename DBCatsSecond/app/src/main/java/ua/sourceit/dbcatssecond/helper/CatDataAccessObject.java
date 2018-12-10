package ua.sourceit.dbcatssecond.helper;

import android.database.Cursor;

import java.util.List;

import ua.sourceit.dbcatssecond.model.Cat;

public interface CatDataAccessObject {

    boolean insertCat(Cat cat);

    int getSize();

    List<Cat> getAll();

    Cursor getCursorAll();
}
