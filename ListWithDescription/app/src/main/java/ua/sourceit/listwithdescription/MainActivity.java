package ua.sourceit.listwithdescription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ua.sourceit.listwithdescription.adapter.CatListAdapter;
import ua.sourceit.listwithdescription.model.Cat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Cat> catList = new ArrayList<>();

        catList.add(new Cat("Bobby", 3, "Abyssinian"));
        catList.add(new Cat("Abby", 8, "Exotic Shorthair"));
        catList.add(new Cat("Box", 2, "Korat"));
        catList.add(new Cat("Farty", 6, "Ocicat"));
        catList.add(new Cat("Dolly", 10, "LaPerm"));
        catList.add(new Cat("Batoc", 6, "Russian White"));
        catList.add(new Cat("Moody", 3, "Exotic Shorthair"));
        catList.add(new Cat("Lovely", 13, "Japanese Bobtail"));
        catList.add(new Cat("Sweet", 5, "Serrade petit"));
        catList.add(new Cat("Toy", 8, "York Chocolate"));
        catList.add(new Cat("Aspa", 2, "Russian Blue"));
        catList.add(new Cat("Boy", 12, "Abyssinian"));
        catList.add(new Cat("Mathilda", 9, "Turkish Angora"));

        /** Создаем list view который будет отображаться в list view созданном в xml файле **/
        final ListView listView = findViewById(R.id.main_listview);

        /** Создаем экземплят CatListAdapter которы будет заполнять созданный нами ListView.
         * Указываем, что для заполнения он будет использовать catList **/

        final CatListAdapter catListAdapter = new CatListAdapter(this, catList);

        /** Задаем нашему listView созданный нами ранее адаптер catListAdapter **/

        listView.setAdapter(catListAdapter);

        /** OnItemClickListener обрабатывает нажатие на пункт списка. Переоперделяем метод onItemClick для списка listView **/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /** Intent – это объект, который мы используем для взаимодействия в другими Activity
                 * Создаем экземпляр intent в котором мы прописываем, какое Activity нам необходимо вызвать.
                 * После чего мы передаем этот Intent-объект методу startActivity, который находит
                 * соответствующее Activity и показывает его. При создании Intent мы использовали
                 * конструктор Intent (Context packageContext, Class cls) с двумя параметрами.**/

                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);

                /** Просим intent при вызове другого Activity, поместить в запрос переменную catBreed (intent.putExtra)
                 * которая создана в классе DescriptionActivity, котороы присваиваем породу кота.
                 * из catListAdapter мы берем элемени который находится на позиции position - тот
                 * элемент на который мы нажали и у этого элемента вызываем метод getBreed() чтоюы
                 * получить породу кота. Дальнейшее использование catBreed в классе DescriptionActivity**/

                intent.putExtra(DescriptionActivity.catBreed, catListAdapter.getItem(position).getBreed());

                /** Запускаем созданный нами intent**/

                startActivity(intent);
            }
        });
    }
}
