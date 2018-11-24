package ua.sourceit.dbcats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ua.sourceit.dbcats.helper.DBCatDAOImpl;
import ua.sourceit.dbcats.model.Cat;

public class MainActivity extends AppCompatActivity {

    DBCatDAOImpl catsDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catsDb = new DBCatDAOImpl(this);

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

                catsDb.insertCat(cat);
            }
        });
    }
}
