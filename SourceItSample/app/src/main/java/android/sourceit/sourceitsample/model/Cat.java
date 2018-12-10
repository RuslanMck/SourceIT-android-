package android.sourceit.sourceitsample.model;

import android.provider.BaseColumns;

/**
 * Created by Ruslan Ivakhnenko on 16.11.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class Cat implements BaseColumns {

    public static final String TABLE_NAME = "Cat";

    public static final String COLUMN_NAME = "name";

    public static final String COLUMN_AGE = "age";

    public static final String COLUMN_BREED = "breed";

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

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }
}
