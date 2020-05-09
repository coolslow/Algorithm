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
     * 解法一：暴力法
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
        // 检查栈是否为空，为空表示括号是有效的，否则括号无效
        return stack.empty();
    }

    /**
     * 解法二：动态规划法
     *
     * 也可以通过动态规划解决此类问题。
     * 定义一个dp数组，其中第i个元素表示以下标为i的自负结尾的最长有效子字符串的长度。
     * 先将dp数组全部初始化为0。
     * 可以知道，有效的子字符串一定以')'结尾。可以进一步得出结论：以'('结尾的子字符串对应的dp数组位置上的值必定为0。
     * 所以说我们只需要更新')'在 dp 数组中对应位置的值。
     * 为了求出dp数组，我们每两个字符检查一次，如果满足如下条件：
     *  1. s[i] = ')' 且 s[i - 1] = '('，也就是字符串形如："......()"，我们可以推出：
     *          dp[i] = dp[i - 2] + 2
     *     可以理解为：因为结束部分的"()"是一个有效的子字符串，并且将之前有效子字符串的长度增加了2
     *  2. s[i] = ')' 且 s[i - 1] = ')'，也就是字符串形如："......))"，我们可以推出：
     *          dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
     *
     * @param s 给定的字符串
     * @return 返回有效括号的最大长度
     *
     * 时间复杂度：O(n)。遍历整个字符串一次，就可以将 dp 数组求出来。
     * 空间复杂度：O(n)。需要一个大小为 n 的 dp 数组。
     *
     */
    public static int longestValidParenthesesWithDp(String s) {
        int maxAns = 0;
        int[] dp = new int[s.length()];
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxAns = Math.max(maxAns, dp[i]);
            }
        }

        return maxAns;
    }

    /**
     * 解法三：利用栈求解
     *
     * 算法：与找到每个可能的子字符串后再判断它的有效性不同，我们可以用栈在遍历给定字符串的过程中
     * 去判断到目前为止扫描的子字符串的有效性，同时能得到最长有效字符串的长度。
     *
     * 我们首先将 -1 放入栈顶。
     * - 对于遇到的每个'('，我们将它的下标放入栈中。
     * - 对于遇到的每个')'，我们弹出栈顶的元素并将当前元素的下标与弹出元素的下标做差。得出当前有效括号字符串的长度。
     *   通过这种方法，我们继续计算有效子字符串的长度，并最终返回最长有效子字符串的长度。
     *
     * @param s 给定的字符串
     * @return 返回有效括号的最大长度
     *
     * 时间复杂度：O(n)。n是给定字符串的长度。
     * 空间复杂度：O(n)。栈的大小最大达到n。
     */
    public static int longestValidParenthesesWithStack(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    /**
     * 解法四：无需额外辅助空间
     *
     * 思想：在这个方法中，利用两个计数器left和right。
     * 首先，从左到右遍历字符串，对于遇到的每个'('，我们增加 left 计算器，对于遇到的每个 ')' ，就增加 right 计数器。
     * 每当 left 计数器与 right 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。
     * 如果 right 计数器比 left 计数器大时，我们将 left 和 right 计数器同时变回 0。
     *
     * 接下来，从右到左再做一次类似的操作。
     *
     * @param s 给定的字符串
     * @return 返回有效括号的最大长度
     */
    public static int longestValidParenthesesWithoutExtraSpace(String s) {
        int left = 0, right = 0, maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if ( left >= right) {
                left = right = 0;
            }
        }

        return maxLength;
    }
}
