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
     *
     * 时间复杂度：O(2^n)，其生成字符串的总长度为：2^0 + 2^1 + ... + 2^(n-1)
     * 空间复杂度：O(2^n)，其为最后一行字符串的长度
     *
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

    /**
     * 递归解法
     * 总结规律：第K个数字是上一行第(k+1)/2个数字生成的。如果上一行的数字为0，被生成的数字为1-（k%2)。
     * 如果上一行的数字为1，被生成的数字为 k%2。
     *
     * @param n 给定的第n行
     * @param k 给定的第n行的第k个字符
     * @return 返回对应的字符
     */
    public static int kthGrammarWithRecursive(int n, int k) {
        if (n == 1) return 0;
        return (~k & 1) ^ kthGrammar(n-1, (k+1)/2);
    }
}
