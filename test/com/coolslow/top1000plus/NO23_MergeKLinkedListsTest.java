package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO23_MergeKLinkedLists;
import com.coolslow.leetcode.top1000plus.datastructure.ListNode;
import org.junit.Test;

public class NO23_MergeKLinkedListsTest {

    @Test
    public void shouldMergeKLinkedListCorrectly() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(9);

        ListNode expect = new ListNode(1);
        expect.next = new ListNode(2);
        expect.next.next = new ListNode(2);
        expect.next.next.next = new ListNode(3);
        expect.next.next.next.next = new ListNode(3);
        expect.next.next.next.next.next = new ListNode(4);
        expect.next.next.next.next.next.next = new ListNode(5);
        expect.next.next.next.next.next.next.next = new ListNode(9);

        ListNode[] lists = new ListNode[] { head, head2 };

        ListNode result = NO23_MergeKLinkedLists.mergeKLinkedList(lists);
    }
}
