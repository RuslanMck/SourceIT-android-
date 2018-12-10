package ua.sourceit.catapp.adapter;

import ua.sourceit.catapp.model.Cat;

/** Мы пишем свой листенер потому что у ресайклвью нет своего листенера **/

public interface OnCatClickListener {
    void onCatClick(Cat cat);
}
