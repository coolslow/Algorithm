package com.coolslow.leetcode.top1000plus;

/**
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * [注]：数组每位都是single digit，所以只能是 0 - 9 的个位数，数组第一个数字必须为非0。
 *
 * 示例1：
 *  输入: [1,2,3]
 *  输出: [1,2,4]
 *  解释: 输入数组表示数字 123。
 *
 * 示例2：
 *  输入: [4,3,2,1]
 *  输出: [4,3,2,2]
 *  解释: 输入数组表示数字 4321。
 *
 *
 * -------------------------------------------
 * 思路：
 * 根据题目意思，因为只是加一，所以有可能的情况有两种：
 * 1. 除 9 之外的数字加一；
 * 2. 数字 9 加一。
 *
 */
public class NO66_PlusOne {

    public static int[] plusOne1(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0) {
               return digits;
            }
        }
        // 处理[9, 9, 9]这类数组加一的情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        int len = digits.length;
        for(int i= len - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
                // 当数组位于最高位时，向前进一时需要创建一个新的数组保存进位的数据
                if(i == 0) {
                    digits = new int[len + 1];
                    digits[0] = 1;
                }
            }
        }
        return digits;
    }
}
