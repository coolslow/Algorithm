package com.coolslow.leetcode.top1000plus;

/**
 * 779. 第K个语法符号
 *
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 * 例子:
 *      输入: N = 1, K = 1
 *      输出: 0
 *
 *      输入: N = 2, K = 1
 *      输出: 0
 *
 *      输入: N = 2, K = 2
 *      输出: 1
 *
 *      输入: N = 4, K = 5
 *      输出: 1
 *
 *      解释:
 *      第一行: 0
 *      第二行: 01
 *      第三行: 0110
 *      第四行: 01101001
 *
 */
public class NO779_KthSymbolInGrammar {

    /**
     * 暴力解法
     * @param n 给定的第n行
     * @param k 给定的第n行的第k个字符
     * @return 返回对应的字符
     */
    public static int kthGrammar(int n, int k) {
        int[] lastRow = new int[1 << n];

        for(int i = 1; i < n; i++) {
            for(int j = (1 <<(i - 1)) - 1; j >= 0; j--) {
                lastRow[2 * j] = lastRow[j];
                lastRow[2 * j + 1] = 1 - lastRow[j];
            }
        }

        return lastRow[k - 1];
    }
}
