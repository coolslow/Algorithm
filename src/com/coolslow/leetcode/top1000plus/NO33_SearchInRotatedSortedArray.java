package com.coolslow.leetcode.top1000plus;

/**
 * 33. 搜索螺旋排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * (例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2])。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(logN) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class NO33_SearchInRotatedSortedArray {

    /**
     * 解题思路：题目要求算法的时间复杂度必须是O(logN)级别，这提示我们可以使用二分搜索的方法。
     * 但数组本身并不一定是有序的，进行旋转后只保证了数组的局部有序，但实际上，这样也是可以进行二分搜索的
     */
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        int mid;

        while(start <= end) {
            // 中间的数 (表达式是关键)
            mid = start + (end - start)/2;
            // 处理边界情况，最终都会落到该边界情况，如果没有，就会返回-1
            if(nums[mid] == target) {
                return mid;
            }
            // 前半部分有序，这里需要用小于等于号，逻辑在于，如果nums[start] <= nums[mid] 说明前半部分'整体'有序
            if(nums[start] <= nums[mid]) {
                // target在前半部分,对target进行查找
                if(target >= nums[start] && target < nums[mid]) {
                    // 抛弃后半部分，将end设置为mid - 1
                    end = mid - 1;
                } else {
                    // 抛弃前半部分，将start设置为mid + 1
                    start = mid + 1;
                }
            } else {
                // target在后半部分
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /** 与上面的方法类似，只是部分写法不同，该方法更便于理解 */
    public static int searchII(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;

        while(left <= right) {
            // 取中值
            int mid = (left + right)/2;
            // 如果中值与target相等，返回中值下标
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < nums[right]) {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
