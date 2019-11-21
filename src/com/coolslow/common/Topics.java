package com.coolslow.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
public @interface Topics {

    public enum Tags {
        None, // 默认选项
        String, // 字符串
        Sorting, // 排序
        Array, // 数组
        LinkList, // 链表
        Tree, // 树
        Graph, // 图
        Math, // 数学计算
        Dynamic, // 动态规划
        Greedy, // 贪心算法
        Stack, // 栈
        Heap, // 堆
        Search, // 查找
    }

    Tags tags() default Tags.None;
}
