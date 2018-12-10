package ua.sourceit.dbcatssecond;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import ua.sourceit.dbcatssecond.adapter.CatCursorAdapter;
import ua.sourceit.dbcatssecond.helper.CatDataAccessObject;
import ua.sourceit.dbcatssecond.helper. DBCatDAOImpl;
import ua.sourceit.dbcatssecond.model.Cat;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    CatDataAccessObject catsDb;

    CursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catsDb = new DBCatDAOImpl(this);

        /** Вызвали LoaderManager **/
        final LoaderManager loaderManager = LoaderManager.getInstance(this);

        /** Создали loader которому передаем id нашего loader
         * параметры - null **/
        loaderManager.initLoader(0,null,this).forceLoad();

        ListView listView = findViewById(R.id.viewDatabase);

        cursorAdapter = new CatCursorAdapter(this,null,true);
        listView.setAdapter(cursorAdapter);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etName = findViewById(R.id.editTextName);
                String name = etName.getText().toString();

                EditText etAge = findViewById(R.id.editTextAge);
                int age = Integer.parseInt(etAge.getText().toString());

                EditText etBreed = findViewById(R.id.editTextBreed);
                String breed = etBreed.getText().toString();

                Cat cat = new Cat(name,age, breed);

                boolean isInserted = catsDb.insertCat(cat);

                if (isInserted = true){
                    Toast.makeText(v.getContext(), "В базу данных добавлен кот " + cat.getName() , Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(v.getContext(), "Данные не добавлены в базу данных", Toast.LENGTH_SHORT).show();
                }

                loaderManager.getLoader(0).onContentChanged();
            }
        });

        findViewById(R.id.buttonCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(v.getContext(), "Колличестко котов в базе = " + catsDb.getSize(), Toast.LENGTH_SHORT).show();
                } catch (NullPointerException e){
                    Toast.makeText(v.getContext(), "Даза данных пуста"   , Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.buttonListView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CatListActivity.class);
                startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        AsyncTaskLoader<Cursor> loader = new AsyncTaskLoader<Cursor>(this) {
            @Nullable
            @Override
            public Cursor loadInBackground() {
                return catsDb.getCursorAll();
            }
        };
        return loader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor o) {
        cursorAdapter.swapCursor(o);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
