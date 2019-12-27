package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code027RemoveElement;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code027RemoveElementTest {

    @Test
    public void testSolution() {
        Code027RemoveElement solution = new Code027RemoveElement();
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int result = solution.removeElement(nums, val);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        MyUtils.printArray(nums);
    }
}
