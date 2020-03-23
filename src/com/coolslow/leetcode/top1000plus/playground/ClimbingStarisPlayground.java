package com.coolslow.leetcode.top1000plus.playground;

import com.coolslow.common.Playground;

@Playground(name = "爬楼梯", rank = Playground.Difficulty.Easy)
public class ClimbingStarisPlayground {
    public static int climbingStairs(int n) {
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
}
