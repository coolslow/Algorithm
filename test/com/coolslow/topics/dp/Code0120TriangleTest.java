package com.coolslow.topics.dp;


import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code120Triangle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三角形最小路径和
 * by MrThanksgiving
 */
public class Code120TriangleTest {


    @Test
    public void testSolution() {

        Code120Triangle solution = new Code120Triangle();

//           [
//                [2],
//               [3,4],
//              [6,5,7],
//             [4,1,8,3]
//           ]
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = solution.minimumTotal(triangle);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}
