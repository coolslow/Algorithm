package com.coolslow.leetcode.top100;

/**
 * @author ming
 *
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯，需要n阶你才能达到顶楼。
 *
 * 每次你可以爬1或2个台阶，你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定的n是一个真整数。
 *
 * 示例1：
 *      输入： 2
 *      输出： 2
 *      解释： 有两种方法可以爬到楼顶。
 *      - 1.  1 阶 + 1 阶
 *      - 2.  2 阶
 *
 *  示例 2：
 *      输入： 3
 *      输出： 3
 *      解释： 有三种方法可以爬到楼顶。
 *      1.  1 阶 + 1 阶 + 1 阶
 *      2.  1 阶 + 2 阶
 *      3.  2 阶 + 1 阶
 */
public class NO70_ClimbingStairs {

    /**
     * 解题思路：
     *      - 通过题目本身理解出这是一个斐波那契问题
     *      - 第一想法使用递归的方式，但是递归最大的问题时以及计算的值没有被记录，导致占据内存太多
     *      - 可以正向考虑，通过一次遍历拿到目标值，遍历时注意避免使用数组
     *
     * @param n 指定的数字n
     * @return 返回有多少种一次走一步或两步能达到n的解法
     */
    public static int climbStairsFibonacci(int n) {
        if(n == 1 || n ==2) {
            return n;
        }
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;

        for(int i = 2; i < n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i -2];
        }

        return stairs[n - 1];
    }

    /**
     * 解题思路：
     *  - 可以设法避免使用数组来存储对应的结果，因为最重要拿到的那个结果只是一个值，中间结果并不重要
     *  - 因此，可以采用三个变量交换的方式来得到并存储最后要计算的那个结果
     *
     * @param n 指定的数字n
     * @return 返回有多少种一次走一步或两步能达到n的解法
     */
    public static int climbStairsFibonacciNotUseArray(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return n;
        }

        int pre = 1;
        int cur = 2;
        int tmp;
        for(int i = 3; i <=n; i++) {
            tmp = pre + cur;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

    /** 解题思路：
     * Java的话因为返回值为int，n = 46时，结果会溢出，因此n < 46，有如下show翻天，脑洞大开的解法
     */
    public static int climbStairsShowOff(int n) {
        int result = 0;

        switch(n){
            case 1: result = 1; break;
            case 2: result = 2; break;
            case 3: result = 3; break;
            case 4: result = 5; break;
            case 5: result = 8; break;
            case 6: result = 13; break;
            case 7: result = 21; break;
            case 8: result = 34; break;
            case 9: result = 55; break;
            case 10: result = 89; break;
            case 11: result = 144; break;
            case 12: result = 233; break;
            case 13: result = 377; break;
            case 14: result = 610; break;
            case 15: result = 987; break;
            case 16: result = 1597; break;
            case 17: result = 2584; break;
            case 18: result = 4181; break;
            case 19: result = 6765; break;
            case 20: result = 10946; break;
            case 21: result = 17711; break;
            case 22: result = 28657; break;
            case 23: result = 46368; break;
            case 24: result = 75025; break;
            case 25: result = 121393; break;
            case 26: result = 196418; break;
            case 27: result = 317811; break;
            case 28: result = 514229; break;
            case 29: result = 832040; break;
            case 30: result = 1346269; break;
            case 31: result = 2178309; break;
            case 32: result = 3524578; break;
            case 33: result = 5702887; break;
            case 34: result = 9227465; break;
            case 35: result = 14930352; break;
            case 36: result = 24157817; break;
            case 37: result = 39088169; break;
            case 38: result = 63245986; break;
            case 39: result = 102334155; break;
            case 40: result = 165580141; break;
            case 41: result = 267914296; break;
            case 42: result = 433494437; break;
            case 43: result = 701408733; break;
            case 44: result = 1134903170; break;
            case 45: result = 1836311903; break;
            default: break;
        }
        return result;
    }
}
