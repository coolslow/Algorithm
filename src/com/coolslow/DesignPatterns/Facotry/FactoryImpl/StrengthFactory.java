package com.coolslow.DesignPatterns.Facotry.FactoryImpl;

import com.coolslow.DesignPatterns.Facotry.ProductImpl.Hulk;
import com.coolslow.DesignPatterns.Facotry.IHero;
import com.coolslow.DesignPatterns.Facotry.IHeroFactory;

public class StrengthFactory implements IHeroFactory {
    @Override
    public IHero callTheHero() {
        return new Hulk();
    }
}
