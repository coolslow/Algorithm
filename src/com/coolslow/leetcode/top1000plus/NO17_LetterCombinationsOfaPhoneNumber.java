package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * 17. 电话号码的字母组合
 * 题目：给定一个仅包含数字 2 ～ 9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *    1(!@#)   2(abc)   3(def)
 *    4(ghi)   5(jkl)   6(mno)
 *    7(pqrs)  8(tuv)   9(wxyz)
 *
 * 示例：
 *      输入："23"
 *      输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 时间复杂度：O(3^N * 4^M)，其中 N 是输入数字中对应 3 个字母的数目（比方说 2，3，4，5，6，8）， M 是输入数字中对应 4 个字母的数目（比方说 7，9），N+M 是输入数字的总数
 * 空间复杂度：O(3^N * 4^M)，这是因为需要保存 (3^N + 4^M) 个结果
 */
public class NO17_LetterCombinationsOfaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backTrack("", digits);
        return output;
    }

    // 创建数字与字母间的Mapping关系
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    // 声明一个待输出的List<String>
    List<String> output = new ArrayList<>();

    private void backTrack(String combination, String nextDigits) {

        // 如果没有更多的数字，返回
        if (nextDigits.length() == 0) {
            output.add(combination);
        }
        // 处理仍然有数字时的情况
        else {
            // 获取下一个数字
            String digit = nextDigits.substring(0, 1);
            // 根据数字获取对应的字母串
            String letters = phone.get(digit);

            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backTrack(combination + letter, nextDigits.substring(1));
            }
        }
    }
}
