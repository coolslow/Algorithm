package com.coolslow.leetcode.top1000plus;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *   1. 左括号必须用相同类型的右括号闭合。
 *   2. 左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例1：
 *      输入: "()"
 *      输出: true
 *
 * 示例2：
 *      输入: "()[]{}"
 *      输出: true
 *
 * 示例3：
 *      输入: "(]"
 *      输出: false
 *
 * 示例4：
 *      输入: "([)]"
 *      输出: false
 *
 * 示例5：
 *      输入: "{[]}"
 *      输出: true
 *
 *
 */
public class NO20_ValidParentheses {

    public static boolean isValidParentheses(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(map.containsKey(ch)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if(topElement != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidParenthesesShort(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
