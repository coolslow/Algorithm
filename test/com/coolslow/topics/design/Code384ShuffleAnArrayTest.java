package com.coolslow.topics.design;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.design.Code384ShuffleAnArray;
import org.junit.Test;

import java.util.Random;

/**
 * by MrThanksgiving
 */
public class Code384ShuffleAnArrayTest {

    @Test
    public void testSolution() {
        int[] nums = {1, 2, 3, 4, 5};
        Code384ShuffleAnArray solution = new Code384ShuffleAnArray(nums);
        int[] result = solution.shuffle();
        MyUtils.printMarkLine("shuffle");
        MyUtils.printArray(result);
        result = solution.reset();
        MyUtils.printMarkLine("reset");
        MyUtils.printArray(result);
//        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

    @Test
    public void test1() {
        int[] a = {1};

        a[0] ^= a[1];
        a[1] ^= a[0];
        a[0] ^= a[1];

        MyUtils.print("a=" + a[0] + "   b=" + a[1]);

    }
}
