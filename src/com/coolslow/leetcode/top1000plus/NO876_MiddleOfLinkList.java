package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 876. 链表的中间节点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 * 输入：[1, 2, 3, 4, 5]
 * 输出：此列表中的结点3（序列化形式：[3, 4, 5]）
 * 注意，我们返回了一个ListNode类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next.val = NULL.
 *
 * 示例 2：
 * 输入：[1, 2, 3, 4, 5, 6]
 * 输出：此列表中的结点 4，(序列化形式：[4, 5, 6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 提示：给定链表的结点介于 1 和 100 之间。
 *
 */
public class NO876_MiddleOfLinkList {

    /**
     *
     *  解法一：快慢指针
     *
     *  使用慢指针 slow 和 快指针fast 两个指针同时遍历链表。
     *  快指针一次前进两个结点，速度是慢指针的两倍。
     *
     *  注意：
     *  - 循环的条件是 fast != null && fast.next != null，防止出现空指针异常。
     *  - 注意链表结点为奇数个和偶数个的时候，链表中点的含义不一样。不过这种写法正好能满足题意。
     */
    public ListNode findMiddleOfLinkList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // fast 一次前进两个元素，slow 一次前进一个元素
            fast = fast.next.next;
            slow = slow.next;
        }
        // 链表元素为奇数个时，slow 指向链表的中点
        // 链表元素为偶数个时，slow 指向链表两个中点的右边一个
        return slow;
    }
}
