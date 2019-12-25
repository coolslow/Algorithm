package com.coolslow.leetcode.topics.array;

import com.coolslow.datastruct.utils.MyData;
import com.coolslow.datastruct.utils.MyUtils;
import org.junit.Test;

/**
 * 移动零
 * by MrThanksgiving
 */
public class Code283MoveZeroes {

    /**
     * <pre>
     * 题目：
     *      给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *      输入: [0,1,0,3,12]
     *      输出: [1,3,12,0,0]
     *
     * 说明:
     *      必须在原数组上操作，不能拷贝额外的数组。
     *      尽量减少操作次数。
     * </pre>
     */
    public void moveZeroes(int[] nums) {
    }

    @Test
    public void testSolution() {
        int[] nums = {1,2,};
        moveZeroes(nums);
        MyUtils.printArray(nums);

//        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}
