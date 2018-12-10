package android.sourceit.sourceitsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.sourceit.sourceitsample.adapter.CatListAdapter;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.activities.DatabaseActivity;
import android.sourceit.sourceitsample.lesson4DatabaseSQLite.activities.DatabaseLoaderActivity;
import android.sourceit.sourceitsample.model.Cat;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslan Ivakhnenko on 16.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class CatActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activty_cat);

        List<Cat> catList = new ArrayList<>();
        Cat cat = new Cat("Vasia", 2, "King");
        catList.add(cat);
        cat = new Cat("Petia", 4, "Homeless");
        catList.add(cat);
        cat = new Cat("Boss", 12, "SuperCat");
        catList.add(cat);

        //
        String[] stringArray = getResources().getStringArray(R.array.cats);

        ListView listView = findViewById(R.id.listViewCat);
        final CatListAdapter catListAdapter = new CatListAdapter(this, catList);

        listView.setAdapter(catListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cat cat = catListAdapter.getItem(position);
                Toast.makeText(view.getContext(), "Кот " + cat.getName(), Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CatActivity.this, DatabaseLoaderActivity.class);
                intent.putExtra("name", "This is my name");
                intent.putExtra("age", 22);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
//                startActivityForResult(intent, 1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK){
            if (data != null){
                String nameResult = data.getStringExtra("nameResult");
                ((TextView)findViewById(R.id.button)).setText(nameResult);
            }
        }
    }

    public void onButtonClick(View view){

    }
}
