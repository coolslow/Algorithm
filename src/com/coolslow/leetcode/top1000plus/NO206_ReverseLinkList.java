package com.coolslow.leetcode.top1000plus;


import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 206. 反转链表
 *
 * 题目：反转一个链表
 *
 * 输入：1->2->3->4->5->NULL
 * 输出：5->4->3->2->1->NULL
 *
 */
public class NO206_ReverseLinkList {

    /**
     * 解法一：迭代
     *
     * 时间复杂度：时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)
     */
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    /**
     * 解法二：递归
     *
     *
     */
    public static ListNode reverseLinkedListWithRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseLinkedListWithRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}
