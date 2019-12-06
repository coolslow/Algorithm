package com.coolslow.leetcode.top100.playground;

import com.coolslow.common.Playground;
import com.coolslow.common.Solution;
import com.coolslow.common.Topics;

@Playground(name = "反转整数", rank = Playground.Difficulty.Easy)
public class ReverseIntegerPlayground {

    @Solution(desc = "解法1：普通方法")
    @Topics(tags = Topics.Tags.String)
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/10 && pop > 7)
                return 0;
            if(rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE/10 && pop < -8)
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}