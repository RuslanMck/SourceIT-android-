package ua.sourceit.catslist;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ua.sourceit.catslist.description.CatsDescription;
import ua.sourceit.catslist.model.Cat;

public class DescriptionActivity extends Activity {

    public static final String CAT_ID = "catId";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        int catId = (Integer)getIntent().getExtras().get(CAT_ID);
        CatsDescription catsDescription = CatsDescription.catsDescr[catId];

        TextView name = findViewById(R.id.name);
        name.setText(catsDescription.getName());

        TextView description = findViewById(R.id.description);
        description.setText(catsDescription.getDescr());

        ImageView photo = findViewById(R.id.imageViewCat);
        photo.setImageResource(catsDescription.getImgResId());
        photo.setContentDescription(catsDescription.getName());

    }
}
