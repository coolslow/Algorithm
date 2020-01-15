package com.coolslow.leetcode.top100plus;

import com.coolslow.leetcode.top100plus.datastructure.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *  输入：1->2->4, 1->3->4
 *  输出：1->1->2->3->4->4
 */
public class NO21_MergeTwoSortedLinkList {

    /**
     * 方法一：递归
     *
     *  - list1[0] + merge(list1[1:], list2)    |  list1[0] < list2[0]
     *  - list2[0] + merge(list1, list2[1:])    |  otherwise
     *
     * 复杂度分析：
     *  - 时间复杂度O(n+m)，因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），函数 mergeTwoList 中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系。
     *  - 空间复杂度：O(n + m)。调用 mergeTwoLists 退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以 n + m 个栈帧会消耗 O(n + m) 的空间。
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并后的链表
     */
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else if(l1.val < l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    /**
     * 方法二：迭代
     *;
     * 设置一个哨兵节点"prehead"，这可以在最后比较容易的返回合并后的链表。
     *
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并后的链表
     */
    public ListNode mergeTwoListIteration(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
