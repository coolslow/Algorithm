package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO70_ClimbingStairs;
import org.junit.Assert;
import org.junit.Test;

public class NO70_ClimbingStarisTest {

    @Test
    public void climbingStarisTest() {
        int test1 = NO70_ClimbingStairs.climbStairsWithRecursion(3);
        Assert.assertEquals(3, test1);

        int test2 = NO70_ClimbingStairs.climbStairsWithRecursion(5);
        Assert.assertEquals(8, test2);
    }
}
