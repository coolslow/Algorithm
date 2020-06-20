package com.coolslow.DesignPatterns.Observer;

/**
 * 抽象主题角色
 */
public interface AbstractSubject {
    void addObserver(AbstractObserver observer);
    void removeObserver(AbstractObserver observer);
    void notification();
}
