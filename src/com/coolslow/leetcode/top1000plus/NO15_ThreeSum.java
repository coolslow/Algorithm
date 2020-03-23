package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *      给定数组 nums = [-1, 0, 1, 2, -1, -4]
 *      满足要求的三元组集合为：
 *      [
 *          [-1, 0, 1],
 *          [-1, -1, 2]
 *      ]
 *
 * 解法：
 * > 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L]和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
 * > 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
 * > 如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * > 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
 * > 当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
 * > 时间复杂度：O(n^2)，n 为数组长度
 */
public class NO15_ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len < 3) {
            return ans;
        }

        // 对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(nums[i] > 0) {
                break;
            }
            // 去重
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去重
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
