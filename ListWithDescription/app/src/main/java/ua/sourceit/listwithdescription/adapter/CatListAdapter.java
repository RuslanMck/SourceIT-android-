package ua.sourceit.listwithdescription.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ua.sourceit.listwithdescription.R;
import ua.sourceit.listwithdescription.model.Cat;


public class CatListAdapter extends ArrayAdapter<Cat> {

    /**
     * LayoutInflater класс, который создает экземпляр XML-файла в соответствующие View объекты.
     * LayoutInflater будет заполнять наш ListView тем, что мы ему передадим.
     * Создаем новый экземпляр этого класса
     **/

    private LayoutInflater layoutInflater;

    /**
     * Необходимо создать метод CatListAdapter. Мы передаем ему context, resource,
     * и object list. resource указываем 0
     **/

    public CatListAdapter(Context context, List<Cat> catList) {
        super(context, 0, catList);

        /** Context – это объект, который предоставляет доступ к базовым функциям приложения:
         * доступ к ресурсам, к файловой системе, вызов активности и т.д. Мы предоставляем обьекту
         * класса LayoutInflater доступ к нашей активность, где находится
         * list view, для того, чтобы layoutInflater смог поместить туда наши данные.**/

        layoutInflater = LayoutInflater.from(context);
    }

    /**
     * Переопределяем метод getView который принимает три параметра (position - числовая позиция
     * элемента во view list; View convertView - параметр который отвечает за повтороное
     * использования элемента view list; ViewGroup parent - мы указываем к чему будет привязан этот view
     **/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        /** Если мы не используем уже созданный view повтороно, будет создан новый view.
         * С помощью экземпляра класса LayoutInflater мы указываем чем заполняем новый view -
         * (R.layout.item_cat где item_cat - заранее созданным нами xml)
         * В противном случае в новом view  будет использован уже созданный view (convertView) **/

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_cat, parent, false);
        } else {
            view = convertView;
        }

        /**  Вызываем экземпляр класса Cat, который находится на позиции в list view, но которую мы
         * нажали (getItem(position));
         * Далее мы заполняем поля text view, которые мы создали в xml файле item_cat ссылаясь на
         * id каждого из text view**/
        Cat cat = getItem(position);

        /** Мы создали экземпляры text view которые ссылаются на наши поля в xml файле **/

        TextView name = view.findViewById(R.id.tv_name);
        TextView age = view.findViewById(R.id.tv_age);
        TextView breed = view.findViewById(R.id.tv_breed);

        /** Заполняем поля, используя методы экземпляра класса Cat: getName, getAge, getBreed.
         *  !!!!! ВАЖНО Мы не можем передать text view int значение, поэтому используем
         *  метод String.valueOf() **/

        name.setText(cat.getName());
        age.setText(String.valueOf(cat.getAge() + " years"));
        breed.setText(cat.getBreed());

        return view;
    }
}
