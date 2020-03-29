package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 86. 分隔链表
 *  给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *  你应当保留两个分区中每个节点的初始相对位置。
 *
 *  示例：
 *      输入：head = 1->4->3->2->5->2, x = 3
 *      输出：输出: 1->2->2->4->3->5
 *
 *  思路：
 *      本题的要求是要我们根据指定的条件改变链表结构：使得值小于x的元素位于值大于等于x元素的前面。
 *      这实质上意味着在改变后的链表中有某个点，在该点之前的元素全部小于x ，该点之后的元素全部大于等于x。
 */
public class NO86_PartitionLinkList {

    /**
     * 解法：双指针法
     * 对该问题的逆向思考 - 将题目提及的节点称之为 JOINT，那么 JOINT 前面的链表和后面的链表可以被视为两个更小的链表。
     * 可以使用两个指针 before 和 after 来追踪这两个链表。两个指针可以用于分别创建两个链表，然后将这两个链表连接即可获得所需链表。
     *
     */
    public static ListNode partitionLinkList(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);

        ListNode before = before_head;
        ListNode after = after_head;

        while(head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            //  处理下一个节点
            head = head.next;
        }

        // 将after指针指向null，表示到了链表的尾端
        after.next = null;
        // 将两个链表连接起来
        before.next = after_head.next;

        return before_head.next;
    }
}
