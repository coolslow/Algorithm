package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 203. 移除链表元素
 *
 * 题目：删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *  输入: 1->2->6->3->4->5->6, val = 6
 *  输出: 1->2->3->4->5
 *
 */
public class NO203_RemoveLinkListElement {

    public static ListNode removeLinkListElement(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, curr = head;
        while(curr != null) {
            if(curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }
        return dummy.next;
    }
}
