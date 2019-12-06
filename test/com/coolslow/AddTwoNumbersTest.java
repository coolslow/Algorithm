package com.coolslow;

import com.coolslow.datastruct.ListNode;
import com.coolslow.leetcode.top100.playground.AddTwoNumbersPlayground;
import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbersTest {
    @Test
    public void shouldAddTwoNumbersCorrectly() {

        ListNode l1 = new ListNode(3);
        System.out.println(l1.val);
        Assert.assertEquals(l1.val, 3);
    }
}
