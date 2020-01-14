package com.coolslow.topics.list;

import com.coolslow.leetcode.topics.list.Code328OddEvenLinkedList;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code328OddEvenLinkedListTest {

    @Test
    public void testSolution() {
        Code328OddEvenLinkedList solution = new Code328OddEvenLinkedList();
//        int[] input = {1, 2, 3, 4, 5};
//        int[] input = {1};
//        int[] input = {1,2};
//        int[] input = {1,2,3};
        int[] input = {1,2,3};
        ListNode node = ListNodeUtil.getList(input);
        ListNode result = solution.oddEvenList(node);
        ListNodeUtil.print(result);
    }
}
