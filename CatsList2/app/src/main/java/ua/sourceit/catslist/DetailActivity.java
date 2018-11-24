//package ua.sourceit.catslist;
//
//
//import android.app.Activity;
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//public class DetailActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//
//        String extraText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
//        ((TextView)findViewById(R.id.textViewName)).setText(extraText);
//
//        String name = getIntent().getStringExtra("name");
//        int age = getIntent().getIntExtra("age", 1);
//
//        ((TextView)findViewById(R.id.textViewName)).setText(name);
//        ((TextView)findViewById(R.id.textViewAge)).setText(String.valueOf(age));
//
//        findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("nameResult", "This is result");
//                setResult(Activity.RESULT_OK, resultIntent);
//                finish();
//            }
//        });
//    }
//
//
//}
