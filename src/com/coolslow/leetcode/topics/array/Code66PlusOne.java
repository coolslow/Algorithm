package com.coolslow.leetcode.topics.array;

/**
 * 加一
 * by MrThanksgiving
 */
public class Code66PlusOne {

    /**
     * <pre>
     * 题目：
     *      给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *      最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *      你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     *      输入: [1,2,3]
     *      输出: [1,2,4]
     *      解释: 输入数组表示数字 123。
     *
     * 示例 2:
     *      输入: [4,3,2,1]
     *      输出: [4,3,2,2]
     *      解释: 输入数组表示数字 4321。
     *
     * </pre>
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }

}
