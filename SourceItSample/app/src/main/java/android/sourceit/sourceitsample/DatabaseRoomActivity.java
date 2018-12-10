package android.sourceit.sourceitsample;

import android.arch.persistence.room.Room;
import android.sourceit.sourceitsample.model.Feed;
import android.sourceit.sourceitsample.model.dao.FeedDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DatabaseRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_room);

        final FeedDatabase database = Room.databaseBuilder(getApplicationContext(), FeedDatabase.class, "database-room").build();
        final Feed feed = new Feed();
        feed.setTitle("the Title");
        feed.setDescription("the description");
        feed.setAuthor("the author");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                database.feedDao().addFeed(feed);
            }
        });
        thread.start();

    }
}
