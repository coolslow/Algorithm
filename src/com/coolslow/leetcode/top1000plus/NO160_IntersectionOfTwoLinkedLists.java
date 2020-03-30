package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 160. 相交链表
 *
 * 题目：编写一个程序，找到两个单链表相交的起始节点。
 * 例如：
 *             a1 -> a2
 *                     \
 *                     c1 -> c2 -> c3
 *                    /
 *      b1 -> b2 -> b3
 */
public class NO160_IntersectionOfTwoLinkedLists {

    /**
     * 解法一：暴力法
     * 遍历链表 A 并将每个节点的地址/引用存储在哈希表中。然后检查链表B中的每一个节点是否在哈希表中。
     * 如果存在，则存在的点为相交节点。
     *
     * 复杂度分析：
     *  - 时间复杂度：O(m * n)。[m 和 n 是两个链表的长度]
     *  - 空间复杂度：O(1)。
     */

    /**
     * 解法三：双指针法
     *
     * 复杂度分析：
     *  - 时间复杂度：O(m + n)。[m 和 n 是两个链表的长度]
     *  - 空间复杂度：O(1)。
     *
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
