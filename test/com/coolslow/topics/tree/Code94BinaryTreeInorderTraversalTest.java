package com.coolslow.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.tree.Code94BinaryTreeInorderTraversal;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code94BinaryTreeInorderTraversalTest {

    @Test
    public void testSolution() {
        Code94BinaryTreeInorderTraversal solution = new Code94BinaryTreeInorderTraversal();
        Integer[] input = {1, null, 2, 3};
        TreeNode node = TreeNodeUtil.getTree(input);
        List<Integer> result = solution.inorderTraversal(node);
        MyUtils.printArray(result);
    }
}
