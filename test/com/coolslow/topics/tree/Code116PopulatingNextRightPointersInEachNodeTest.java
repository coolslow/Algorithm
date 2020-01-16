package com.coolslow.topics.tree;

import com.coolslow.leetcode.topics.tree.Code116PopulatingNextRightPointersInEachNode;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code116PopulatingNextRightPointersInEachNodeTest {

    @Test
    public void testSolution() {
        Code116PopulatingNextRightPointersInEachNode solution = new Code116PopulatingNextRightPointersInEachNode();
        Integer[] input = {1, 2, 3, 4, 5, 6, 7};
        Code116PopulatingNextRightPointersInEachNode.Node node = Code116PopulatingNextRightPointersInEachNode.Node.getNode(input);
        Code116PopulatingNextRightPointersInEachNode.Node result = solution.connect(node);
        Code116PopulatingNextRightPointersInEachNode.Node.printBFS(node);
    }
}
