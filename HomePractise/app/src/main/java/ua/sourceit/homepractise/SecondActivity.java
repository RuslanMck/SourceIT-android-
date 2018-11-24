package ua.sourceit.homepractise;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        String extraText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
//        ((TextView)findViewById(R.id.tvName)).setText(extraText);

        String myName = getIntent().getExtras().getString("name");
        int myAge = getIntent().getIntExtra("age", 1);

        ((TextView)findViewById(R.id.tvName)).setText(myName);
        ((TextView)findViewById(R.id.tvAge)).setText(String.valueOf(myAge));


        findViewById(R.id.secActButt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nameResult", "This is result");
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }

}
