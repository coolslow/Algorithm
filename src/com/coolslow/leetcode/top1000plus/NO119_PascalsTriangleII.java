package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角II
 * 杨辉三角，也叫帕斯卡三角
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 题解思路：
 *    和118题类似，但这道题只要求输入指定 k <= 33 的情况下的第 k 行的结果，而不是要求输出前 k 行的所有结果。
 *
 */
public class NO119_PascalsTriangleII {

    /**
     * 解法一：
     * 逐层求解，根据上一层的结果求取当前层的结果
     * @param rowIndex 给定的rowIndex
     * @return 返回当前层的结果
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for(int i = 0; i <= rowIndex; i++) {
            cur = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return cur;
    }

    /**
     * 基于解法一的优化
     * 根据杨辉三角的定义，可以看到，下一层可以根据上一层的结果进行推导
     * 这样，每次不用去新建List，可以把cur当成pre
     *
     *
     * @param rowIndex 给定的rowIndex
     * @return 返回当前层的结果
     */
    public static List<Integer> getRowII(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; i++) {
                int temp = cur.get(j);
                cur.set(j, pre + cur.get(j));
                pre = temp;
            }
            cur.add(1);
        }
        return cur;
    }

    /**
     * 解法二：公式法
     *
     *                      1              n = 0
     *                    1   1            n = 1
     *                  1   2   1          n = 2
     *                1   3   3   1        n = 3
     *              1   4   6   4   1      n = 4
     *            1   5   10  10  5   1    n = 5
     *
     * 如果想要达到k的时间复杂度，则需要借助公式法解决。
     * (a + b)^n = k1 * a^n + k2 * a^(n-1)b + k3 * a^(n-2)b^2 + k3 * a^(n-3)b^3 + ... + kn
     *
     * 参考：
     * - https://www.shuxuele.com/pascals-triangle.html
     * - https://www.bilibili.com/read/cv208862/
     *
     */
    public static List<Integer> getRowWithFormula(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k <= rowIndex; k++) {
            ans.add(combination(rowIndex, k));
        }
        return ans;
    }

    private static int combination(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            // 这里就是记住公式的推导
            // n!/(k! * (n - k)!) = (n - k + 1)!/k!
            res = res * (n - k + i) / i;
        }

        return (int) res;
    }
}
