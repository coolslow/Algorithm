package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code189RotateArray;
import org.junit.Test;

/**
 * 旋转数组
 * by MrThanksgiving
 */
public class Code189RotateArrayTest {

    @Test
    public void testSolution() {
        Code189RotateArray solution = new Code189RotateArray();
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {1, 2, 3,4};
        int[] nums = {1, 2};
        int k = 3;
        solution.rotate(nums, k);
        MyUtils.printArray(nums);
    }
}
