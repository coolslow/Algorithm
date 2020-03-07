package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO11_ContainerWithMostWater;
import org.junit.Assert;
import org.junit.Test;

/**
 * 11. 盛水最多的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 题解：
 *      垂直的两条线段将会与坐标轴构成一个矩形区域，较短线段的长度将会作为矩形区域的宽度。
 *      两线间距将会作为矩形区域的长度，而我们必须最大化该矩形区域的面积。
 *
 * 示例：
 *
 * 输入：[1, 8, 6, 2, 5, 4, 8, 3, 7]
 * 输出：49
 *
 */
public class NO11_ContainerWithMostWaterTest {

    @Test
    public void shouldReturnCorrectNumOfMostWater() {
        int[] test = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int[] test1 = new int[] { 3, 1, 2, 4 };
        int result = NO11_ContainerWithMostWater.maxAreaViolenceSoluton(test);
        int result1 = NO11_ContainerWithMostWater.maxAreaViolenceSoluton(test1);

        Assert.assertEquals(49, result);
        Assert.assertEquals(9, result1);
    }
}
