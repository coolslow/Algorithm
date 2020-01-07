package com.coolslow.leetcode.topics.list;

import com.coolslow.leetcode.topics.list.ds.ListNode;

/**
 * 回文链表
 * by MrThanksgiving
 */
public class Code234PalindromeLinkedList {

    /**
     * <pre>
     * 题目：
     *      请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *      输入: 1->2
     *      输出: false
     *
     * 示例 2:
     *      输入: 1->2->2->1
     *      输出: true
     *
     * 进阶：
     *      你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * </pre>
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int l = 0, r = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lt = head, mt = dummy, rt = dummy, temp;
        while (rt != null && rt.next != null) {
            if (rt.next.next != null) {
                mt = mt.next;
            }
            rt = rt.next.next;
        }
        ListNode curr = mt.next;
        ListNode next = null;
        mt.next = null;
        while (curr != null) {
            temp = curr.next;
            if (rt != null) {
                next = rt;
            }
            rt = curr;
            curr.next = next;
            curr = temp;
        }
        while (lt != null && rt != null) {
            if (lt.val != rt.val) return false;
            lt = lt.next;
            rt = rt.next;
        }
        return true;
    }
    // 快慢指针，反转后半部分链表，时间O(n),空间O(1)
    // 1 先找到中心点。思路就是慢指针移动一步，快指针移动两部。在n/2的位置。并分割为两个链表。
    // 2 反转后半部分链表。中心节点最终会一到最后。
    // 3 在按顺序判断两个链表。

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        int count = 0;
        ListNode temp = head, lt = head, rt = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int l = 0, r = count - 1;
        while (l < r) {
            int i = 0;
            while (i != r) {
                rt = rt.next;
                i++;
            }
            if (lt.val != rt.val) {
                return false;
            }
            lt = lt.next;
            l++;
            rt = head;
            r--;
        }
        return true;
    }
}
