package com.coolslow.leetcode.top1000plus;

/**
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 参考：https://leetcode-cn.com/problems/water-and-jug-problem/solution/hu-dan-long-wei-liang-zhang-you-yi-si-de-tu-by-ant/
 */
public class NO365_WaterJugProblem {

    /**
     * GCD 方法
     * @param x x 容量
     * @param y y 容量
     * @param z 给定的 z 升水
     * @return z 升水是否能能被装满
     */
    public boolean canMeasureWater(int x, int y, int z) {

        if (z == 0) return true;
        if (x + y < z) return false;

        int big = Math.max(x, y);
        int small = x + y - big;

        if (small == 0) return big == z;


        while (big % small != 0) {
            int temp = small;
            small = big % small;
            big = temp;
        }
        return z % small == 0;
    }
}
