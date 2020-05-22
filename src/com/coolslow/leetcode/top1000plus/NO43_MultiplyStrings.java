package com.coolslow.leetcode.top1000plus;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 说明：
 * - num1 和 num2 的长度小于110。
 * - num1 和 num2 只包含数字 0-9。
 * - num1 和 num2 均不以零开头，除非是数字 0 本身。
 * - 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
public class NO43_MultiplyStrings {

//    /**
//     * 思路：因为num1和num2可能非常长，因此不能直接转为整型运算（题目也不允许）因此只能模拟手动乘法的办法
//     *
//     * NOTE: 该解法无法通过测试拥立
//     */
//    public static String multiply(String num1, String num2) {
//
//        if(num1.equals("0") && num2.equals("0")) {
//            return "0";
//        }
//        String res = "";
//        for(int i = num2.length() - 1; i >= 0; i--) {
//            int carry = 0;
//            // 保存 num2 第i位数字与 num1 相乘的结果
//            StringBuilder temp = new StringBuilder();
//            for(int j = 0; j < num2.length() - 1 - i; j++) {
//                temp.append(0);
//            }
//            int n2 = num2.charAt(i) - '0';
//
//            // num2 的第 i 位数字 n2 与 num1 相乘
//            for(int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
//                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
//                int product = (n1 * n2 + carry) % 10;
//                temp.append(product);
//                carry = (n1 * n2 + carry) / 10;
//            }
//            // 将当前结果与新计算的结果求和作为新的结果
//            res = addStrings(res, temp.reverse().toString());
//        }
//
//        return res;
//    }
//
//    /**
//     * 对两个字符串数字进行相加，返回字符串形式的和
//     */
//    public static String addStrings(String num1, String num2) {
//        StringBuilder builder = new StringBuilder();
//        int carry = 0;
//        for (int i = num1.length() - 1, j = num2.length() - 1;
//             i >= 0 || j >= 0 || carry != 0;
//             i--, j--) {
//            int x = i < 0 ? 0 : num1.charAt(i) - '0';
//            int y = j < 0 ? 0 : num2.charAt(j) - '0';
//            int sum = (x + y + carry) % 10;
//            builder.append(sum);
//            carry = (x + y + carry) / 10;
//        }
//        return builder.reverse().toString();
//    }

    /**
     * 解法二：优化竖式
     * @param num1
     * @param num2
     * @return
     */
    public static String multiplyII(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
}
