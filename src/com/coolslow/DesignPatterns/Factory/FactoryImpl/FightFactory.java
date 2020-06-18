package com.coolslow.DesignPatterns.Factory.FactoryImpl;

import com.coolslow.DesignPatterns.Factory.ProductImpl.Hawkeye;
import com.coolslow.DesignPatterns.Factory.IHero;
import com.coolslow.DesignPatterns.Factory.IHeroFactory;

public class FightFactory implements IHeroFactory {
    @Override
    public IHero callTheHero() {
        return new Hawkeye();
    }
}
