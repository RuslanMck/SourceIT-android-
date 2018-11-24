package ua.sourceit.catslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ua.sourceit.catslist.adapter.CatListAdapter;
import ua.sourceit.catslist.model.Cat;

public class CatActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_cat);

        final List<Cat> catList = new ArrayList<>();

        catList.add(new Cat("Bobby", 3, "Abyssinian"));
        catList.add(new Cat("Abby", 8, "Exotic Shorthair"));
        catList.add(new Cat("Box", 2, "Korat"));
        catList.add(new Cat("Farty", 6, "Ocicat"));
        catList.add(new Cat("Dolly", 10, "LaPerm"));
        catList.add(new Cat("Batoc", 6, "Russian White"));
        catList.add(new Cat("Moody", 3, "Exotic Shorthair"));
        catList.add(new Cat("Lovely", 13, "Japanese Bobtail"));
        catList.add(new Cat("Sweet", 5, "Serrade petit"));
        catList.add(new Cat("Toy", 8, "York Chocolate"));
        catList.add(new Cat("Aspa", 2, "Russian Blue"));
        catList.add(new Cat("Boy", 12, "Abyssinian"));
        catList.add(new Cat("Mathilda", 9, "Turkish Angora"));

        final ListView listView = findViewById(R.id.listViewCat);
        final CatListAdapter catListAdapter = new CatListAdapter(this, catList);
        listView.setAdapter(catListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DescriptionActivity.catBreed = catListAdapter.getItem(position).getBreed();
                Intent intent = new Intent(CatActivity.this, DescriptionActivity.class);
                intent.putExtra(DescriptionActivity.catBreed, catListAdapter.getItem(position).getBreed());
                startActivity(intent);
//                startActivityForResult(intent, 1001);
            }
        });

//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View v){
//
//                Intent intent = new Intent(CatActivity.this, DetailActivity.class);
//                intent.putExtra("name", "My name");
//                intent.putExtra("age", 24);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                startActivityForResult(intent,1001);
//            }
//        });
//    }
//
//    //!!!!!Флаги Intent
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1001 && resultCode == Activity.RESULT_OK){
//            if (data != null){
//                String nameResult = data.getStringExtra("nameResult");
//                ((TextView)findViewById(R.id.button)).setText(nameResult);
//            }
//        }
    }
}
