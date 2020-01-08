package com.coolslow.topics.tree;

import com.coolslow.leetcode.topics.tree.Code108ConvertSortedArrayToBinarySearchTree;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code108ConvertSortedArrayToBinarySearchTreeTest {

    @Test
    public void testSolution() {
        Code108ConvertSortedArrayToBinarySearchTree solution = new Code108ConvertSortedArrayToBinarySearchTree();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = solution.sortedArrayToBST(nums);
//        TreeNodeUtil.printOrder(result);
        TreeNodeUtil.printPre(result);
//        TreeNodeUtil.printPost(result);
    }
}
