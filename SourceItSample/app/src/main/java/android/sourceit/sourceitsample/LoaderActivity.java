package android.sourceit.sourceitsample;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.sourceit.sourceitsample.adapter.ContactCursorAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class LoaderActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ContactCursorAdapter cursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        ListView recyclerView = findViewById(R.id.recycleView);
        cursorAdapter = new ContactCursorAdapter(this, null, true);
        recyclerView.setAdapter(cursorAdapter);


        LoaderManager loaderManager = LoaderManager.getInstance(this);
        loaderManager.initLoader(0, null, this);

    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        Uri baseUri = ContactsContract.Contacts.CONTENT_URI;
        return new CursorLoader(this, baseUri, null, null, null, ContactsContract.Contacts.STARRED + " DESC");
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor o) {
        cursorAdapter.changeCursor(o);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
