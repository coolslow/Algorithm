package com.coolslow.leetcode.top1000plus;

/**
 * 540. 有序数组中的单一元素
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 */
public class NO540_SingleElementInSortedArray {

    /**
     * 解法一：暴力法
     * @param nums 给定的数组
     * @return 返回单一元素
     */
    public int singleNonDuplicate(int[] nums) {
        for(int i = 0; i < nums.length - 1; i += 2) {
            if(nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 解法二：二分搜索
     * @param nums 给定的数组
     * @return 返回单一元素
     */
    public int singleNoDuplicateWithDichotomy(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean halvesAreEven = (high - mid) % 2 == 0;
            if(nums[mid + 1] == nums[mid]) {
                if(halvesAreEven) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if(nums[mid - 1] == nums[mid]) {
                if(halvesAreEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            }  else {
                return nums[mid];
            }
        }
        return nums[low];
    }

    /**
     * 解法三：二分搜索（仅对偶数索引进行二分搜索）
     * @param nums 给定的数组
     * @return 返回单一元素
     */
    public int singleNoDuplicateWithDichotomyBetterMethod(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
