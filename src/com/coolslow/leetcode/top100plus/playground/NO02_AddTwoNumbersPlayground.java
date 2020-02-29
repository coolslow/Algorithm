package com.coolslow.leetcode.top100plus.playground;

import com.coolslow.common.Playground;
import com.coolslow.leetcode.top100plus.datastructure.ListNode;

@Playground(name = "两数相加", rank = Playground.Difficulty.Medium)
public class NO02_AddTwoNumbersPlayground {

    public static ListNode addTwoNumbsers(ListNode l1, ListNode l2) {
        // 设置一个哑节点，其值为0
        ListNode head = new ListNode(0);
        ListNode curr = head, p = l1, q = l2;

        // 设置进位标记，默认值为0
        int carry = 0;
        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(p != null) {
                p = p.next;
            }

            if(q != null) {
                q = q.next;
            }
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }
}
