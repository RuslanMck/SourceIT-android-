package ua.sourceit.loadermanager;

import java.util.List;

import ua.sourceit.loadermanager.model.Cat;

public interface CatListener {

    void onReceive(List<Cat> catList);
}
