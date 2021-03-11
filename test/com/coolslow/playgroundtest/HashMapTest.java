package com.coolslow.playgroundtest;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void testHashMap() {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[] {3, 9, 20, 15, 7};

        int len = arr.length;
        for(int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }
        System.out.println(map);
        System.out.println(map.get(20));
        System.out.println(map.get(21));
        Assert.assertEquals(null, map.get(21));
    }
}
