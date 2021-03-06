package com.coolslow.leetcode.topics.array;

/**
 * 旋转数组
 * by MrThanksgiving
 */
public class Code189RotateArray {

    /**
     * <pre>
     * 题目：
     *      给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *      输入: [1,2,3,4,5,6,7] 和 k = 3
     *      输出: [5,6,7,1,2,3,4]
     *      解释:
     *      向右旋转 1 步: [7,1,2,3,4,5,6]
     *      向右旋转 2 步: [6,7,1,2,3,4,5]
     *      向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * 示例 2:
     *      输入: [-1,-100,3,99] 和 k = 2
     *      输出: [3,99,-1,-100]
     *      解释:
     *      向右旋转 1 步: [99,-1,-100,3]
     *      向右旋转 2 步: [3,99,-1,-100]
     *
     * 说明:
     *      尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     *      要求使用空间复杂度为 O(1) 的 原地 算法。
     *
     * </pre>
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l++] ^= nums[r--];
        }
    }

    // 反转3次。
    // 第一次全部反转
    // 第二次反转0到k-1个
    // 第三次反转k到count-1个

}
