package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 61. 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例1：
 *      输入: 1->2->3->4->5->NULL, k = 2
 *      输出: 4->5->1->2->3->NULL
 *      解释:
 *      向右旋转 1 步: 5->1->2->3->4->NULL
 *      向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 *
 *      输入: 0->1->2->NULL, k = 4
 *      输出: 2->0->1->NULL
 *      解释:
 *      向右旋转 1 步: 2->0->1->NULL
 *      向右旋转 2 步: 1->2->0->NULL
 *      向右旋转 3 步: 0->1->2->NULL
 *      向右旋转 4 步: 2->0->1->NULL
 *
 */
public class NO61_RotateLinkList {

    /**
     * 方法：
     *
     * 链表中的点已经相连，一次旋转操作意味着：
     * - 先将链表闭合成环
     * - 找到相应的位置断开这个环，确定新的链表表头和表尾
     *
     * 新链表的表头在：n - k 的位置。其中 n 表示链表中节点的个数。新的链表表为就在头的前面，位于位置：n - k - 1。
     *
     * [Q]：但是，如果 k >= n 该如何处理呢？[A]：可以采用 k % n的方式
     *
     * 时间复杂度：O(N)，其中 N 是链表中的元素个数
     * 空间复杂度：O(1)，因为只需要常数的空间
     *
     */
    public static ListNode rotateLinkList(ListNode head, int k) {
        // 考虑基本情况
        if(head == null || head.next == null) {
            return head;
        }

        ListNode oldTail = head;
        // 获取链表的长度
        int n;
        for(n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }

        // 将链表合为一个闭环
        oldTail.next = head;

        // 找到新的链表表尾 : (n - k % n - 1)th node
        // 找到新的链表表头 : (n - k % n)th node
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }

        // 设置新的链表表头
        ListNode newHead = newTail.next;

        // 打破环形链表，将表尾设置为null
        newTail.next = null;

        return newHead;
    }
}
