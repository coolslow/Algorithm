package com.coolslow.leetcode.top100plus;

/**
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例1：
 *      输入: "babad"
 *      输出: "bab"
 *      注意: "aba" 也是一个有效答案。
 *
 * 示例2：
 *      输入: "cbbd"
 *      输出: "bb"
 *
 * 解法：暴力破解法
 *
 * 解法：动态规划
 *      由于暴力解法的时间复杂度为O(n^3)，为避免在验证回文时进行不必要的重复计算。
 *      那么：如果已经确认是一个回文子串，那么它左由两侧是相同字母的话，必定是回文的。
 *
 *      时间复杂度：O(n^2)
 *      空间复杂度：O(n^2)
 *
 * 解法：中心扩展法
 *      我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1 个这样的中心。
 *
 * 解法：Manacher 算法
 *      还有一个复杂度为 O(n)的 Manacher 算法。然而，这是一个非同寻常的算法，在 45 分钟的编码时间内提出这个算法将会是一个不折不扣的挑战。
 *      理解它，将是非常有趣的。
 *
 */
public class NO05_LongestPalindromicSubstring {

    /**
     * 暴力解法
     * @return 返回回文子串
     */
    public static String longestPalindromicSubString(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if(isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    /**
     * 判断是否为回文
     * @param s 子字符串
     * @return 返回是否回文的标记
     */
    private static boolean isPalindromic(String s) {
        int len = s.length();
        for(int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    ///////////////////////////////////////////////////

    /**
     * 根据回文串的定义，正着和反着读一样，那么把原来的字符串倒置，然后找最长的公共子串就可以了。（思路有漏洞，可纠正）
     *
     * 这里采用动态规划的办法，申请一个二维的数组初始化为 0，然后判断对应的字符是否相等
     * arr [ i ][ j ] = arr [ i - 1 ][ j - 1] + 1
     * 当 i = 0 或者 j = 0 的时候单独分析，字符相等的话 arr [ i ][ j ] 就赋为 1 。
     * arr [ i ][ j ] 保存的就是公共子串的长度
     *
     * @return
     */
    public static String longestPalindromeWithCommonMethod(String s) {
        if(s.equals("")) {
            return s;
        }
        String origin = s;
        //字符串倒置
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];

        int maxLen = 0;
        int maxEnd = 0;
        for(int i = 0; i < length; i++) {
            for(int j = length - 1; j >= 0; j--) {
                // 判断下标是否对应
                if (origin.charAt(i) == reverse.charAt(j)) {
                    // 对于 i = 0, j = 0 的情况单独处理
                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }
                } else {
                    arr[j] = 0;
                }

                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if(beforeRev + arr[j] - 1 == i) {
                        maxLen = arr[j];
                        // 以 i 位置结尾的字符
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}
