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
        // 声明一个null节点
        ListNode prev = null;
        // 声明一个curr节点，将curr节点指向传入的head链表的表头
        ListNode curr = head;

        while(curr != null) {
            // 存储头节点的下一个节点的信息
            ListNode nextTemp = curr.next;
            // 当前节点的下一个节点（这里当curr.next指第一个节点的下一个节点，从头节点开始那么它必然指向null）
            curr.next = prev;
            // 用prev来存储之前的头节点
            prev = curr;
            // 将当前节点设置为之前存储的第二个节点，实现链表指向的反转
            curr = nextTemp;
        }

        return prev;
    }

    /**
     * 解法二：递归
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
