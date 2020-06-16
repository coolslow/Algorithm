package com.coolslow.leetcode.interview.topics.recursive;

public class NO344_ReverseString {

    public static void reverseStringWithRecursion(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private static void helper(char[] s, int start, int end) {
        if(start >= end) {
            return;
        }

        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        start++;
        end--;

        helper(s, start, end);
    }
}
