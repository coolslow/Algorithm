package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 *
 * 题目：请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *      输入: 1->2
 *      输出: false
 *
 * 示例 2:
 *      输入: 1->2->2->1
 *      输出: true
 *
 */

public class NO234_PalindromeLinkList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    // NOTE: 中规中矩的解法，将链表中的数据放入数组中，通过头尾指针对数据进行比较，相等为回文，否则不是回文。
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        ListNode currentNode = head;
        // 将链表中的数据放入ArrayList中
        while(currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 设置头尾两个指针，判断头尾指针指向的元素是否相等
        int front = 0;
        int back = vals.size() - 1;
        while(front < back) {
            if(!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }

        return true;
    }
}
