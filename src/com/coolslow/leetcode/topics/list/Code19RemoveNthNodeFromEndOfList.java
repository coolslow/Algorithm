package com.coolslow.leetcode.topics.list;

import com.coolslow.leetcode.topics.list.ds.ListNode;

/**
 * 删除链表的倒数第N个节点
 * by MrThanksgiving
 */
public class Code19RemoveNthNodeFromEndOfList {

    /**
     * <pre>
     * 题目：
     *      给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *      给定一个链表: 1->2->3->4->5, 和 n = 2.
     *      当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * 说明：
     *      给定的 n 保证是有效的。
     *
     * 进阶：
     *      你能尝试使用一趟扫描实现吗？
     *
     * </pre>
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int r = 0;
        ListNode lt = dummy;
        ListNode rt = dummy;
        while (r <= n) {
            r++;
            rt = rt.next;
        }
        while (rt != null) {
            lt = lt.next;
            rt = rt.next;
        }
        lt.next = lt.next.next;
        return dummy.next;
    }
    // 双指针。主要是快慢指针之间保持n的距离。当快指针为null时，慢指针正好在要删除的节点前面。

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0, index = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = dummy;
        while (index < count - n) {
            index++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }


    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null) return null;
        int count = 0, index = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head;
        while (index < count - n - 1) {
            index++;
            temp = temp.next;
        }
        if (temp == head) {
            if (count - 1 == n)
                head.next = head.next.next;
            else
                head = head.next;
        } else {
            if (temp.next != null && temp.next.next != null) {
                temp.next.val = temp.next.next.val;
                temp.next.next = temp.next.next.next;
            } else {
                temp.next = null;
            }
        }
        return head;
    }

}
