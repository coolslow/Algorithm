package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 82.  删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 *
 * 示例1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 */
public class NO82_RemoveDuplicateFromSortedListII {

    public static ListNode deleteDuplicatesWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            while (head.next!= null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicatesWithRecursion(head.next);
        } else {
            head.next = deleteDuplicatesWithRecursion(head.next);
            return head;
        }
    }
}
