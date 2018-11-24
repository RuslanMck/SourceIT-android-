package ua.sourceit.dbcats.helper;

import android.widget.ListView;

import java.util.List;

import ua.sourceit.dbcats.model.Cat;

public interface CatDataAccessObject {

    void insertCat(Cat cat);

    List<Cat> getAll();
}
