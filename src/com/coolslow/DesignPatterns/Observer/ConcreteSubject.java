package com.coolslow.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements AbstractSubject {

    List<AbstractObserver> list = new ArrayList<>();

    @Override
    public void addObserver(AbstractObserver observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(AbstractObserver observer) {
        list.remove(observer);
    }

    // 状态改变了，所有观察者更新自己的状态
    @Override
    public void notification() {
        for (AbstractObserver abstractObserver : list) {
            abstractObserver.update();
        }
    }
}
