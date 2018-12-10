package ua.sourceit.dbcats.helper;

import java.util.List;

import ua.sourceit.dbcats.model.Cat;

public interface CatDataAccessObject {

    boolean insertCat(Cat cat);

    int getSize();

    List<Cat> getAll();
}
