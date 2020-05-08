package com.coolslow.leetcode.top1000plus;

/**
 * 344. 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 *  输入：["h","e","l","l","o"]
 *  输出：["o","l","l","e","h"]
 *
 * 示例 2：
 *  输入：["H","a","n","n","a","h"]
 *  输出：["h","a","n","n","a","H"]
 *
 */
public class NO344_ReverseString {

    /**
     * 方法一：双指针
     * @param s 给定的字符串数组
     */
    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;

        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            start++;
            end--;
        }
    }

    /**
     * 方法二：递归
     *
     * 使用递归的办法反转字符串，它是原地反转，但空间复杂度却不是常数级空间，因为递归过程中使用了堆栈空间
     * 算法：实现一个递归函数helper，它接受两个参数 left 左指针，right 右指针。
     * - 如果 left >= right，不做任何操作
     * - 否则交换 s[left] 和 s[right] 和调用 helper(left + 1, right - 1)。
     *   首次调用函数我们传递首尾指针反转整个字符串 return helper(0, len(s) - 1)。
     *
     * 复杂度分析：
     * 时间复杂度：O(N)。
     * 空间复杂度：O(N)，递归过程中使用的堆栈空间。
     */
    public static void reverseStringWithRecursion(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private static void helper(char[] s, int left, int right) {
        if(left >= right) {
            return;
        }

        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;

        left++;
        right--;

        helper(s, left, right);
    }
}
