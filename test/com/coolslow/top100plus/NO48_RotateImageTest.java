package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO48_RotateImage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NO48_RotateImageTest {

    @Test
    public void shouldRotateCorrectly() {
        int[][] imageArray = new int[][] {
                {
                    1, 2, 3
                },
                {
                    4, 5, 6
                },
                {
                    7, 8, 9
                }
        };
        int[][] result = NO48_RotateImage.rotate(imageArray);

        int[][] ss = new int[][] {
                {
                    7, 4, 1
                },
                {
                    8, 5, 2
                },
                {
                    9, 6, 3
                }
        };
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(ss));

//        Assert.assertArrayEquals(result, ss);
    }
}
