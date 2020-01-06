package com.coolslow.leetcode.topics.string;

/**
 * 外观数列
 * by MrThanksgiving
 */
public class Code38CountAndSay {

    /**
     * <pre>
     * 题目：
     *      外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
     *      1.     1
     *      2.     11
     *      3.     21
     *      4.     1211
     *      5.     111221
     *      6.     312211
     *      7.     13112211
     *      1 被读作  "one 1"  ("一个一") , 即 11。
     *      11 被读作 "two 1s" ("两个一"）, 即 21。
     *      21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *      给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
     *      注意：整数序列中的每一项将表示为一个字符串。
     *
     * 示例 1:
     *      输入: 1
     *      输出: "1"
     *
     * 示例 2:
     *      输入: 4
     *      输出: "1211"
     *
     * </pre>
     */
    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        StringBuilder builder = new StringBuilder("1");
        StringBuilder result = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            char[] chars = builder.toString().toCharArray();
            char temp = chars[0];
            int count = 0;
            boolean isAppend = false;
            for (char ch : chars) {
                if (ch == temp) {
                    count++;
                    if (!isAppend) {
                        result.append(count).append(temp);
                        isAppend = true;
                    } else {
                        result.delete(result.length() - 2, result.length());
                        result.append(count).append(temp);
                    }
                } else {
                    temp = ch;
                    count = 1;
                    result.append(count).append(temp);
                    isAppend = true;
                }
            }
            builder = result;
            result = new StringBuilder();
        }
        return builder.toString();
    }

}
