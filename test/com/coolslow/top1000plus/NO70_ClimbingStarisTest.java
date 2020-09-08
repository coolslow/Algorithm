package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO70_ClimbingStairs;
import org.junit.Assert;
import org.junit.Test;

public class NO70_ClimbingStarisTest {

    @Test
    public void climbingStarisTest() {
        int test = NO70_ClimbingStairs.climbStairsFibonacci(1);
        Assert.assertEquals(1, test);

        int test0 = NO70_ClimbingStairs.climbStairsFibonacci(2);
        Assert.assertEquals(2, test0);

        int test1 = NO70_ClimbingStairs.climbStairsWithRecursion(3);
        Assert.assertEquals(3, test1);

        int test3 = NO70_ClimbingStairs.climbStairsFibonacciNotUseArray(4);
        Assert.assertEquals(5, test3);

        int test2 = NO70_ClimbingStairs.climbStairsWithRecursion(5);
        Assert.assertEquals(8, test2);
    }
}
