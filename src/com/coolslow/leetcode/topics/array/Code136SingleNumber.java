package com.coolslow.leetcode.topics.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * by MrThanksgiving
 */
public class Code136SingleNumber {

    /**
     * <pre>
     * 题目：
     *      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *      你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *      输入: [2,2,1]
     *      输出: 1
     *
     * 示例 2:
     *      输入: [4,1,2,1,2]
     *      输出: 4
     * </pre>
     */
    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int a = 0;
        for (int num : nums)
            a ^= num;
        return a;
    }
    // 异或思想

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return 0;
    }

}
