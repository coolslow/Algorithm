# 工厂方法

定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使一个类的实例化延迟到其子类。
工厂方法的目的是使得创建对象和使用对象是分离的，并且客户端总是引用抽象工厂和抽象产品。

    Factory(抽象)                Product(抽象)  
         ↑                          ↑
         |                          |
         |                          |
    FactoryImpl(实现) ---------> ProductImpl(实现)  
 
在示例里，定义了IHeroFactory和IHero接口
- IHeroFactory是抽象工厂：具体工厂必须实现这个接口。在实际的系统中，这个角色也常常使用抽象实现。
- IHero是抽象产品：定义具体产品类所需要实现的逻辑和功能方法。
- FightFactory和StrengthFactory是具体工厂，实现了抽象工厂接口的具体类。
- Hawkeye和Hulk实现具体的逻辑和功能的类。
