package ua.sourceit.catapp;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

import ua.sourceit.catapp.adapter.CatAdapter;
import ua.sourceit.catapp.adapter.CatRecycleAdapter;
import ua.sourceit.catapp.database.CatRoomDB;
import ua.sourceit.catapp.model.Cat;
import ua.sourceit.catapp.network.CatLoadingListener;
import ua.sourceit.catapp.network.LoadAsyncTask;
import ua.sourceit.catapplication.R;
import ua.sourceit.catapplication.databinding.ActivityMainBinding;

import static ua.sourceit.catapplication.BR.cat;

public class MainActivity extends AppCompatActivity implements CatLoadingListener {

    RecyclerView recyclerView;
    TextView emptyView;
    private List<Cat> catList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        emptyView = findViewById(R.id.emptyView);

        LoadAsyncTask loadAsyncTask = new LoadAsyncTask(this, this);
        loadAsyncTask.execute();

        recyclerView.setAdapter(new CatRecycleAdapter(catList, new CatRecycleAdapter(). );
    }

    @Override
    public void startLoading() {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void finishLoading(List<Cat> cats) {
    }


}
