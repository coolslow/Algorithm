package com.coolslow.leetcode.top1000plus;

import java.util.List;

/**
 * 47. 全排列II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 * ]
 *
 *
 * 回溯搜索 + 剪枝
 *
 * 这一题是在46题的"全排列"基础上增加了附加条件：序列中的元素可重复
 * 但要求返回的结果又不能包含重复元素。因此，对应的解题思路应该在会产生重复结果的地方进行剪枝。
 *
 * - 首先，需要给nums进行排序，这样做的目的是为方便剪枝
 * - 其次，我们已经选择过的不需要再放进去了
 * - 接下来，如果当前节点与它的前一个节点一样，并且它的前一个节点已经被遍历过，那就不再考虑
 *
 */

@Deprecated
public class NO47_PermutationsII {

//    public List<List<Integer>> permuteUniqueII(int nums) {
//
//    }
}
