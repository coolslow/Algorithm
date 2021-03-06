package com.coolslow.leetcode.topics.array;

/**
 * 移动零
 * by MrThanksgiving
 */
public class Code283MoveZeroes {

    /**
     * <pre>
     * 题目：
     *      给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *      输入: [0,1,0,3,12]
     *      输出: [1,3,12,0,0]
     *
     * 说明:
     *      必须在原数组上操作，不能拷贝额外的数组。
     *      尽量减少操作次数。
     * </pre>
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int noZeroIndex = 0;
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i] != 0) {
                nums[noZeroIndex++] = nums[i];
            }
        }
        for (int i = noZeroIndex; i < count; i++) {
            nums[i] = 0;
        }
    }

    /*
     * 思路：
     *      慢指针之前的所有元素都是非零的。
     *      当前指针和慢速指针之间的所有元素都是零。
     */

}
