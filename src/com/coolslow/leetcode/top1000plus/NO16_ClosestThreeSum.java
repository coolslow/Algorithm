package com.coolslow.leetcode.top1000plus;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 题目：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 *      返回这三个数的和，假定每组输入只存在唯一答案。
 *
 *      例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *      与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 思路：排序 + 双指针
 *      本题目因为要计算三个数，如果靠暴力枚举的话时间复杂度会到 O(n^3)，需要降低时间复杂度。
 *      - 首先进行数组排序，时间复杂度 O(nlogn)
 *      - 再遍历排序数组
 *
 * 总时间复杂度：O(nlogn) + O(n^2) -----> O(n^2)
 */
public class NO16_ClosestThreeSum {

    public static int threeClosestNumSum(int[] nums, int target) {
        // 先对数组进行排序
        Arrays.sort(nums);
        // 假设前三个数（数组下标为0，1，2）的和与目标target值最接近
        int ans = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length; i++) {
            // 下标从1开始
            int start = i + 1, end = nums.length - 1;

            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                // 表示sum的和比ans更加接近，则把sum的值赋给ans
                if(Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                // 这里需要基于已经排好序的数组考虑，如果sum > target，那么需要end指针向前，以缩小三数之和与target的差距
                if(sum > target) {
                    end--;
                }
                // sum < target的情况
                else if(sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }

        return ans;
    }
}
