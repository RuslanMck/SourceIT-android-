package ua.sourceit.dbcats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ua.sourceit.dbcats.adapter.CatListAdapter;
import ua.sourceit.dbcats.helper.DBCatDAOImpl;
import ua.sourceit.dbcats.model.Cat;

public class CatListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_list);
        DBCatDAOImpl dbCatDAO = new DBCatDAOImpl(this);
        List<Cat> catList = dbCatDAO.getAll();

        final ListView listView = findViewById(R.id.listView);
        final CatListAdapter catListAdapter = new CatListAdapter(this, catList);

        listView.setAdapter(catListAdapter);

    }
}
