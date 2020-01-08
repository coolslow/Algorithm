package com.coolslow.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.tree.Code101SymmetricTree;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code101SymmetricTreeTest {


    @Test
    public void testSolution() {
        Code101SymmetricTree solution = new Code101SymmetricTree();
        Integer[] nums = {1, 2, 2, 3, 4, 4, 3};
//        Integer[] nums = {1, 2, 2, 3, null, 4, 3};
        TreeNode node = TreeNodeUtil.getTree(nums);
        boolean result = solution.isSymmetric(node);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
