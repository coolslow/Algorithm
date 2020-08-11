package com.coolslow.DesignPatterns.Singleton;

public class SingleTonPatternDemo {
    public static void Main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();

        singleTon.showMessage();
    }
}
