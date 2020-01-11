package com.coolslow.leetcode.topics.math;

/**
 * 整数转罗马数字
 * by MrThanksgiving
 */
public class Code12IntegerToRoman {

    /**
     * <pre>
     * 题目：
     *      罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     *      字符          数值
     *      I             1
     *      V             5
     *      X             10
     *      L             50
     *      C             100
     *      D             500
     *      M             1000
     *      例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     *      通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     *      I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     *      X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     *      C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *      给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     *
     * 示例 1:
     *      输入: 3
     *      输出: "III"
     *
     * 示例 2:
     *      输入: 4
     *      输出: "IV"
     *
     * 示例 3:
     *      输入: 9
     *      输出: "IX"
     *
     * 示例 4:
     *      输入: 58
     *      输出: "LVIII"
     *      解释: L = 50, V = 5, III = 3.
     *
     * 示例 5:
     *      输入: 1994
     *      输出: "MCMXCIV"
     *      解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * </pre>
     */

    public String intToRoman(int num) {
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roma = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        int i = nums.length - 1;
        while (i >= 0) {
            if (num >= nums[i]) {
                sb.append(roma[i]);
                num = num - nums[i];
            } else i--;
        }
        return sb.toString();
    }


    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num / 1000 >= 1) {
                append(sb, "M", num / 1000);
                num = num % 1000;
            } else if (num / 500 >= 1) {
                if (num % 1000 >= 900) {
                    append(sb, "CM", 1);
                    num = num % 900;
                } else {
                    append(sb, "D", num / 500);
                    num = num % 500;
                }
            } else if (num / 100 >= 1) {
                if (num % 500 >= 400) {
                    append(sb, "CD", 1);
                    num = num % 400;
                } else {
                    append(sb, "C", num / 100);
                    num = num % 100;
                }
            } else if (num / 50 >= 1) {
                if (num % 100 >= 90) {
                    append(sb, "XC", 1);
                    num = num % 90;
                } else {
                    append(sb, "L", num / 50);
                    num = num % 50;
                }
            } else if (num / 10 >= 1) {
                if (num % 50 >= 40) {
                    append(sb, "XL", 1);
                    num = num % 40;
                } else {
                    append(sb, "X", num / 10);
                    num = num % 10;
                }
            } else if (num / 5 >= 1) {
                if (num % 10 >= 9) {
                    append(sb, "IX", 1);
                    num = num % 9;
                } else {
                    append(sb, "V", num / 5);
                    num = num % 5;
                }
            } else if (num >= 1) {
                if (num % 5 >= 4) {
                    append(sb, "IV", 1);
                    num = num % 4;
                } else {
                    append(sb, "I", num);
                    num = 0;
                }
            }
        }
        return sb.toString();
    }

    public void append(StringBuilder sb, String s, int n) {
        for (int i = 0; i < n; i++)
            sb.append(s);
    }


}
