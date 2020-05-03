package com.coolslow.leetcode.top1000plus;

/**
 * 38. 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *  1.     1
 *  2.     11
 *  3.     21
 *  4.     1211
 *  5.     111221
 *
 *  1 被读作  "one 1"  ("一个一") , 即 11。
 *  11 被读作 "two 1s" ("两个一"）, 即 21。
 *  21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 *  给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *  注意：整数序列中的每一项将表示为一个字符串。
 *
 *  示例 1:
 *      输入: 1
 *      输出: "1"
 *      解释：这是一个基本样例。
 *
 *  示例 2:
 *      输入: 4
 *      输出: "1211"
 *      解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；
 *      类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 *
 */
public class NO38_CountAndSay {

    /**
     * 递归解法
     * @param n 给定的整数 n，(1 <= n <= 30)
     * @return 返回String类型的对给定n的上一个数字的描述
     */
    public static String countAndSay(int n) {
        // 声明一个StringBuilder来保存输出的字符串
        StringBuilder sb = new StringBuilder();

        int p1 = 0, cur = 1;
        if(n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);
        for(cur = 1; cur < str.length(); cur++) {
            if(str.charAt(p1) != str.charAt(cur)) {
                int count = cur - p1;
                sb.append(count).append(str.charAt(p1));
                p1 = cur;
            }
        }

//        if(p1 != cur) {
//            int count = cur - p1;
//            sb.append(count).append(str.charAt(p1));
//        }

        int count = cur - p1;
        sb.append(count).append(str.charAt(p1));

        return sb.toString();
    }
}
