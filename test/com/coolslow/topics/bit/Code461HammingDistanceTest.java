package com.coolslow.topics.bit;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.bit.Code461HammingDistance;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code461HammingDistanceTest {

    @Test
    public void testSolution() {
        MyUtils.print(Integer.MAX_VALUE+"");;

        Code461HammingDistance solution = new Code461HammingDistance();
        int x = 1;
        int y = 4;
        int result = solution.hammingDistance(x, y);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
