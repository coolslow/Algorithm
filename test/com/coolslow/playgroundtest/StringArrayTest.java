package com.coolslow.playgroundtest;

import org.junit.Test;

public class StringArrayTest {
    @Test
    public void strArrayTest() {
        String test = "[ 1, 3, 9, null, null, 4, 5, 6]";
        String[] nodes = test.substring(1, test.length() - 1).split(",");
        for(int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i]);
        }
    }
}
