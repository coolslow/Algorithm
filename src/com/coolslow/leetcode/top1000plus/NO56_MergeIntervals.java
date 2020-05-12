package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *   输入: [[1, 3],[2, 6],[8, 10],[15, 18]]
 *   输出: [[1, 6],[8, 10],[15, 18]]
 *   解释: 区间 [1, 3] 和 [2, 6] 重叠, 将它们合并为 [1, 6].
 *
 * 示例 2:
 *   输入: [[1, 4],[4, 5]]
 *   输出: [[1, 5]]
 *   解释: 区间 [1, 4] 和 [4, 5] 可被视为重叠区间。
 */
public class NO56_MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }

        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

        // 也可以使用 Stack，因为我们只关心结果集的最后一个区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] curInterval = intervals[i];
            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            int[] peek = res.get(res.size() - 1);
            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            } else {
                // 注意，这里应该取最大
                peek[1] = Math.max(curInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 两个区间的合并关系有6中情况，但实际上可以变为三种（只需假设第一个区间的其实位置 <= 第二个区间的其实位置，若不满足条件假设，交换这两个区间即可）
     *               ｜              ｜
     * =========     ｜  =========   ｜  ========
     *    *********  ｜      ***     ｜            ******
     * ————————————————————————————————————————————————————
     *    *********  ｜      ***     ｜            ******
     * =========     ｜  =========   ｜  ========
     *               ｜              ｜
     *
     * @param intervales 给出的区间二维数组
     * @return 返回合并后的区间二维数组
     */
    public static int[][] mergeIntervals(int[][] intervales) {
        // 先按照区间的起始位置进行位置排序
        Arrays.sort(intervales, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervales.length][2];
        int idx = -1;
        for(int[] interval: intervales) {
            if(idx == -1 || interval[0] > res[idx][1]) {
                res[idx] = interval;
                idx++;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }
}
