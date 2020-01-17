package com.coolslow.leetcode.topics.backtracking;

import java.util.*;

/**
 * 电话号码的字母组合
 * by MrThanksgiving
 */
public class Code17LetterCombinationsOfAPhoneNumber {

    /**
     * <pre>
     * 题目：
     *      给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *      给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *      2(abc),3(def),4(ghi)5(jkl),6(mno),7(pqrs),8(tuv),9(yxwz),0(),1(!@#),*(+),#()
     *
     * 示例:
     *      输入："23"
     *      输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * 说明:
     *      尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * </pre>
     */
    private String[] letterMap = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return result;
        helper(digits, 0, "");
        return result;
    }

    private void helper(String digits, int index, String s) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }
        char ch = digits.charAt(index);
        String letters = letterMap[ch - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(digits, index + 1, s + letters.charAt(i));
        }
    }

}
