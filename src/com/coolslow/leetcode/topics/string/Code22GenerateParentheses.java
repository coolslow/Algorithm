package com.coolslow.leetcode.topics.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * by MrThanksgiving
 */
public class Code22GenerateParentheses {

    /**
     * <pre>
     * 题目：
     *      给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如:
     *      给出 n = 3，生成结果为：
     *      [
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * </pre>
     */
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return result;
        helper(n, n, "");
        return result;
    }

    private void helper(int lp, int rp, String s) {
        if (lp == 0 && rp == 0) {
            result.add(s);
            return;
        }
        if (lp > 0)
            helper(lp - 1, rp, s + "(");
        if (rp > lp)
            helper(lp, rp - 1, s + ")");

    }

}
