package com.coolslow.topics.list;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.list.Code19RemoveNthNodeFromEndOfList;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code19RemoveNthNodeFromEndOfListTest {

    @Test
    public void testSolution() {
        Code19RemoveNthNodeFromEndOfList solution = new Code19RemoveNthNodeFromEndOfList();
        int[][] array = {{1, 2, 3,4,5},{1, 2, 3,4},{1, 2, 3}, {1, 2},{1}};
        for (int[] arr : array) {
            MyUtils.printArray(arr);
            for (int i = 1; i <= arr.length; i++) {
                ListNode node = ListNodeUtil.getList(arr);
                MyUtils.printMarkLine(i + "");
                ListNode result = solution.removeNthFromEnd(node, i);
                ListNodeUtil.print(result);
            }

        }

    }
}
