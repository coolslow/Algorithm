package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code198HouseRobber;
import org.junit.Test;

/**
 * 打家劫舍
 * by MrThanksgiving
 */
public class Code198HouseRobberTest {



    @Test
    public void testSolution() {
        Code198HouseRobber solution = new Code198HouseRobber();
//        int[] nums = {1, 1};
        int[] nums = {1, 2};
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2, 7, 9, 3, 1};
        int result = solution.rob(nums);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}
