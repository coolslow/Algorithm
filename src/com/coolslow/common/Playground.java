package com.coolslow.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
public @interface Playground {

    String name() default "";

    public enum Difficulty {
        None, // 未知
        Easy, // 简单
        Medium, // 中等难度
        Hard, // 困难
    }

    Difficulty rank() default Difficulty.None;
}
