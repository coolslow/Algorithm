package com.coolslow.DesignPatterns.Facotry.ProductImpl;

import com.coolslow.DesignPatterns.Facotry.IHero;

public class Hawkeye implements IHero {
    @Override
    public void skill() {
        System.out.println("鹰眼 - 智力：8, 力量：6, 格斗技巧：10");
    }
}
