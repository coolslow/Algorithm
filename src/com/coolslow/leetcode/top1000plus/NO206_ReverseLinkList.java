package com.coolslow.leetcode.top1000plus;


import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

/**
 * 206. 反转链表
 *
 * 题目：反转一个链表
 *
 * 输入：1->2->3->4->5->NULL
 * 输出：5->4->3->2->1->NULL
 *
 */
public class NO206_ReverseLinkList {

    /**
     * 解法一：迭代
     *
     * 时间复杂度：时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)
     */
    public static ListNode reverseLinkedList(ListNode head) {
        // 声明一个null节点
        ListNode prev = null;
        // 声明一个curr节点，将curr节点指向传入的head链表的表头
        ListNode curr = head;

        while(curr != null) {
            // 将当前节点的下一个节点信息暂存在nextTemp节点中
            ListNode nextTemp = curr.next;
            // 当前节点的下一个节点（这里当curr.next指第一个节点的下一个节点，从头节点开始那么它必然指向null）
            // 即：如果是头节点，那么反转之后，头节点会成为最后一个节点，最后一个节点必然指向null
            curr.next = prev;
            // 用prev来存储之前的头节点
            prev = curr;
            // 将当前节点设置为之前存储的第二个节点，实现链表指向的反转
            curr = nextTemp;
        }

        return prev;
    }

    /**
     * 解法二：递归
     *
     * 递归算法解题思路：
     * 从第一个节点开始遍历，当遍历到最后一个节点时，将最后一个节点返回。通过 head.next.next = head 来使两个节点互相连接
     * 在通过 head.next = null 使其不会形成闭环，依次往前对节点进行如上操作。
     *
     * 例如：链表 head 是 1 -> 2 -> 3 -> 4 -> 5 -> null，通过递归遍历到最后一个节点，这时 head 是第四个节点
     * reverseLinkedListWithRecursive(head.next) 返回第五个节点，此时，他们的关系如下：
     *
     * 第一步：head -> head.next -> null
     *
     * 继续向下走，经过 head.next.next = head, 使得 head.next.next 从 null 变为 head。
     * 所以他们的关系就变成如下样子：
     *
     * 第二步：head ----> head.next -❌-> null
     *             <----
     *
     * 第三步：为了防止形成闭环，因此 head.next = null， 达到如下效果
     *        head.next ---> head ---> null
     */
    public static ListNode reverseLinkedListWithRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseLinkedListWithRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}
