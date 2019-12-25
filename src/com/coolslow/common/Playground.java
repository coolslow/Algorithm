package com.coolslow.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author ming
 */
@Documented
@Target(ElementType.TYPE)
public @interface Playground {

    String name() default "";

    public enum Difficulty {
        /** 未知 */
        None,
        /** 简单 */
        Easy,
        /** 中等难度 */
        Medium,
        /** 困难 */
        Hard
    }

    Difficulty rank() default Difficulty.None;
}
