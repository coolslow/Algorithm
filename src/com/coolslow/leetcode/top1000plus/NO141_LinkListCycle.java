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
    public boolean hasCycleWithHashSet(ListNode head) {
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
     *
     *
     */
    public boolean hasCycleWithTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
