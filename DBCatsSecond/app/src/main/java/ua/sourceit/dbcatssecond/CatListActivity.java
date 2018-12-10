package ua.sourceit.dbcatssecond;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ListView;

        import java.util.List;

        import ua.sourceit.dbcatssecond.adapter.CatListAdapter;
        import ua.sourceit.dbcatssecond.helper.DBCatDAOImpl;
        import ua.sourceit.dbcatssecond.model.Cat;

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
