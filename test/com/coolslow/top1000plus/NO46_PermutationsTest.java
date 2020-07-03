package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO46_Permutations;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NO46_PermutationsTest {

    @Test
    public void shouldGetCorrectly() {

        int[] input1 = {1, 2, 3};

        List<List<Integer>> result = NO46_Permutations.permuteII(input1);
        System.out.println(result);
    }
}
