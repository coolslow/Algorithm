package com.coolslow.leetcode.top1000plus;

/**
 * 209. 长度最小的子数组
 *
 * 给定一个含有n个正整数的数组和一个正整数s，找出该数组中满足其和>=s的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回0。
 *
 * 示例:
 *   输入: s = 7, nums = [2, 3, 1, 2, 4, 3]
 *   输出: 2
 *   解释: 子数组 [4, 3] 是该条件下的长度最小的连续子数组。
 *
 * 如果你已经完成了O(N) 时间复杂度的解法, 请尝试 O(NlogN) 时间复杂度的解法。
 */
public class NO209_MinimumSizeSubarraySum {

    /**
     * 方法一：暴力破解法
     * 从数组的第一个元素开始，依此添加数字，记录总和大于等于s的长度
     *
     * 时间复杂度：O(n^2)
     *
     * @param s 给定的数字s
     * @param nums 给定的数组
     * @return 返回总和大于等于s的最小长度，无满足条件的结果则返回0
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int start = i;
            int sum = 0;
            while(start < n) {
                sum += nums[start];
                start++;

                if(sum >= s) {
                    min = Math.min(min, start - i);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 方法二：双指针法
     * 使用双指针left和right表示一个窗口
     *
     * 1. right 向右移动增大窗口，知道窗口内的数字和大于等于s，进行第二步。
     * 2. 记录此时的窗口长度，left向右移动开始减少长度，每减少依此，就更新最小长度。知道当前窗口内的数字和小于了s，回到第一步。
     *
     * 时间复杂度：O(n)
     *
     * @param s 给定的数字s
     * @param nums 给定的数组
     * @return 返回总和大于等于s的最小长度，无满足条件的结果则返回0
     */
    public static int minSubArrayLenWithSlidingWindow(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        // 两个指针，初始状态均指向数组第一个元素
        int left = 0, right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(right < n) {
            sum += nums[right];
            right++;
            while(sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    /**
     * 方法三：二分法查找
     *
     * @param s 给定的数字s
     * @param nums 给定的数组
     * @return 返回总和大于等于s的最小长度，无满足条件的结果则返回0
     */
    public static int minSubArrayLenWithBinarySearch(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        int minLen = 0, maxLen = n;
        int midLen;
        int min = -1;
        while(minLen <= maxLen) {
            // 取中间的长度
            midLen = (minLen + maxLen) >>> 1;

            // 判断当前长度的最大和是否>=s
            if(getMaxSum(midLen, nums) >= s) {
                maxLen = midLen - 1;
                min = midLen;
            } else {
                minLen = midLen + 1;
            }
        }

        return min == -1 ? 0: min;
    }

    private static int getMaxSum(int len, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = 0;
        // 达到长度
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        // 初始化 maxSum
        maxSum = sum;

        for (int i = len; i < n; i++) {
            // 加一个数字减一个数字，保持长度不变
            sum += nums[i];
            sum = sum - nums[i - len];
            // 更新 maxSum
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
