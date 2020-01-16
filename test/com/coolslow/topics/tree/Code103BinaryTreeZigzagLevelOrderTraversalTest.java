package com.coolslow.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.tree.Code103BinaryTreeZigzagLevelOrderTraversal;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code103BinaryTreeZigzagLevelOrderTraversalTest {

    @Test
    public void testSolution() {
        Code103BinaryTreeZigzagLevelOrderTraversal solution = new Code103BinaryTreeZigzagLevelOrderTraversal();
        Integer[] input = {3, 9, 20, null, 7, 15, 7, null, 2, 3, 4, 5, 6, 7, 8};
        TreeNode node = TreeNodeUtil.getTree(input);
        List<List<Integer>> result = solution.zigzagLevelOrder(node);
        for (List<Integer> i : result) {
            MyUtils.printArray(i);
        }
    }
}
