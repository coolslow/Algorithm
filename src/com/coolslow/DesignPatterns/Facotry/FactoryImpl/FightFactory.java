package com.coolslow.DesignPatterns.Facotry.FactoryImpl;

import com.coolslow.DesignPatterns.Facotry.ProductImpl.Hawkeye;
import com.coolslow.DesignPatterns.Facotry.IHero;
import com.coolslow.DesignPatterns.Facotry.IHeroFactory;

public class FightFactory implements IHeroFactory {
    @Override
    public IHero callTheHero() {
        return new Hawkeye();
    }
}
