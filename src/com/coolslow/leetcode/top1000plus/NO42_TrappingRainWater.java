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
     * 解法一：按行求解雨水积水
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
     * 解法二：按列求解
     *
     * 求每一列的水，只需要关注当前列，以及左边最高的柱子，右边最高的柱子就可以。
     * 装水的多少实际上根据木桶效应决定，只需要看左边最高的墙和右边最高的墙中较矮的一个就够了。
     * 所以，根据较矮的哪个墙和当前列的墙的高度可以分为三种情况考虑：
     * 1. 较矮的墙的高度大于当前列的墙的高度
     * 2. 较矮的墙的高度小于当前列的墙的高度
     * 3. 较矮的墙的高度等于当前列的墙的高度
     *
     * @param height 给出的表征柱子的非负数数组
     * @return 返回能接到的雨水量
     */
    public static int trapRainWaterByColumn(int[] height) {
        int sum = 0, len = height.length;
        // 最两端的列不用考虑，因为一定不会有谁，所以下标从 1 到 length - 2
        for(int i = 0; i < len - 1; i++) {
            int maxLeft = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }

            int maxRight = 0;
            for(int j = i + 1; j < len; i++) {
                if(height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(maxLeft, maxRight);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum +=(min - height[i]);
            }
        }

        return sum;
    }

    /**
     * 解法三：动态规划法
     *
     * 时间复杂度：O(n)
     * 空间负载度：O(n)
     *
     * @param height 给出的表征柱子的非负数数组
     * @return 返回能接到的雨水量
     */
    public static int trapWithDp(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 解法四：双指针
     *
     * 时间复杂度：O(n)
     * 空间负载度：O(1)
     *
     * @param height 给出的表征柱子的非负数数组
     * @return 返回能接到的雨水量
     */
    public static int trapWithTwoPointers(int[] height) {

        int sum = 0;

        int max_left = 0;
        int max_right = 0;

        int left = 1;
        // 加右指针进去
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            // 从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum += (min - height[left]);
                }
                left++;

            }
            // 从右到左更
            else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum += (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
