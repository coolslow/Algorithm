package com.coolslow.leetcode.topics.math;

import java.util.Arrays;

/**
 * 计数质数
 * by MrThanksgiving
 */
public class Code204CountPrimes {

    /**
     * <pre>
     * 题目：
     *      统计所有小于非负整数 n 的质数的数量。
     *
     * 示例:
     *      输入: 10
     *      输出: 4
     *      解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * </pre>
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        int count = 0;
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    isPrimes[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) count++;
        }
        return count;
    }


}
