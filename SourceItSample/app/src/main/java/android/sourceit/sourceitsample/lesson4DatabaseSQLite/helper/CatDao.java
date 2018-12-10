package android.sourceit.sourceitsample.lesson4DatabaseSQLite.helper;

import android.database.Cursor;
import android.sourceit.sourceitsample.model.Cat;

import java.util.List;

/**
 * Created by Ruslan Ivakhnenko on 23.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public interface CatDao {

    void insertCat(Cat cat);

    List<Cat> getAll();

    Cursor getCursorAll();
}
