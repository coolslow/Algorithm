package com.coolslow.playgroundtest;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java QUEUE 中 add/offer, remove/poll, element/peek的区别
 * - https://blog.csdn.net/u012050154/article/details/60572567
 */
public class QueueTest {
    @Test
    public void queueTest() {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.size());
//        queue.add(13);
//        queue.offer(123); // 另一种形式的add，在队列已满时不会报错。
        System.out.println(queue.size());
    }
}
