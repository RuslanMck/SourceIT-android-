package android.sourceit.sourceitsample.lesson4DatabaseSQLite.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.sourceit.sourceitsample.R;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.adapter.CatCursorAdapter;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.helper.CatDao;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.helper.DatabaseCatDaoImpl;
import android.sourceit.sourceitsample.model.Cat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DatabaseLoaderActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private CatDao catDao;

    CatCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        catDao = new DatabaseCatDaoImpl(this);

        /** Создаем LoaderManager вместо SQLiteOpenHelper **/

        final LoaderManager loaderManager = LoaderManager.getInstance(this);

        /** 0 -айди лоадера (можно создавать разные лоадеры с разными параметрами bundle)
         * bundle - null  - параметры которые передаем loader у. (выборча по имени, возрасту...)
         * .forceLoad() для того чтобы AsyncTaskLoader запустил метод loadInBackground**/

        loaderManager.initLoader(0, null, this).forceLoad();

        ListView listView = findViewById(R.id.listViewDatabase);

        cursorAdapter = new CatCursorAdapter(this, null, true);
        listView.setAdapter(cursorAdapter);


        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();

                /** Создали кота **/
                String name = ((EditText)findViewById(R.id.editTextName)).getText().toString();
                String ageValue = ((EditText)findViewById(R.id.editTextAge)).getText().toString();
                int age = Integer.parseInt(ageValue);
                String breed = ((EditText) findViewById(R.id.editTextBreed)).getText().toString();
                Cat cat = new Cat(name, age, breed);

                /** Добавили кота в catDao**/

                catDao.insertCat(cat);

                /** Запрашиваем у loaderManager лоадер с id 0, и вызываем метод onContentChanged() чтобы обновить данные.**/
                loaderManager.getLoader(0).onContentChanged();
            }
        });

        findViewById(R.id.buttonCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Cat> catList = catDao.getAll();
                if (catList != null && catList.size() > 0){
                    Toast.makeText(v.getContext(), "Котов в базе " + catList.size(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(v.getContext(), "Котов в базе нет", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @NonNull
    @Override

    /** Параметризирванный лоадер который возвращает курсор**/

    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {

        /** AsyncTaskLoader абстрактный класс у которого переопределяем  loadInBackground
         * создаем лоадер и возвращаем его системе
         * метод getCursorAll() проходит по базе данных, сохраняет в себе собранные данные **/
        AsyncTaskLoader<Cursor> loader = new AsyncTaskLoader<Cursor>(this) {
            @Nullable
            @Override
            public Cursor loadInBackground() {
                return catDao.getCursorAll();
            }
        };
        return loader;
    }

    @Override
    /** Отдаем данные адаптеру, которые получили от курсора **/
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor o) {
        cursorAdapter.swapCursor(o);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
