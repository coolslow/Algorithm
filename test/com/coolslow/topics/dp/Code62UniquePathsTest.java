package com.coolslow.topics.dp;


import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code62UniquePaths;
import org.junit.Test;

/**
 * 不同路径问题
 * by MrThanksgiving
 */
public class Code62UniquePathsTest {

    @Test
    public void testSolution() {
        Code62UniquePaths solution = new Code62UniquePaths();
        int result = solution.uniquePaths(7, 3);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}
