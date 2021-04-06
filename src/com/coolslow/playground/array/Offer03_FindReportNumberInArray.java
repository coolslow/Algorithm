package com.coolslow.playground.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Offer 03. 查找数组中重复的数组
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例：
 * 输入：[2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Offer03_FindReportNumberInArray {

    // 最暴力的求解方式
    // 时间复杂度O(n^2)
    // 空间复杂度O(1)
    public int findRepeatNumberViolent(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; i < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return -1;
    }

    // 通过使用HashSet判断数组中是否存在重复元素
    // 时间复杂度为O(N)
    // 空间复杂度为O(N)
    public int findRepeatNumberHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) {
            if(set.contains(x)) {
                return x;
            }
            set.add(x);
        }
        return -1;
    }

    /**
     * 原地置换方式处理
     * @param nums
     * @return
     */
    public int findRepeatNumberII(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(i != nums[i]) {
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }

        return -1;
    }
}
