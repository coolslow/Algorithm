package com.coolslow.top1000plus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 *  输入: candidates = [2,3,6,7], target = 7,
 *  所求解集为:
 *  [
 *      [7],
 *      [2,2,3]
 *  ]
 *
 * 示例 2:
 *  输入: candidates = [2,3,5], target = 8,
 *  所求解集为:
 *  [
 *      [2,2,2,2],
 *      [2,3,3],
 *      [3,5]
 *  ]
 *
 */
public class NO39_CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> lists = new ArrayList<>();

        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, lists, list);

        return lists;
    }

    private static void process(int start, int[] candidates, int target, List<List<Integer>> lists, List<Integer> list) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                process(i, candidates, target - candidates[i], lists, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
