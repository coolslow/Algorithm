package com.coolslow.leetcode.top100plus;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 思路：
 *  这个问题属于"数组变换"的一个广泛范畴。这一类是技术面试的重点。主要因为数组是简单且易于使用的数据结构。
 *  遍历或表示不需要任何样板代码，且大多数代码将看起来像伪代码本身。
 *
 *  问题的两个要求：
 *  1. 将所有0移动到数组末尾。
 *  2. 所有非零元素必须保持其原始顺序。
 *
 */
public class NO283_MoveZeroes {

    /**
     * 解题思路
     * 1.遍历数组把非零元素（假设有k个）按顺序存入数组的0至k-1位置上；
     * 2.把原数组剩余未新赋值部分(k到n-1位置上)全设置为0；
     *
     * @param nums 给定的包含0的数组
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for(; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}
