# 观察者模式 ｜ 发布-订阅模式

> 定义对象之间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都会得到通知并自动更新。

观察者模式也被称为：发布-订阅模式。
广义的观察者模式包括所有消息系统。所谓消息系统，就是把观察者和被观察者完全分离，通过消息系统本身来通知。

消息发送方被称为：Producer，消息接受方被称为Consumer，Producer发送消息的时候，必须选择发送到哪个Topic。
Consumer可以订阅自己感兴趣的Topic，从而只获取特定类型的消息。

## 一些注意
Java标准库有个java.util.Observable类和一个Observer接口，用来帮助我们实现观察者模式。
但是，这个类非常不！好！用！实现观察者模式的时候，也不推荐借助这两个东东。

# 参考
- https://www.runoob.com/design-pattern/observer-pattern.html
- https://www.liaoxuefeng.com/wiki/1252599548343744/1281319577321505
- https://juejin.im/post/5cd262fcf265da039e2008e1