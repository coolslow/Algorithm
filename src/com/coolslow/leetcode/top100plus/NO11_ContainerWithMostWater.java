package com.coolslow.leetcode.top100plus;

/**
 * 11. 盛最多水的容器
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 *  输入 - [1, 8, 6, 2, 5, 4, 8, 3, 7]
 *  输出 - 49
 *
 * 思路：
 *  如题意，垂直的两条险段将会与坐标轴构成一个矩形区域，较短线段的长度将会作为矩形区域的宽度，两线间距将会作为
 *  矩形区域的长度，而我们必须最大化该矩形区域的面积。
 */
public class NO11_ContainerWithMostWater {

    /**
     * 解法一：暴力解法
     *
     * 我们将简单地考虑每对可能出现的线段组合并找出这些情况之下的最大面积。
     *
     * 时间复杂度O(n^2)，计算所有n(n-1)/2种高度组合的面积。
     * 空间复杂度: O(1)，使用恒定的额外空间。
     *
     * @param arr 输入的数组
     * @return 最大面积
     */
    public static int maxAreaViolenceSoluton(int[] arr) {
        int maxArea = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                maxArea = Math.max(maxArea, Math.min(arr[i], arr[j]) * (j - i));
            }
        }
        return maxArea;
    }

    /**
     * 解法二：双指针法
     *
     * 思路：该方法的思路在于，两线段之间形成的区域总会是受到其中较短的那条长度的限制。
     * 此外，两线段距离越远，得到的面积就越大。
     *
     * 在由险段长度构成的数组中使用两个指针，一个放在开始，另一个置于末尾。此外，我们会使用变量maxArea来持续
     * 存储到目前为止所获取的最大面积。在每一步中，我们会找出指针所指向的两条线段形成的区域，更新maxArea，并将
     * 指向较短线段的指针向较长线段那端移动一步。
     *
     * @param height 输入的数组
     * @return 最大面积
     */
    public static int maxAreaTwoPointersSolution(int[] height) {
        // 设置初始的最大面积
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int container = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, container);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
