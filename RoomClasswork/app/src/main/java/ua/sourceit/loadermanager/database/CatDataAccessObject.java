package ua.sourceit.loadermanager.database;

import android.database.Cursor;

import java.util.List;

import ua.sourceit.loadermanager.model.Cat;

public interface CatDataAccessObject {

    boolean insertCat(Cat cat);
    List<Cat> getAll();
    int getSize();
    Cursor getCursorAll();
}
