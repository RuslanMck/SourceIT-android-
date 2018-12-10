package android.sourceit.sourceitsample.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.sourceit.sourceitsample.model.Feed;

import java.util.List;

/**
 * Created by Ruslan Ivakhnenko on 23.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
@Dao
public interface FeedDao {

    @Query("select * from Feed")
    List<Feed> getAll();

    @Insert
    void addFeed(Feed feed);
}
