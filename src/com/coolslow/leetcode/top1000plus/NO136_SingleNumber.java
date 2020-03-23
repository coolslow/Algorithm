package com.coolslow.leetcode.top1000plus;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *  输入: [2,2,1]
 *  输出: 1
 *
 * 示例 2:
 *  输入: [4,1,2,1,2]
 *  输出: 4
 *
 */
public class NO136_SingleNumber {

    /**
     * 解法一：异或的方式找到唯一一个只出现一次的数字
     *
     * @param nums 输入的数字数组
     * @return 返回唯一出现一次的数字
     */
    public static int singleNumber(int[] nums) {

        int target = 0;

        for (int num : nums) {
            target ^= num;
        }

        return target;
    }
}
