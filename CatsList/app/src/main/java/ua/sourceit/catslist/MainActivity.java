package ua.sourceit.catslist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cats> catsList = new ArrayList<>();
        catsList.add(new Cats("Cat_1", 9, "qwe"));
        catsList.add(new Cats("Cat_2", 8, "asd"));
        catsList.add(new Cats("Cat_3", 7, "zxc"));
        catsList.add(new Cats("Cat_4", 6, "qwe"));
        catsList.add(new Cats("Cat_5", 5, "asd"));
        catsList.add(new Cats("Cat_6", 4, "ghj"));
        catsList.add(new Cats("Cat_7", 3, "bnm"));
        catsList.add(new Cats("Cat_8", 2, "ghj"));
        catsList.add(new Cats("Cat_9", 1, "qwmbnme"));


       ((ListView)findViewById(R.id.listview_cats)).setAdapter(new CatsListAdapter(0, getBaseContext(), catsList));

    }
}
