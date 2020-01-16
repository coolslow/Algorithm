package com.coolslow.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.tree.Code105ConstructBinaryTreeFromPreOrderAndInorderTraversal;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code105ConstructBinaryTreeFromPreOrderAndInorderTraversalTest {

    @Test
    public void testSolution() {
        Code105ConstructBinaryTreeFromPreOrderAndInorderTraversal solution = new Code105ConstructBinaryTreeFromPreOrderAndInorderTraversal();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
//        int[] preOrder = {1, 2, 3};
//        int[] inOrder = {3, 2, 1};

        TreeNode result = solution.buildTree(preOrder, inOrder);
        TreeNodeUtil.printOrder(result);
    }

}
