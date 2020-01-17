package com.coolslow.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.tree.Code230KthSmallestElementInABST;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code230KthSmallestElementInABSTTest {

    @Test
    public void testSolution() {
        Code230KthSmallestElementInABST solution = new Code230KthSmallestElementInABST();
        Integer[] input = {3, 1, 4, null, 2};
        TreeNode node = TreeNodeUtil.getTree(input);
        for (int i = 1; i <= 4; i++) {
            int result = solution.kthSmallest(node, i);
            MyUtils.println(MyUtils.ANSI_RED + i+" = "+result + MyUtils.ANSI_RESET);
        }


    }
}
