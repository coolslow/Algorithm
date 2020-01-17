package com.coolslow.leetcode.topics.list;

import com.coolslow.leetcode.topics.list.ds.ListNode;

/**
 * 奇偶链表
 * by MrThanksgiving
 */
public class Code328OddEvenLinkedList {

    /**
     * <pre>
     * 题目：
     *      给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，
     *      这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     *      请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 示例 1:
     *      输入: 1->2->3->4->5->NULL
     *      输出: 1->3->5->2->4->NULL
     *
     * 示例 2:
     *      输入: 2->1->3->5->6->4->7->NULL
     *      输出: 2->3->6->7->1->5->4->NULL
     *
     * 说明:
     *      应当保持奇数节点和偶数节点的相对顺序。
     *      链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     *
     * </pre>
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        int index = 1;
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (index % 2 == 1) {
                ListNode n = new ListNode(head.val);
                if (oddHead == null) {
                    oddHead = n;
                    oddTail = n;
                } else {
                    oddTail.next = n;
                    oddTail = n;
                }
            } else {
                ListNode n = new ListNode(head.val);
                if (evenHead == null) {
                    evenHead = n;
                    evenTail = n;
                } else {
                    evenTail.next = n;
                    evenTail = n;
                }
            }
            head = next;
            index++;
        }
        oddTail.next = evenHead;
        return oddHead;
    }

}
