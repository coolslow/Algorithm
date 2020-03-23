package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class NO22_GenerateParentheses {

    /**
     * 闭合数方法
     * 时间和空间复杂度：O(4^n/sqrt(n))
     *
     * @param n 给定的数子
     * @return 返回一个包含所有正确格式的括号数组
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        if (n == 0) {
            ans.add("");
        } else {
            for(int c = 0; c < n; c++) {
                for(String left: generateParenthesis(c)) {
                    for(String right : generateParenthesis(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }

        return ans;
    }
}
