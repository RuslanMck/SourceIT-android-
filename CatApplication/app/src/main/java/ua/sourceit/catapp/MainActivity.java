package ua.sourceit.catapp;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;


import ua.sourceit.catapp.adapter.CatAdapter;
import ua.sourceit.catapp.database.CatRoomDB;
import ua.sourceit.catapplication.R;
import ua.sourceit.catapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    CatRoomDB catRoomDB;
    ActivityMainBinding mBinding;
    CursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        catRoomDB = Room.databaseBuilder(this, CatRoomDB.class, "Cats.db").allowMainThreadQueries().build();

        ListView listView =findViewById(R.id.listView);
        cursorAdapter = new CatAdapter(this, null, true,null);
        listView.setAdapter(cursorAdapter);
        
    }
}
