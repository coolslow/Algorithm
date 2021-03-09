package com.coolslow.leetcode.interview;

/**
 * 面试题：找出最小的K个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *      输入：arr = [3,2,1], k = 2
 *      输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 *      输入：arr = [0,1,2,1], k = 1
 *      输出：[0]
 *
 *
 * 对于Top K的三种通用解决办法：
 * 1. 用快排最最最高效解决TopK问题：O(N)
 * 2. 大根堆(前K小) / 小根堆（前K大),Java中有现成的PriorityQueue，实现起来最简单：O(NlogK)
 * 3. 二叉搜索树也可以O(NlogK)解决TopK问题哦
 */
public class NO40_FindTheTopKNums {

}
