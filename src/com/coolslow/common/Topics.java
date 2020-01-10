package com.coolslow.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author ming
 */
@Documented
@Target(ElementType.METHOD)
public @interface Topics {

    public enum Tags {
        /** 默认选项 */
        None,
        /** 字符串 */
        String,
        /** 排序 */
        Sorting,
        /** 数组 */
        Array,
        /** 链表 */
        LinkList,
        /** 树 */
        Tree,
        /** 图 */
        Graph,
        /** 数学计算 */
        Math,
        /** 动态规划 */
        Dynamic,
        /** 贪心算法 */
        Greedy,
        /** 栈 */
        Stack,
        /** 堆 */
        Heap,
        /** 查找 */
        Search
    }

    Tags tags() default Tags.None;
}
