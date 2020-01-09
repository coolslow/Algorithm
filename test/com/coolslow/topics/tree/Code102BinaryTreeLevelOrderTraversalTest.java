package com.coolslow.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.tree.Code102BinaryTreeLevelOrderTraversal;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code102BinaryTreeLevelOrderTraversalTest {

    @Test
    public void testSolution() {
        Code102BinaryTreeLevelOrderTraversal solution = new Code102BinaryTreeLevelOrderTraversal();
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode node = TreeNodeUtil.getTree(nums);
        List<List<Integer>> result = solution.levelOrder(node);
        if (result != null) {
            for (List<Integer> list : result) {
                for (Integer i : list)
                    MyUtils.print(MyUtils.ANSI_RED + i + " , " + MyUtils.ANSI_RESET);
                MyUtils.println();
            }
        }
    }
}
