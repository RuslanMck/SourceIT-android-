package ua.sourceit.loadermanager.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


/** @Entity аннатируем что этот класс является отображанием таблицы в базе данных (в CatRoomDao мы создаем базу данных) **/

@Entity

public class Cat {

    public static final String TABLE_NAME = "Cat";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_AGR = "Age";
    public static final String COLUMN_BREED = "Breed";
    public static final int COLUMN_ID = 0;


    /** @ColumnInfo аннотация, указываем что колонка таблицы с именем name = "name" будет связана спарамером String name в классе Cat**/

    @PrimaryKey(autoGenerate = true)
    private int id;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColumnName() {
        return COLUMN_NAME;
    }

    public static String getColumnAgr() {
        return COLUMN_AGR;
    }

    public static String getColumnBreed() {
        return COLUMN_BREED;
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

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Age")
    private int age;

    @ColumnInfo(name = "Breed")
    private String breed;

    /** Room требует чтобы был соддан конструктор по умолчанию (пустой) **/
    public Cat(){

    }
    @Ignore
    public Cat(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
