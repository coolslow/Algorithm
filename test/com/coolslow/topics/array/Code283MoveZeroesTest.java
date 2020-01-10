package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code283MoveZeroes;
import org.junit.Test;

/**
 * 移动零
 * by MrThanksgiving
 */
public class Code283MoveZeroesTest {

    @Test
    public void testSolution() {
        Code283MoveZeroes solution = new Code283MoveZeroes();
        int[] nums = {1, 2,};
        solution.moveZeroes(nums);
        MyUtils.printArray(nums);
    }

}
