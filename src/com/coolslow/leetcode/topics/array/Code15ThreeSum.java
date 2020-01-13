package com.coolslow.leetcode.topics.array;

import java.util.*;

/**
 * 三数之和
 * by MrThanksgiving
 */
public class Code15ThreeSum {

    /**
     * <pre>
     * 题目：
     *      给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     *      使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：
     *      答案中不可以包含重复的三元组。
     *
     * 例如:
     *      给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *      满足要求的三元组集合为：
     *      [
     *        [-1,  0, 1],
     *        [-1, -1, 2]
     *      ]
     *
     * </pre>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
    // O(n^2)

}
