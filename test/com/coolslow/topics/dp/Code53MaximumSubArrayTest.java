package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code53MaximumSubArray;
import org.junit.Test;

/**
 * 最大子序和
 * by MrThanksgiving
 */
public class Code53MaximumSubArrayTest {

    @Test
    public void testSolution() {
        Code53MaximumSubArray solution = new Code53MaximumSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}
