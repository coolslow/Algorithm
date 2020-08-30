package com.coolslow.leetcode.top1000plus;

/**
 * 72. 编辑距离
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 *  1、插入一个字符
 *  2、删除一个字符
 *  3、替换一个字符
 *
 * 示例 1：
 *      输入：word1 = "horse", word2 = "ros"
 *      输出：3
 *      解释：
 *      horse -> rorse (将 'h' 替换为 'r')
 *      rorse -> rose (删除 'r')
 *      rose -> ros (删除 'e')
 *
 * 示例 2：
 *      输入：word1 = "intention", word2 = "execution"
 *      输出：5
 *      解释：
 *      intention -> inention (删除 't')
 *      inention -> enention (将 'i' 替换为 'e')
 *      enention -> exention (将 'n' 替换为 'x')
 *      exention -> exection (将 'n' 替换为 'c')
 *      exection -> execution (插入 'u')
 *
 *
 * NOTE: 编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法。
 *       最直观的方法是暴力检查所有可能的编辑方法，取最短的一个。
 *       所有可能的编辑方法达到指数级，但我们不需要进行这么多计算，因为我们只需要找到距离最短的序列而不是所有可能的序列。
 */

@Deprecated
public class NO72_EditDistance {


}
