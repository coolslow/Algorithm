package com.coolslow.DesignPatterns.Singleton;

/**
 * 创建的一个SingleTon类
 */
public class SingleTon {

    private static SingleTon instance = new SingleTon();

    // 让构造函数为private，这样，这个类就不会被实例化
    private SingleTon() {
        // TODO
    }

    // 获取唯一可用的对象
    public static SingleTon getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
