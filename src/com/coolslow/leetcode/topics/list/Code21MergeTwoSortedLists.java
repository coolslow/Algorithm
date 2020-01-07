package com.coolslow.leetcode.topics.list;

import com.coolslow.leetcode.topics.list.ds.ListNode;

/**
 * 合并链表
 * by MrThanksgiving
 */
public class Code21MergeTwoSortedLists {

    /**
     * <pre>
     * 题目：
     *      将两个有序链表合并为一个新的有序链表并返回。
     *      新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     *      输入：1->2->4, 1->3->4
     *      输出：1->1->2->3->4->4
     *
     * </pre>
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode lt = l1, rt = l2, temp, tail = null;
        while (lt != null && rt != null) {
            if (lt.val < rt.val) {
                temp = new ListNode(lt.val);
                lt = lt.next;
            } else {
                temp = new ListNode(rt.val);
                rt = rt.next;
            }
            if (dummy.next == null)
                dummy.next = temp;
            if (tail == null) {
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        while (lt != null) {
            temp = new ListNode(lt.val);
            tail.next = temp;
            tail = temp;
            lt = lt.next;
        }
        while (rt != null) {
            temp = new ListNode(rt.val);
            tail.next = temp;
            tail = temp;
            rt = rt.next;
        }
        return dummy.next;
    }

}
