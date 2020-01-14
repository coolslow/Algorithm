package com.coolslow.leetcode.topics.list.ds;

import com.coolslow.datastruct.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtil {

    public static ListNode getList(int[] array) {
        if (array == null || array.length == 0) return null;
        List<ListNode> list = new ArrayList<>();
        for (int value : array) {
            list.add(new ListNode(value));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }

    public static ListNode getLastList(ListNode node) {
        if (node == null) return null;
        ListNode curr = node;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public static void print(ListNode node) {
        while (node != null) {
            MyUtils.println(MyUtils.ANSI_RED + node.val + MyUtils.ANSI_RESET);
            node = node.next;
        }
    }

    public static ListNode join(ListNode a, ListNode b) {
        if (a == null) return b;
        ListNode curr = a;
        while (curr.next != null)
            curr = curr.next;
        curr.next = b;
        return a;
    }
}
