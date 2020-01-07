package com.coolslow.topics.list;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.list.Code141LinkedListCycle;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code141LinkedListCycleTest {

    @Test
    public void testSolution() {
        Code141LinkedListCycle solution = new Code141LinkedListCycle();
        int[] nums = {3, 2, 0, -4};
        ListNode node = ListNodeUtil.getList(nums);
        ListNode last = ListNodeUtil.getLastList(node);
        last.next = node.next;
        boolean result = solution.hasCycle(node);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
