package ua.sourceit.loadermanager;

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

import ua.sourceit.loadermanager.adapter.CatCursorAdapter;
import ua.sourceit.loadermanager.database.CatDataAccessObject;
import ua.sourceit.loadermanager.database.DBCatDAOImpl;
import ua.sourceit.loadermanager.model.Cat;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    CatDataAccessObject catsDb;
    CursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catsDb = new DBCatDAOImpl(this);

        final LoaderManager loaderManager = LoaderManager.getInstance(this);

        loaderManager.initLoader(0,null, this).forceLoad();

        ListView listView = findViewById(R.id.listViewCats);

        cursorAdapter = new CatCursorAdapter(this, null, true);

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

                Cat cat = new Cat(name, age, breed);

                boolean isInserted = catsDb.insertCat(cat);

                if (isInserted = true){
                    Toast.makeText(v.getContext(), "В БД добавлен кот " + cat.getName(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(v.getContext(), "Кот небыл добавлен", Toast.LENGTH_SHORT).show();
                }

                loaderManager.getLoader(0).onContentChanged();
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
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor c) {
        cursorAdapter.swapCursor(c);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
