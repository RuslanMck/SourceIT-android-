package android.sourceit.sourceitsample;

import android.sourceit.sourceitsample.adapter.SampleListAdapter;
import android.sourceit.sourceitsample.adapter.SampleRecycleAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            lst.add("Item " + i);
        }
        ((ListView)findViewById(R.id.listView)).
                setAdapter(new SampleListAdapter(getBaseContext(), 0, lst));
//        ((RecyclerView)findViewById(R.id.listView)).setAdapter(new SampleRecycleAdapter(lst));
    }
}
