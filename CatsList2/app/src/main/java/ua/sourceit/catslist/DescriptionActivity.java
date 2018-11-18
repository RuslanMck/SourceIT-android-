package ua.sourceit.catslist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends Activity {

    public static String catBreed = "catBreed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        String breedName = getIntent().getExtras().getString(catBreed);

        switch (breedName) {
            case "Abyssinian": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_abyssinian);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.decr_abyssinian);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_abyssinian);
            } break;

            case "Exotic Shorthair": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_exotic_shorthair);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_exotic_shorthair);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_exotic_shorthair);
            } break;

            case "Korat": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_the_korat);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_the_korat);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_korat);
            } break;

            case "Ocicat": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_ocicat);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_ocicat);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_ocicat);
            } break;

            case "LaPerm": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_laPerm);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_laPerm);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_leperm);
            } break;

            case "Russian White": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_russian_white);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_russian_white);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_russian_white);
            } break;

            case "Japanese Bobtail": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_japanese_bobtail);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_japanese_bobtail);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_japanese_bobtail);
            } break;

            case "Serrade petit": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_serrade_petit);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_serrade_petit);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_serrade_petit);
            } break;

            case "York Chocolate": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_york_chocolate);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_york_chocolate);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_york_chocolate);
            } break;

            case "Russian Blue": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_russian_blue);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_russian_blue);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_russian_blue);
            } break;

            case "Turkish Angora": {
                TextView breed = findViewById(R.id.name);
                breed.setText(R.string.breed_turkish_angora);

                TextView description = findViewById(R.id.description);
                description.setText(R.string.descr_turkish_angora);

                ImageView photo = findViewById(R.id.imageViewCat);
                photo.setImageResource(R.drawable.discr_cat_turkish_angora);
            } break;
        }
    }
}
