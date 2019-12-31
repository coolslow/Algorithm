package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code11ContainerWithMostWater;
import org.junit.Test;

/**
 * 盛最多水的容器
 * by MrThanksgiving
 */
public class Code11ContainerWithMostWaterTest {

    @Test
    public void testSolution() {
        Code11ContainerWithMostWater solution = new Code11ContainerWithMostWater();
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(nums);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
