package com.coolslow.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.tree.Code104MaximumDepthOfBinaryTree;
import com.coolslow.leetcode.topics.tree.ds.TreeNode;
import com.coolslow.leetcode.topics.tree.ds.TreeNodeUtil;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code104MaximumDepthOfBinaryTreeTest {

    @Test
    public void testSolution() {
        Code104MaximumDepthOfBinaryTree solution = new Code104MaximumDepthOfBinaryTree();
//        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        Integer[] nums = {3, 9, 20, null, null, 15, 7, null, null, null, null, null, null, null, 8};
        TreeNode node = TreeNodeUtil.getTree(nums);
        int result = solution.maxDepth(node);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


    /*
     *
     *           3
     *         /   \
     *        9     20
     *             /  \
     *            15   7
     *
     *      pre: 3 ,9 , 20, 15, 7
     *    order: 9 ,3 , 15, 20, 7
     *     post: 9 ,15, 7 , 20, 3
     *      bfs: 3 ,9 , 20, 15, 7
     *
     */

    @Test
    public void testTreeApi() {
        Integer[] nums = {3, 9, 20, null, null, 15, 7, null, null, null, null, 8};
        TreeNode tree = TreeNodeUtil.getTree(nums);
        TreeNodeUtil.printBFS(tree);
//        MyUtils.print("height=" + TreeNodeUtil.getHeight(tree));
    }


}
