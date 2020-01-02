package com.coolslow.leetcode.top100;

import com.coolslow.leetcode.top100.datastructure.ListNode;

/**
 * @author ming
 *
 * 2. 两数相加
 * 给定两个 [非空] 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 [逆序] 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加，则会返回一个新的链表来表示它们的和。
 * 你可以假设：除了数字 0 之外，这两个数都不会以0开头。
 *
 * 示例：
 *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      输出：7 -> 0 -> 8
 *      原因：342 + 456 = 807
 *
 * 相关标签：链表、数字
 *
 */
public final class NO02_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        // 将当前指针指向head，即新创建的链表的头部
        ListNode p = l1, q = l2, curr = head;
        // 进位
        int carry = 0;

        while(p!= null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(p != null) {
                p = p.next;
            }

            if(q != null) {
                q = q.next;
            }
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }
}
