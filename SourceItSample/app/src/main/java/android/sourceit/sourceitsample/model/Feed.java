package android.sourceit.sourceitsample.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.provider.BaseColumns;

/**
 * Created by Ruslan Ivakhnenko on 23.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
@Entity
public class Feed implements BaseColumns {

    public static final String TABLE_NAME = "Feed";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_AUTHOR = "author";

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
