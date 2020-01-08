package com.coolslow.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.tree.Code98ValidateBinarySearchTree;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code98ValidateBinarySearchTreeTest {


    @Test
    public void testSolution() {
        Code98ValidateBinarySearchTree solution = new Code98ValidateBinarySearchTree();
        Integer[] nums = {-2147483648};
//        Integer[] nums = {2, 1, 3};
//        Integer[] nums = {5, 1, 4, null, null, 3, 6};
        TreeNode node = TreeNodeUtil.getTree(nums);
        boolean result = solution.isValidBST(node);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
