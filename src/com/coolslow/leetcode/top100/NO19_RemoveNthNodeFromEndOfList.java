package com.coolslow.leetcode.top100;

import com.coolslow.leetcode.top100.datastructure.ListNode;

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
 */
public class NO19_RemoveNthNodeFromEndOfList {

    /**
     * 两次遍历算法
     * 时间复杂度：O(L)，该算法对列表进行了两次遍历，首先计算了列表的长度 L 其次找到第 (L - n) 个结点。 操作执行了 2L-n 步，时间复杂度为 O(L)。
     *
     */
    public ListNode removeNthNodeFromEndOfList(ListNode head, int n) {
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
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
