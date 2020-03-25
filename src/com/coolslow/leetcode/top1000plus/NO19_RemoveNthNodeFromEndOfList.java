package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 19.删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *  给定一个链表: 1->2->3->4->5, 和 n = 2.
 *  当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *  给定的 n 保证是有效的。
 *
 *  备注：请尝试使用一趟遍历
 *
 *
 */
public class NO19_RemoveNthNodeFromEndOfList {

    /**
     * 方法一：两次遍历算法
     * 时间复杂度：O(L)，该算法对列表进行了两次遍历，首先计算了列表的长度 L 其次找到第 (L - n) 个结点。 操作执行了 2L-n 步，时间复杂度为 O(L)。
     *
     */
    public static ListNode removeNthNodeFromEndOfList(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        // 计算列表的长度
        while(first != null) {
            length++;
            first = first.next;
        }
        // 找到第(L-n)个节点的位置下标
        length -= n;
        // 在上一次循环中，first已经指向了链表的尾部，那么first = dummy将重新指向链表头部。
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        // 删除倒数第n个位置上的节点
        first.next = first.next.next;

        return dummy.next;
    }

    /**
     * 方法二：一次遍历
     *
     * 采用双指针的方式，第一个指针从列表的开头向前移动 n + 1 步，而第二个指针从链表的开头出发。
     * 此时，这两个指针的间距为n。同时移动两个指针，向前保持这种恒定间隔。直到第一个指针到达最后一个节点。
     */
    public static ListNode removeTheNthFromEndOfListNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // 先让第一个指针向前移动 n 步。
        for(int i = 0; i <= n; i++) {
            first = first.next;
        }

        // 再让两个指针同时先前移动
        while(first != null) {
            first = first.next;
            second = second.next;
        }

        // 删除倒数 n 位置的节点
        second.next = second.next.next;
        return dummy.next;
    }
}
