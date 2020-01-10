package com.coolslow.leetcode.top100;

import com.coolslow.leetcode.top100.datastructure.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *  输入: 1->1->2
 *  输出: 1->2
 *
 * 示例 2:
 *  输入: 1->1->2->3->3
 *  输出: 1->2->3
 *
 */
public class NO83_RemoveDuplicatesFromSortedList {

    /** 普通的解决办法 */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                ListNode node = cur.next;
                cur.next = node.next;
                // 清除野指针
                node.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /** 采用递归办法解决 */
    public ListNode deleteDuplicatesWithRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        if(cur.val == head.val) {
            cur = cur.next;
            while(cur != null && cur.val == head.val) {
                cur = cur.next;
            }
        }
        head.next = deleteDuplicates(cur);
        return head;
    }
}
