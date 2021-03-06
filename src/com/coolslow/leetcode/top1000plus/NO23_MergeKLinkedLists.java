package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */
public class NO23_MergeKLinkedLists {

    /**
     * 方法 - K个指针：K个指针分别指向K个链表
     *
     * 每次O(K)比较K个指针求min，时间复杂度为：O(N * K)
     *
     * @param lists k个链表
     * @return 返回k个合并后的链表
     */
    public static ListNode mergeKLinkedList(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while(true) {
            ListNode minNode = null;
            int minPointer = -1;
            for(int i = 0; i < k; i++) {
                if(lists[i] == null) {
                    continue;
                }

                if(minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if(minPointer == -1) {
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyHead.next;
    }

    /**
     * 使用小根堆对 1 进行优化，每次 O(logK)比较 K个指针求 min, 时间复杂度：O(NlogK)
     * @param lists k个链表
     * @return 返回k个合并后的链表
     */
    public static ListNode mergeKLinkedListII(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        for(ListNode node: lists) {
            if(node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;

            if(minNode.next !=null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }
}
