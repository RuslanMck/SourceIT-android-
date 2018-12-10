package ua.sourceit.loadermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import ua.sourceit.loadermanager.model.Cat;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        CatAsyncTask catAsyncTask = new CatAsyncTask(new CatListener() {
            @Override
            public void onReceive(List<Cat> catList) {
                Toast.makeText(getBaseContext(), "Котов получили" + catList.size(), Toast.LENGTH_SHORT).show();
            }
        });
        catAsyncTask.execute();
    }
}
