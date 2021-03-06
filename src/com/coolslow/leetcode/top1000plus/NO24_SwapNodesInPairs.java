package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 注意：你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例：
 *      给定 1->2->3->4, 应该返回 2->1->4->3.
 */
public class  NO24_SwapNodesInPairs {
    /**
     * 方法一：递归方法
     *
     * 算法：
     * - 从链表的头结点开始递归
     * - 每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点
     * - 下一次递归是传递的下一对需要交换的两个节点。若链表还有节点，则继续递归。
     * - 交换了两个节点之后，返回 secondNode，因为它是交换后的新头。
     * - 在所有节点交换完成之后，我们返回交换后的头，实际上是原始链表的第二个节点。
     *
     *
     * 复杂度分析：
     *    - 时间复杂度：O(N)，其中 N 指的是链表的节点数量。
     *    - 空间复杂度：O(N)，递归过程使用的堆栈空间。
     */
    public static ListNode swapPairsNodes(ListNode head) {
        // 如果链表没有节点或者链表只有一个节点的情况，也是递归停止的条件
        if(head == null || head.next == null) {
            return head;
        }

        // 设置需要交换的两个节点（分别是链表的第一个节点和第二个节点）
        // 把第一个节点设置为头节点
        ListNode firstNode = head;
        // 头节点的下一个节点就是第二个节点
        ListNode secondNode = head.next;

        // 递归执行节点的两两交换
        firstNode.next = swapPairsNodes(secondNode.next);
        // 第二个节点的下一个节点指向第一个节点（进行了交换）
        secondNode.next = firstNode;

        return secondNode;
    }

    /**
     * 方法二：迭代
     *
     * 将链表分成两部分：奇数节点为一部分；偶数节点为另一部分。
     *
     * 复杂度分析：
     *  - 时间复杂度：O(N)
     *  - 空间复杂度：O(1)
     *
     */
    public static ListNode swapPairsWithIteration(ListNode head) {
        // 将dummy node 看作输入链表的前一个节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while(head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 交换节点
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }
}
