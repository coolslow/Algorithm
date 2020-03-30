package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 *
 * 题目：给定一个链表，返回链表开始入环的第一个节点，如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * REFERENCE: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * 示例1：
 *      输入：head = [3, 2, 0, -4]，pos = 1
 *      输出：tail connects to node index 1
 *      解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例2：
 *      输入：head = [1, 2], pos = 0
 *      输出：tail connects to node index 0
 *      解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例3：
 *      输入：head = [1], pos = -1
 *      输出：no cycle
 *      解释：链表中没有环。
 */
public class NO142_LinkListCycleII {

    /**
     * 解法一：哈希表
     *
     * 思路：如果用一个Set保存已经访问过的节点，我们可以遍历整个列表并返回第一个出现重复的节点。
     *
     * 算法复杂度分析：
     *      - 时间复杂度O(N)
     *      - 空间复杂度O(N)
     *
     * @param head 给定的链表
     * @return 返回链表入环的节点
     */
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> visted = new HashSet<>();

        ListNode node = head;
        while(node != null) {
            if(visted.contains(node)) {
                return node;
            }
            visted.add(node);
            node = node.next;
        }

        return null;
    }
}
