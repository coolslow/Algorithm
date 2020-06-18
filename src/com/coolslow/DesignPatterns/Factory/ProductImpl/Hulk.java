package com.coolslow.DesignPatterns.Factory.ProductImpl;

import com.coolslow.DesignPatterns.Factory.IHero;

/**
 * 绿巨人
 */
public class Hulk implements IHero {
    @Override
    public void skill() {
        System.out.println("绿巨人 - 智力：6, 力量：10, 格斗技巧：5");
    }
}
