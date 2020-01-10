package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code217ContainsDuplicate;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code217ContainsDuplicateTest {

    @Test
    public void testSolution() {
        Code217ContainsDuplicate solution = new Code217ContainsDuplicate();
        int[] nums = {1, 2, 3, 4};
        boolean result = solution.containsDuplicate(nums);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
