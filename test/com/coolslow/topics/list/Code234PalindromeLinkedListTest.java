package com.coolslow.topics.list;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.list.Code234PalindromeLinkedList;
import com.coolslow.leetcode.topics.list.ds.ListNode;
import com.coolslow.leetcode.topics.list.ds.ListNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code234PalindromeLinkedListTest {

    @Test
    public void testSolution() {
        Code234PalindromeLinkedList solution = new Code234PalindromeLinkedList();
        ListNode node = ListNodeUtil.getList(new int[]{1,1});
//        ListNode node = ListNodeUtil.getList(new int[]{1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1});
        boolean result = solution.isPalindrome(node);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
