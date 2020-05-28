package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO23_MergeKLinkedLists;
import com.coolslow.leetcode.top1000plus.datastructure.ListNode;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NO23_MergeKLinkedListsTest {

    @Test
    public void shouldMergeKLinkedListCorrectly() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);

        ListNode head2 = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(9);

        List<ListNode> listNodes = new ArrayList<>();
    }
}
