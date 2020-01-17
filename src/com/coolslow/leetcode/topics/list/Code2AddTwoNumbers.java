package com.coolslow.leetcode.topics.list;

import com.coolslow.leetcode.topics.list.ds.ListNode;

/**
 * 两数相加
 * by MrThanksgiving
 */
public class Code2AddTwoNumbers {

    /**
     * <pre>
     * 题目：
     *      给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
     *      并且它们的每个节点只能存储 一位 数字。
     *      如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *      您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *      输出：7 -> 0 -> 8
     *      原因：342 + 465 = 807
     *
     * </pre>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            if (node == null) {
                node = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            tail.next = temp;
            tail = temp;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            tail.next = temp;
            tail = temp;
            l2 = l2.next;
        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            tail.next = temp;
            tail = temp;
        }
        return node;
    }

}
