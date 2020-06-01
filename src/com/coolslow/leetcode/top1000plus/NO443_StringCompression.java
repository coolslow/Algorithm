package com.coolslow.leetcode.top1000plus;

/**
 * 443. 简单字符串压缩
 *
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为 1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 示例 1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 *
 * 示例 2：
 * 输入：
 * ["a"]
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * 说明：
 * 没有任何字符串被替代。
 *
 * 示例 3：
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 *
 */
public class NO443_StringCompression {

    /**
     * 方法一：利用滑动窗口，左右指针起点都为原数组的首位。
     * 实现思路：
     * 1. 不断右移右指针，使窗口不断增大；
     * 2. 当窗口内出现一个不同的元素时，就可以将元素及其数量（等于左右指针之差）更新在数组中，然后让左指针指向右指针；
     * 3. 遍历到最后一个字符时也需要结算，因此将右指针的终点设为数组之外一格。当右指针移到终点时也要更新数组。
     *
     * @param chars 给定的字符数组
     * @return 返回数组的新长度 int 类型
     */
    public static int compress(char[] chars) {
        int left = 0;
        int size = 0;

        for(int right = 0; right <= chars.length; right++) {
            if(right == chars.length || chars[right] != chars[left]) {
                // 更新字符
                chars[size] = chars[left];
                size++;
                // 更新计数，当个数大于 1 时才更新
                if(right - left > 1) {
                    for(char c: String.valueOf(right - left).toCharArray()) {
                        chars[size] = c;
                        size++;
                    }
                }
                left = right;
            }
        }

        return size;
    }

    public static String compressString(String s) {
        // 设置两个指针，将pLeft和pRight都指向下标为0的第1个元素
        int pLeft = 0;
        int pRight = 0;

        // 计数器
        int counter = 1;
        char[] strArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        // 最后一个位置也要检查
        for(int i = 1; i < strArr.length; i++) {
            if(strArr[pRight] == strArr[i]) {
                counter++;
                pRight++;
            } else {
                counter = 1;
            }
            pLeft = pRight;
        }

        return sb.toString();
    }
}
