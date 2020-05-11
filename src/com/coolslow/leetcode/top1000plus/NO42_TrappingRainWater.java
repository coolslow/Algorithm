package com.coolslow.leetcode.top1000plus;

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例:
 *  输入: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 *  输出: 6
 */
public class NO42_TrappingRainWater {

    /**
     * 解法：按行求解雨水积水
     *
     * 方法：
     * - 先找到高度最高的柱子，然后一层一层累加到最高的高度按行求解能够积攒的雨水。
     * - 如果求高度为 i 层处的积水，遍历每个位置，如果当前的高度小于i，并且两边有高度大于等于i的，说明这个地方一定有积水，可以 +1
     * 如果求高度为 i 处的水，首先用一个变量temp保存当前积水，初始化为0。从左到右遍历墙的高度，遇到高度大于等于i的时候，开始更新temp。
     * 更新原则是遇到高度小于i的就把temp加1，遇到高度大于等于i的，就把temp加到记录最终答案的变量ans中，并把temp设置为0，依次循环。
     *
     * 时间复杂度：O(n^2)
     * 空间负载度：O(1)
     *
     * @param height 给出的表征柱子的非负数数组
     * @return 返回能接到的雨水量
     */
    public static int trapRainWaterByRow(int[] height) {
        int ans = 0;
        // 找到数组中最高的柱子
        int maxHeight = getMaxHeight(height);
        for(int i = 1; i <= maxHeight; i++) {
            // 标记是否开始更新temp
            boolean isStart = false;
            int temp = 0;

            for (int j = 0; j < height.length; j++) {
                // 第一次不会进入下面的循环
                if(isStart && height[j] < i) {
                    temp++;
                }

                if(height[j] >= i) {
                    ans += temp;
                    temp = 0;
                    isStart = true;
                }
            }
        }
        return ans;
    }

    private static int getMaxHeight(int[] height) {
        int max = 0;
        for (int value : height) {
            max = Math.max(max, value);
        }

        return max;
    }

    /**
     * 解法一：动态规划法
     *
     * 时间复杂度：O(n)
     * 空间负载度：O(1)
     *
     * @param height 给出的表征柱子的非负数数组
     * @return 返回能接到的雨水量
     */
    public static int trapWithDp(int[] height) {
        int ans = 0;
        int len = height.length;
        if(len < 3) {
            return 0;
        }

        int[] leftMaxArr = new int[len];
        int[] rightMaxArr = new int[len];
        leftMaxArr[0] = height[0];
        rightMaxArr[len - 1] = height[len - 1];

        for(int i = 1; i < len; i++) {
            leftMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i]);
        }
        for(int i = len - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i]);
        }

        // 计算每个位置对应的积水量并累加以获得答案
        for(int i = 0; i < len; i++) {
            ans += Math.min(leftMaxArr[i], rightMaxArr[i] - height[i]);
        }

        return ans;
    }
}
