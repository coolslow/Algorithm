package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 92. 反转链表II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class NO92_ReverseLinkedListII {
    /**
     * 解法:
     *
     * 1. 找到待反转的节点的前一个节点
     * 2. 反转 m -> n 的部分
     * 3. 将反转的起点的next指向发转的后面一部分
     * 4. 将第一步找到的节点指向反转以后的头节点
     *
     * 参考：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/ji-bai-liao-100de-javayong-hu-by-reedfan-6/
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode node = res;
        // 找到需要反转的部分的前一个节点。
        for(int i = 1; i < m; i++) {
            node = node.next;
        }

        // node.next就是需要反转的部分的起点
        ListNode nextHead = node.next;
        ListNode next = null;
        ListNode pre = null;

        for(int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        // 将反转的起点的next指向next。
        node.next.next = next;
        // 需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
        node.next = pre;
        return res.next;
    }
}
