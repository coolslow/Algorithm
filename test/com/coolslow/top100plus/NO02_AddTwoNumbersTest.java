package com.coolslow.top100plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class NO02_AddTwoNumbersTest {
    @Test
    public void shouldAddTwoNumbersCorrectly() {

        ListNode l1 = new ListNode(3);
        System.out.println(l1.val);
        Assert.assertEquals(l1.val, 3);
    }
}
