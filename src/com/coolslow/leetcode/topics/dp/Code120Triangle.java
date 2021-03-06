package com.coolslow.leetcode.topics.dp;


import java.util.List;

/**
 * 三角形最小路径和
 * by MrThanksgiving
 */
public class Code120Triangle {

    /**
     * <pre>
     * 题目：
     *      给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 例如：
     *      给定三角形：
     *      [
     *           [2],
     *          [3,4],
     *         [6,5,7],
     *        [4,1,8,3]
     *      ]
     *      自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     *
     * 说明：
     *      如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     *
     * </pre>
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int rows = triangle.size();
        for (int i = rows - 2; i >= 0; i--) {
            List<Integer> currColumns = triangle.get(i);
            List<Integer> nextColumns = triangle.get(i + 1);
            for (int j = 0; j < currColumns.size(); j++) {
                int min = Math.min(nextColumns.get(j), nextColumns.get(j + 1)) + currColumns.get(j);
                currColumns.set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }


}
