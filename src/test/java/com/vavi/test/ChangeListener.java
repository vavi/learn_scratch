package com.vavi.test;

import com.google.common.eventbus.Subscribe;


public class ChangeListener {



    @Subscribe
    public void lister(Integer integer) {
        System.out.printf("%s from int%n", integer);
    }

    @Subscribe
    public void lister(Number integer) {
        System.out.printf("%s from Number%n", integer);
    }

    @Subscribe
    public void lister(Long integer) {
        System.out.printf("%s from long%n", integer);
    }


}
