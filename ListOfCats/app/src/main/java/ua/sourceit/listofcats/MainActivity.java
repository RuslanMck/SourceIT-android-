package ua.sourceit.listofcats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cats> catsList = new ArrayList<>();
        catsList.add(new Cats("Bobby", 3, "Abyssinian"));
        catsList.add(new Cats("Abby", 8, "Exotic Shorthair"));
        catsList.add(new Cats("Lox", 2, "Korat"));
        catsList.add(new Cats("Farty", 6, "Ocicat"));
        catsList.add(new Cats("Dolly", 10, "LaPerm"));
        catsList.add(new Cats("Batoc", 6, "Russian White"));
        catsList.add(new Cats("Moody", 3, "Exotic Shorthair"));
        catsList.add(new Cats("Lovely", 13, "Japanese Bobtail"));
        catsList.add(new Cats("Sweet", 5, "Serrade petit"));
        catsList.add(new Cats("Toy", 8, "York Chocolate"));
        catsList.add(new Cats("Aspa", 2, "Russian Blue"));
        catsList.add(new Cats("Boy", 12, "Abyssinian"));
        catsList.add(new Cats("Mathilda", 9, "Turkish Angora"));

        ((ListView)findViewById(R.id.listview_cats)).setAdapter(new CatsListAdapter(0, getBaseContext(), catsList));
    }
}
