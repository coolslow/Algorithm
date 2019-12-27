package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code70ClimbingStairs;
import org.junit.Test;

/**
 * 爬楼梯
 * by MrThanksgiving
 */
public class Code70ClimbingStairsTest {


    @Test
    public void testSolution() {
        Code70ClimbingStairs solution = new Code70ClimbingStairs();
        int result = solution.climbStairs(3);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}
