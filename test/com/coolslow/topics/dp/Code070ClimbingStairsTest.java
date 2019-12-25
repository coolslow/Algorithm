package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code070ClimbingStairs;
import org.junit.Test;

/**
 * 爬楼梯
 * by MrThanksgiving
 */
public class Code070ClimbingStairsTest {


    @Test
    public void testSolution() {
        Code070ClimbingStairs solution = new Code070ClimbingStairs();
        int result = solution.climbStairs(3);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}
