package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.List;

/**
 * 118 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例：
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1, 1],
 *    [1, 2, 1],
 *   [1, 3, 3, 1],
 *  [1, 4, 6, 4, 1]
 * ]
 *
 * REFERENCE: https://leetcode-cn.com/problems/pascals-triangle/solution/javadi-gui-dong-tai-gui-hua-by-jeromememory/
 */
public class NO118_PascalsTriangle {

    // 动态规划解法
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        // 处理为0的情况，如果为0，返回一个空的List
        if(numRows == 0){
            return triangle;
        }
        // 先添加第一行
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // 添加第一行以外的其他行
        for(int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // 第一个row的元素始终是1
            row.add(1);

            for(int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }

    // 递归解法
    public static List<List<Integer>> generateWithRecursion(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果给定的入参为0，则直接返回一个空的数组
        if(numRows <= 0) {
            return result;
        }

        // 递归退出条件，第一行，只有一个数字1
        if(numRows == 1) {
            result.add(new ArrayList<>());
            result.get(0).add(1);

            return result;
        }

        result = generate(numRows - 1);

        List<Integer> row = new ArrayList<>();
        row.add(1);

        for(int idx = 1; idx < numRows - 1; idx++) {
            row.add(result.get(numRows - 2).get(idx - 1) + result.get(numRows - 2).get(idx));
        }

        row.add(1);
        result.add(row);

        return result;
    }
}
