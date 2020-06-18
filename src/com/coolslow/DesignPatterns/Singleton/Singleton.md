# 单例模式

保证一个类只能有一个实例，并提供一个访问它的全局访问点。
单例模式的目的是为了保证一个进程中，某个类只有一个实例。

因为这个类只有一个实例，因此，自然不能让调用方使用 new 关键字来创建。
因此，单例的构造方法必须是private（私有）的。这样可以防止调用方法自己创建实例，但在类的内部
可以用一个静态字段来引用唯一创建的实例。

```java
```