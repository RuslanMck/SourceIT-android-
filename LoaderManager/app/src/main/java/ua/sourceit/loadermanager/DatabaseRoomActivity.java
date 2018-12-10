package ua.sourceit.loadermanager;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ua.sourceit.loadermanager.database.CatRoomDB;
import ua.sourceit.loadermanager.databinding.ActivityDatabaseRoomBinding;
import ua.sourceit.loadermanager.model.Cat;

public class DatabaseRoomActivity extends AppCompatActivity {

    CatRoomDB catRoomDB;

    ActivityDatabaseRoomBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Для работы с DataBinding нужно изменить setContentView(R.layout.activity_database_room);**/
//        setContentView(R.layout.activity_database_room);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_database_room);

        /** СОздает ссылку на catRoomDB и Room сам создает реализацию наших абстрактных классов CatRoomDB
         * необходимо указать .allowMainThreadQueries() для того чтобы catRoomDB.catDao().insertCat(cat);
         * выполнялся в UI потоке**/
        catRoomDB = Room.databaseBuilder(this, CatRoomDB.class, "cat.db").allowMainThreadQueries().build();

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EditText etName = findViewById(R.id.editTextName);
//                EditText etAge = findViewById(R.id.editTextAge);
//                EditText etBreed = findViewById(R.id.editTextBreed);



//                String name = etName.getText().toString();
//                int age = Integer.parseInt(etAge.getText().toString());
//                String breed = etBreed.getText().toString();

                String name = mBinding.editTextName.getText().toString();
                int age = Integer.parseInt(mBinding.editTextAge.getText().toString());
                String breed = mBinding.editTextBreed.getText().toString();

                Cat cat = new Cat(name, age, breed);

                catRoomDB.catDao().insertCat(cat);
            }
        });

        findViewById(R.id.buttonCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Cat> catList = catRoomDB.catDao().getAll();

                if (catList != null){
                    Cat cat = catList.get(catList.size() - 1); // получаем последний элемент из нашего списка
                    mBinding.setCat(cat);
//                    Toast.makeText(v.getContext(), "Котов в базе " + catList.size(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
