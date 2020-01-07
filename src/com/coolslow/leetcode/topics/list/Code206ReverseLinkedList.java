package com.coolslow.leetcode.topics.list;

import com.coolslow.leetcode.topics.list.ds.ListNode;

/**
 * 反转链表
 * by MrThanksgiving
 */
public class Code206ReverseLinkedList {

    /**
     * <pre>
     * 题目：
     *      反转一个单链表。
     *
     * 示例:
     *      输入: 1->2->3->4->5->NULL
     *      输出: 5->4->3->2->1->NULL
     *
     * 进阶:
     *      你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * </pre>
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode temp, next;
        while (curr != null) {
            temp = curr.next;
            next = dummy.next;
            dummy.next = curr;
            curr.next = next;
            curr = temp;
        }
        return dummy.next;
    }

}
