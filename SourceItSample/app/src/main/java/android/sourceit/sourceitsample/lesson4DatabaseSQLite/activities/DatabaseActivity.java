package android.sourceit.sourceitsample.lesson4DatabaseSQLite.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.sourceit.sourceitsample.R;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.adapter.CatCursorAdapter;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.adapter.CatDbAdapter;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.helper.CatDao;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.helper.DatabaseCatDaoImpl;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.helper.DatabaseHelper;
import android.sourceit.sourceitsample.model.Cat;
import android.sourceit.sourceitsample.model.Feed;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    private CatDao catDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        catDao = new DatabaseCatDaoImpl(this);

        ListView listView = findViewById(R.id.listViewDatabase);
        final CatDbAdapter adapter = new CatDbAdapter(this, catDao.getAll());
        listView.setAdapter(adapter);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                String name = ((EditText)findViewById(R.id.editTextName)).getText().toString();
                String ageValue = ((EditText)findViewById(R.id.editTextAge)).getText().toString();
                int age = Integer.parseInt(ageValue);
                String breed = ((EditText) findViewById(R.id.editTextBreed)).getText().toString();
                Cat cat = new Cat(name, age, breed);
                catDao.insertCat(cat);
            }
        });

        findViewById(R.id.buttonCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Cat> catList = catDao.getAll();
                if (catList != null && catList.size() > 0){
                    Toast.makeText(v.getContext(), "Котов в базе " + catList.size(), Toast.LENGTH_LONG).show();
                    adapter.clear();
                    adapter.addAll(catList);
                } else {
                    Toast.makeText(v.getContext(), "Котов в базе нет", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
