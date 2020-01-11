package com.coolslow.leetcode.topics.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * by MrThanksgiving
 */
public class Code118PascalsTriangle {

    /**
     * <pre>
     * 题目：
     *      给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *      在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     *      输入: 5
     *      输出:
     *      [
     *           [1],
     *          [1,1],
     *         [1,2,1],
     *        [1,3,3,1],
     *       [1,4,6,4,1]
     *      ]
     *
     * </pre>
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
        }
        if (numRows == 0) return result;
        result.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) list.add(1);
                else if (j == i) list.add(1);
                else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
        }
        return result;
    }

}
