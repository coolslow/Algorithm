package com.coolslow.topics.list;

import com.coolslow.leetcode.topics.list.Code237DeleteNodeInALinkedList;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * 删除链表中的节点
 * by MrThanksgiving
 */
public class Code237DeleteNodeInALinkedListTest {

    @Test
    public void testSolution() {
        Code237DeleteNodeInALinkedList solution = new Code237DeleteNodeInALinkedList();
        ListNode node = ListNodeUtil.getList(new int[]{1, 2, 3, 4, 5});
        ListNode n = new ListNode(3);
        solution.deleteNode(n);
        ListNodeUtil.print(node);
    }


}
