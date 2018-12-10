package ua.sourceit.boardgames.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Game {

    public static final String TABLE_NAME = "Games";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IMGURL = "imgURL";
    public static final int COLUMN_ID = 0;

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "imgURL")
    private int imgURL;

    public Game(){

    }
    @Ignore
    public Game(int id, String name, int imgURL) {
        this.id = id;
        this.name = name;
        this.imgURL = imgURL;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColumnName() {
        return COLUMN_NAME;
    }

    public static String getColumnImgurl() {
        return COLUMN_IMGURL;
    }

    public static int getColumnId() {
        return COLUMN_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgURL() {
        return imgURL;
    }

    public void setImgURL(int imgURL) {
        this.imgURL = imgURL;
    }
}
