package com.coolslow.playgroundtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Deque是一种队列，它允许两头都进，两头都出，(Double Ended Queue)。
 * 功能：
 *  - 既可以添加到队尾，也可以添加到队头
 *  - 既可以从队首获取，也可以从队尾获取
 */
public class DequeTest {

    @Test
    public void dequeTest() {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        System.out.println(deque);
        System.out.println(deque.size());

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peek());
    }
}
