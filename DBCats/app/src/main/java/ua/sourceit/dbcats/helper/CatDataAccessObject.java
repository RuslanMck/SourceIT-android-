package ua.sourceit.dbcats.helper;

import ua.sourceit.dbcats.model.Cat;

public interface CatDataAccessObject {

    boolean insertCat(Cat cat);

    int getAll();
}
