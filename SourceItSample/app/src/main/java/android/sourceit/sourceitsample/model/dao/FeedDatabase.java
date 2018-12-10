package android.sourceit.sourceitsample.model.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.sourceit.sourceitsample.model.Feed;

/**
 * Created by Ruslan Ivakhnenko on 23.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
@Database(entities = {Feed.class}, version = 1)
public abstract class FeedDatabase extends RoomDatabase {

    public abstract FeedDao feedDao();
}
