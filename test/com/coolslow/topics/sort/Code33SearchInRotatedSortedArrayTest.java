package com.coolslow.topics.sort;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.sort.Code33SearchInRotatedSortedArray;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code33SearchInRotatedSortedArrayTest {

    @Test
    public void testSolution() {
        Code33SearchInRotatedSortedArray solution = new Code33SearchInRotatedSortedArray();
        int[] input = {1,3};
        int target = 2;
        int result = solution.search(input, target);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}
