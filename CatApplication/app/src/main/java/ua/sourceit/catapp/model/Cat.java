package ua.sourceit.catapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/** Искользуем dataBinding, связку между этим файлом и view_item.xlm
 * Это впзволит нам быстро передавать данные во view. Т.к. в view_item.xlm указываем какие данные куда будут помещаться
 * В view_item.xlm
 * android:text="@{cat.name}" указывает что в это textview будет помещено имя кота**/


@Entity
public class Cat {

    public static final String TABLE_NAME = "Cat";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_BREED = "breed";
    public static final String COLUMN_IMGURL = "imgUrl";
    public static final String COLUMN_DESCRIPTION = "description";


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int age;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String breed;

    @ColumnInfo
    private String description;

    @ColumnInfo
    private String imgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
