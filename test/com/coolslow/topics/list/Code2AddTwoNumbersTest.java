package com.coolslow.topics.list;

import com.coolslow.leetcode.topics.list.Code2AddTwoNumbers;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code2AddTwoNumbersTest {

    @Test
    public void testSolution() {
        Code2AddTwoNumbers solution = new Code2AddTwoNumbers();
        ListNode l1 = ListNodeUtil.getList(new int[]{5});
        ListNode l2 = ListNodeUtil.getList(new int[]{5});
        ListNode result = solution.addTwoNumbers(l1, l2);
        ListNodeUtil.print(result);
    }
}
