package ua.sourceit.dbcats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

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

                boolean isInserted = catsDb.insertCat(cat);

                if (isInserted = true){
                    Toast.makeText(MainActivity.this, "В база данных добавлен кот " + cat.getName() , Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Данные не добавлены в базу данных", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.buttonCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(MainActivity.this, "В базе данных " + catsDb.getAll() + " кота", Toast.LENGTH_SHORT).show();
                } catch (NullPointerException e){
                    Toast.makeText(MainActivity.this, "Даза данных пуста"   , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
