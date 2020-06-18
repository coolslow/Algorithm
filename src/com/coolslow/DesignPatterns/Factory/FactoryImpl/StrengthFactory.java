package com.coolslow.DesignPatterns.Factory.FactoryImpl;

import com.coolslow.DesignPatterns.Factory.ProductImpl.Hulk;
import com.coolslow.DesignPatterns.Factory.IHero;
import com.coolslow.DesignPatterns.Factory.IHeroFactory;

public class StrengthFactory implements IHeroFactory {
    @Override
    public IHero callTheHero() {
        return new Hulk();
    }
}
