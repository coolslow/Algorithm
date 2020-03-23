package com.coolslow.leetcode.top1000plus;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了3次，找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例1：
 *  - 输入: [2,2,3,2]
 *  - 输出: 3
 *
 * 示例2：
 *  - 输入: [0,1,0,1,0,1,99]
 *  - 输出: 99
 *
 *
 * ------------------------------------------
 * 解题思路：
 * - 二进制下不考虑进位的加法：
 * - 三进制下不考虑进位的加法：
 *
 * - 复杂度分析：
 *   - 时间复杂度O(N): 遍历一次，nums 需要线性时间复杂度
 *   - 空间复杂度O(1): 使用常数额外空间
 */
public class NO137_SingleNumberII {

    public static int singleNumberII(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for(int num: nums) {
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
