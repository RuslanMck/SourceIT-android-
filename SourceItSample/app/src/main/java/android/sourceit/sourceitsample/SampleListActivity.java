package android.sourceit.sourceitsample;

import android.content.Intent;
import android.graphics.Rect;
import android.sourceit.sourceitsample.adapter.SampleListAdapter;
import android.sourceit.sourceitsample.adapter.SampleRecycleAdapter;
import android.sourceit.sourceitsample.service.SourceIntentService;
import android.sourceit.sourceitsample.service.SourceService;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SampleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_rv);
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            lst.add("Item " + i);
        }
//        ((ListView)findViewById(R.id.listView)).
//                setAdapter(new SampleListAdapter(getBaseContext(), 0, lst));

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        ((LinearLayoutManager)recyclerView.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }
        });
        recyclerView.setAdapter(new SampleRecycleAdapter(lst));

        for (int i = 0; i < 100; i++){
            Intent intent = new Intent(this, SourceIntentService.class);
            intent.setAction("Action " + i);
//            startService(intent);

        }
    }
}
