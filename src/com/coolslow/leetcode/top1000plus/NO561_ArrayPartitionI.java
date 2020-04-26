package com.coolslow.leetcode.top1000plus;

import java.util.Arrays;

/**
 * NO.561 数组拆分 I
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *  输入: [1, 4, 3, 2]
 *  输出: 4
 *  解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 提示:
 *  n 是正整数,范围在 [1, 10000].
 *  数组中的元素范围在 [-10000, 10000].
 */
public class NO561_ArrayPartitionI {

    /**
     *
     * 时间复杂度：O(Nlog(N)) + O(N)。排序需要O(Nlog(N)) 的时间。另外会有一次数组的遍历。
     * 空间复杂度：O(1)，仅需要常数级存储空间
     *
     * @param nums 给定的数组
     * @return 拆分为n对，每对数min(ai, bi)的最大总和
     */
    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        for(int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
