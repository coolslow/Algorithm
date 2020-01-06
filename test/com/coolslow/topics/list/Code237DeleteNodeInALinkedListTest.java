package com.coolslow.topics.list;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.list.Code237DeleteNodeInALinkedList;
import org.junit.Test;

/**
 * 删除链表中的节点
 * by MrThanksgiving
 */
public class Code237DeleteNodeInALinkedListTest {

    @Test
    public void testSolution() {
        Code237DeleteNodeInALinkedList solution = new Code237DeleteNodeInALinkedList();

        Code237DeleteNodeInALinkedList.ListNode n1 = new Code237DeleteNodeInALinkedList.ListNode(1);
        Code237DeleteNodeInALinkedList.ListNode n2 = new Code237DeleteNodeInALinkedList.ListNode(2);
        Code237DeleteNodeInALinkedList.ListNode n3 = new Code237DeleteNodeInALinkedList.ListNode(3);
        Code237DeleteNodeInALinkedList.ListNode n4 = new Code237DeleteNodeInALinkedList.ListNode(4);
        Code237DeleteNodeInALinkedList.ListNode n5 = new Code237DeleteNodeInALinkedList.ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Code237DeleteNodeInALinkedList.ListNode n = new Code237DeleteNodeInALinkedList.ListNode(5);
        solution.deleteNode(n);
        print(n1);
    }

    public void print(Code237DeleteNodeInALinkedList.ListNode node) {
        while (node != null) {
            MyUtils.println(MyUtils.ANSI_RED + node.val + MyUtils.ANSI_RESET);
            node = node.next;
        }
    }

}
