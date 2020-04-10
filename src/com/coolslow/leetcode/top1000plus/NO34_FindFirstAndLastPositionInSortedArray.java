package com.coolslow.leetcode.top1000plus;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 题目描述：
 *      给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *      算法时间复杂度必须是 O(log n) 级别。
 *      如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *      输入: nums = [5, 7, 7, 8, 8, 10], target = 8
 *      输出: [3 ,4]
 *
 * 示例 2:
 *      输入: nums = [5, 7, 7, 8, 8, 10], target = 6
 *      输出: [-1, -1]
 */
public class NO34_FindFirstAndLastPositionInSortedArray {

    /**
     * 方法一：线性扫描
     * 思路：对target检查每一个下标，一定可以得到答案
     *
     * 首先，我们对 nums 数组从左到右做线性遍历，当遇到 target 时中止。
     * 如果我们没有中止过，那么 target 不存在，我们可以返回“错误代码” [-1, -1] 。
     * 如果我们找到了有效的左端点坐标，我们可以坐第二遍线性扫描，但这次从右往左进行。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 给定的数组
     * @param target 给定的目标数
     * @return 返回对应的下标，如果没有返回[-1, -1]
     */
    public static int[] normalSearchRange(int[] nums, int target) {
        // 设置初始的targetRange为[-1, -1]
        int[] targetRange = {-1, -1};

        // 遍历数组，以找到第一个出现的target的下标
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }

        // 如果遍历没有找到对应的target，那么返回[-1, -1]
        if(targetRange[0] == -1) {
            return targetRange;
        }

        // 从数组的后方查找，以找到后一个target
        for(int j = nums.length - 1; j >= 0; j--) {
            if(nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }

        return targetRange;
    }

//    public static int[] binarySearchRange(int[] nums, int target) {
//
//    }
//
//    private static
}
