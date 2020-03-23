package com.coolslow.leetcode.top1000plus;

/**
 * 69. X的平方根
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *  - 输入: 4
 *  - 输出: 2
 *
 * 示例 2:
 *  - 输入: 8
 *  - 输出: 2
 *
 * 说明:
 *  8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class NO69_SqrtX {

    /**
     * 方法一：二分法
     *
     * 思路：使用二分法搜索平方根的思想很简单，就类似于小时候我们看的电视节目中的“猜价格”游戏，高了就往低了猜，低了就往高了猜，范围越来越小。
     * 因此，使用二分法猜算术平方根就很自然。
     *
     * @param x 给出的整数
     * @return 返回整数 x 对应的平方根
     */
    public static int mySqrtWithDichotomyMethod(int x) {
        long left = 0;
        // 为了照顾到 1 把右边界设置为 (x / 2 + 1)
        long right = x / 2 + 1;
        while(left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if(square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }

    /**
     * 方法二：牛顿法
     * 使用牛顿法可以得到一个正整数的算术平方根，因为题目中说："结果只保留整数部分"。
     * 因此，可以把使用牛顿法得到的浮点数抓换为整数即可。
     *
     * 牛顿法思想：
     * 在迭代的过程中，以直线代替曲线，用一阶泰勒展开式（即在当前点的切线）替代原来的曲线，求直线与x轴的交点。
     *
     * @param x 给出的整数
     * @return 返回整数 x 对应的平方根
     */
    public static int mySqrtWithNewTonMethod(int x) {
        long a = x;
        while( a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int)a;
    }
}
