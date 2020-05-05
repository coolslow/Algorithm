package com.coolslow.leetcode.top1000plus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串中的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *  输入: "the sky is blue"
 *  输出: "blue is sky the"
 *
 * 示例 2：
 *  输入: "  hello world!  "
 *  输出: "world! hello"
 *  解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 *  输入: "a good   example"
 *  输出: "example good a"
 *  解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class NO151_ReverseWordsInString {

    /**
     * 方法一：使用语言特性
     * 思路：
     * 很多语言对字符串提供了 split（拆分），reverse（翻转）和 join（连接）等方法，因此我们可以简单的调用内置的 API 完成操作：
     * 1. 使用 split 将字符串按空格分割成字符串数组；
     * 2. 使用 reverse 将字符串数组进行反转；
     * 3. 使用 join 方法将字符串数组拼成一个字符串。
     *
     * 时间复杂度：O(N)，其中 N 为输入字符串的长度。
     * 空间复杂度：O(N)，用来存储字符串分割之后的结果。
     */
    public static String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
