package com.coolslow.playgroundtest;

import org.junit.Test;

import java.util.LinkedList;

public class LinkListTest {

    @Test
    public void LinkListTest() {
        int[] test = new int[] {1, 2, 3, 5, 6, 4};
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < test.length; i++) {
            queue.add(test[i]);
        }

        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.add(10));
        System.out.println(queue);
    }
}
