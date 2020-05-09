package com.coolslow.leetcode.top1000plus;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *  输入: "(()"
 *  输出: 2
 *  解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 *  输入: ")()())"
 *  输出: 4
 *  解释: 最长有效括号子串为 "()()"
 */
public class NO32_LongestValidParentheses {

    /**
     * 暴力法
     *
     * 算法：考虑给定字符串中每种可能的非空偶数长度字符串，检查它是否是一个有效括号字符串序列。
     * 为检查有效性，可以使用栈方法。
     *
     * @param s 给定的字符串
     * @return 返回有效括号的最大长度
     *
     * 时间复杂度：O(N^3)
     * 空间复杂度：O(N)
     *
     */
    public static int longestValidParentheses(String s) {
        // 初始化最大有效括号的长度，默认为0
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 2; j <= s.length(); j+= 2) {
                if(isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }

        return maxLen;
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            }
            // 如果栈部位空，且查看栈顶部元素如果 == '(' 则出栈
            else if(!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
