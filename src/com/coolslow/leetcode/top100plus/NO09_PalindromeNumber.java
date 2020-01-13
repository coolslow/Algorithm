package com.coolslow.leetcode.top100plus;

/**
 * 9. 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *  输入: 121
 *  输出: true
 *
 * 示例 2:
 *  输入: -121
 *  输出: false
 *  解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 *  输入: 10
 *  输出: false
 *  解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 */
public class NO09_PalindromeNumber {

    /**
     * 解法一：通过将int值转换为string后再比较，如果反转后的字符串与原来的字符串不相等，则返回false，否则返回true
     *
     * @param x 输入的int值
     * @return 是否回文数 true为回文 | false不为回文
     */
    public static boolean isPaliedrome(int x) {
        StringBuilder sb = new StringBuilder(x + "");
        String reverseStr = sb.reverse().toString();
        return (x + "").equals(reverseStr);
    }

    public static boolean isPaliedromeBetter(int x) {
        // 处理特殊情况
        // 1. 排除负数的情况，负数一定不是回文
        // 2. 数组最后一位是0，也一定不是回文，因为反转后，首位将会为0，除了0以外，没有其他数满足该条件
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNum = 0;
        while(x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，可以通过revertedNum/10去除处于中位的数字
        // 例如：当输入为12321是，在while循环的末尾，我们可以得到 x = 12，revertedNum = 123
        // 由于处于中位的数字不影响回文（它总和自己相等），因此，可以简单的将其去除。
        return (x == revertedNum || x == revertedNum / 10);
    }
}
