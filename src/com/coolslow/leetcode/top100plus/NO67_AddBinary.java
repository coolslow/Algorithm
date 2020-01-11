package com.coolslow.leetcode.top100plus;

/**
 * 67. 二进制求和
 * 要求：给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *  输入: a = "11", b = "1"
 *  输出: "100"
 *
 * 示例 2:
 *  输入: a = "1010", b = "1011"
 *  输出: "10101"
 */
public class NO67_AddBinary {
    /** 二进制求和，不要转成整数，防止产生溢出问题 */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
