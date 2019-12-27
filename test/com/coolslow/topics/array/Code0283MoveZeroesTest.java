package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code0283MoveZeroes;
import org.junit.Test;

/**
 * 移动零
 * by MrThanksgiving
 */
public class Code0283MoveZeroesTest {

    @Test
    public void testSolution() {
        Code0283MoveZeroes solution = new Code0283MoveZeroes();
        int[] nums = {1, 2,};
        solution.moveZeroes(nums);
        MyUtils.printArray(nums);
    }

}
