package ua.sourceit.resultbutton;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 1);

        ((TextView)findViewById(R.id.nema)).setText(name);
        ((TextView)findViewById(R.id.age)).setText(String.valueOf(age));


        findViewById(R.id.second_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(SecondActivity.this, MainActivity.class);
                resultIntent.putExtra("nameResult", "This is result");
                setResult(Activity.RESULT_OK, resultIntent); //???
                finish();
            }
        });
    }
}
