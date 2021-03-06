package com.coolslow.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author ming
 */
@Documented
@Target(ElementType.METHOD)
public @interface Solution {
    String desc() default "";
}
