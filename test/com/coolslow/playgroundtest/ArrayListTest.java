package com.coolslow.playgroundtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    @Test
    public void testArrayList() {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());

        list.add(0, 1);
        list.add(0, 2);
        System.out.println(list);
    }
}
