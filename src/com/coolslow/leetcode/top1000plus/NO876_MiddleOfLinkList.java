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
     * 解法一：数组
     *
     * 链表的缺点是不能通过下标访问对应的元素。因此，可以考虑对链表进行遍历，将遍历到的元素依次放入数组中。
     * 如果我们遍历到了N个元素，那么链表对应的数组长度也为N，对应的中间节点即为下标 N/2 的数组元素
     */
    public static ListNode middleNode(ListNode head) {
        ListNode[] listNodes = new ListNode[100];

        int index = 0;
        while(head != null) {
            listNodes[index++] = head;
            head = head.next;
        }

        return listNodes[index / 2];
    }

    /**
     * 解法二：单指针法
     *
     * 可以对方法进行进一步的空间优化，省去存储链表数据的数组空间。
     * 可以对链表进行两次遍历。第一次遍历时，统计链表中元素的个数；
     * 第二次遍历时，遍历到第 N/2 个元素后，返回该元素就可以了。
     *
     */
    public static ListNode getMiddleNode(ListNode head) {
        int n = 0;
        ListNode cur = head;

        // 第一次遍历，获取链表的长度
        while(cur != null) {
            // n 自增
            ++n;
            cur = cur.next;
        }

        int k = 0;

        // 第二次遍历，获取中间节点，并返回
        while(k < n/2) {
            ++k;
            cur = cur.next;
        }

        return cur;
    }

    /**
     *
     *  解法三：快慢指针
     *
     *  使用慢指针 slow 和 快指针fast 两个指针同时遍历链表。
     *  快指针一次前进两个结点，速度是慢指针的两倍。
     *
     *  注意：
     *  - 循环的条件是 fast != null && fast.next != null，防止出现空指针异常。
     *  - 注意链表结点为奇数个和偶数个的时候，链表中点的含义不一样。不过这种写法正好能满足题意。
     */
    public static ListNode findMiddleOfLinkList(ListNode head) {
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
