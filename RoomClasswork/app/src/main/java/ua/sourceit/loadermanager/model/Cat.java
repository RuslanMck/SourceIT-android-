package ua.sourceit.loadermanager.model;

import android.provider.BaseColumns;

public class Cat implements BaseColumns {

    public static final String TABLE_NAME = "Cat";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_AGR = "Age";
    public static final String COLUNM_BREED = "Breed";

    private String name;
    private int age;
    private String breed;

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
