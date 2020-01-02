package com.coolslow.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ming
 *
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 *
 * 示例1：
 *      给定数组 nums = [1, 1, 2]
 *      函数应该返回新的长度 2， 并且原数组 nums 的前两个元素被修改为 1, 2
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例2：
 *      给定 nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
 *      函数应该返回的长度是 5， 并且愿数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class NO26_RemoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        // 当数组为空时返回数组长度为0
        if(nums.length == 0) return 0;
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            // 当两数不等时，计数器自增，并指定对应下标的数组值
            if(nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }
        // 必须是count + 1, 不能是 count 或 count++
        return count + 1;
    }
}
