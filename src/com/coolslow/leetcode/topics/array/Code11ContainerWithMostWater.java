package com.coolslow.leetcode.topics.array;

/**
 * 盛最多水的容器
 * by MrThanksgiving
 */
public class Code11ContainerWithMostWater {

    /**
     * <pre>
     * 题目：
     *      给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     *      在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     *      找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：
     *      你不能倾斜容器，且 n 的值至少为 2。
     *
     * 示例:
     *      输入: [1,8,6,2,5,4,8,3,7]
     *      输出: 49
     * </pre>
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int l = 0, r = height.length - 1, max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }


    public int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int count = height.length;
        int l, r, max = 0;
        for (int i = 0; i < count - 1; i++) {
            l = height[i];
            for (int j = i + 1; j < count; j++) {
                r = height[j];
                max = Math.max(Math.min(l, r) * (j - i), max);
            }
        }
        return max;
    }

}
