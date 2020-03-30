package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

import java.util.Set;
import java.util.HashSet;

/**
 * 141. 环形链表
 *
 * 题目：给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * REFERENCE: https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class NO141_LinkListCycle {

    /**
     * 解法一：哈希表
     *
     * 思路：我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
     * - 时间复杂度O(n)，对于含有n个元素的链表，访问每个元素最多一次，添加一个节点到哈希表只需花费O(1)的时间。
     * - 空间复杂度O(n)，空间取决于添加到哈希表中的元素数目，最多可添加n个元素。
     */
    public static boolean hasCycleWithHashSet(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 解法二：双指针
     * 思路：通过使用具有不同速度的 快、慢两个指针遍历链表，空间复杂度可以被降低至O(1)。慢指针每次移动一步，而快指针每次移动两步。
     *      如果列表中不存在环，最终快指针将会最先到达尾部，此时，可以返回 false。
     *
     */
    public boolean hasCycleWithTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 快指针到达链表尾端的情况
            if (fast == null || fast.next == null) {
                return false;
            }

            // 否则，继续按快指针一次走两步，慢指针一次走一步的方式循环
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
