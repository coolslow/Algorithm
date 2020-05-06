package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.List;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *  输入: "Let's take LeetCode contest"
 *  输出: "s'teL ekat edoCteeL tsetnoc"
 *
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class NO557_ReverseWordsInStringIII {

    /**
     * 方法一：采用语言特性的内置函数处理
     *
     * 时间复杂度：O(n) 。其中 n 是字符串的长度。
     * 空间复杂度：O(n) 。使用了大小为 n 的 res。
     *
     * @param s 给定的单词
     * @return 返回反转后的字符串
     */
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (String word: words) {
            res.append(new StringBuffer(word).reverse().toString()).append(" ");
        }
        return res.toString().trim();
    }

    /**
     * 方法二：采用自定义方法处理
     *
     * 时间复杂度：O(n) 。其中 n 是字符串的长度。
     * 空间复杂度：O(n) 。使用了大小为 n 的 res。
     *
     * @param s 给定的单词
     * @return 返回反转后的字符串
     */
    public static String reverseWordsII(String s) {
        String[] words = split(s);
        StringBuilder sb = new StringBuilder();

        for (String word: words) {
            sb.append(reverse(word)).append(" ");
        }

        return sb.toString().trim();
    }

    private static String[] split(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(s.charAt(i));
            }
        }
        words.add(sb.toString());
        int size = words.size();
        return words.toArray(new String[size]);
    }

    private static String reverse(String s) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            res.insert(0, s.charAt(i));
        }

        return res.toString();
    }
}
