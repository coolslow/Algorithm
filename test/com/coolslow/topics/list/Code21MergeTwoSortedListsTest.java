package com.coolslow.topics.list;

import com.coolslow.leetcode.topics.list.Code21MergeTwoSortedLists;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code21MergeTwoSortedListsTest {

    @Test
    public void testSolution() {
        Code21MergeTwoSortedLists solution = new Code21MergeTwoSortedLists();
        ListNode node1 = ListNodeUtil.getList(new int[]{1, 2, 4});
        ListNode node2 = ListNodeUtil.getList(new int[]{});
        ListNode result = solution.mergeTwoLists(node1, node2);
        ListNodeUtil.print(result);
    }

}