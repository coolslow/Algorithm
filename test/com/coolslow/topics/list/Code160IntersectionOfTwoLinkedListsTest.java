package com.coolslow.topics.list;

import com.coolslow.leetcode.topics.list.Code160IntersectionOfTwoLinkedLists;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code160IntersectionOfTwoLinkedListsTest {

    @Test
    public void testSolution() {
        Code160IntersectionOfTwoLinkedLists solution = new Code160IntersectionOfTwoLinkedLists();
        ListNode headC = ListNodeUtil.getList(new int[]{});

        ListNode headA = ListNodeUtil.getList(new int[]{4, 1});
        headA = ListNodeUtil.join(headA,headC);
        ListNode headB = ListNodeUtil.getList(new int[]{5, 0, 1});
        headB = ListNodeUtil.join(headB,headC);

        ListNode result = solution.getIntersectionNode(headA, headB);
        ListNodeUtil.print(result);
    }
}
