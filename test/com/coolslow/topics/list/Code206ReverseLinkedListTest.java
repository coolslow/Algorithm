package com.coolslow.topics.list;

import com.coolslow.leetcode.topics.list.Code206ReverseLinkedList;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code206ReverseLinkedListTest {

    @Test
    public void testSolution() {
        Code206ReverseLinkedList solution = new Code206ReverseLinkedList();
//        ListNode node = ListNodeUtil.getList(new int[]{1, 2, 3, 4, 5});
        ListNode node = ListNodeUtil.getList(new int[]{1});
        ListNode result = solution.reverseList(node);
        ListNodeUtil.print(result);
    }
}
