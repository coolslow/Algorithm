package com.coolslow.leetcode.top1000plus;

/**
 * 27. 移除元素
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除数组中所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 * 元素的顺序可以改变，你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例1：
 *      给定 nums = [3, 2, 2, 3], val = 3,
 *      函数应该返回新的长度 2，并且 nums 中的前两个元素均为2。
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例2：
 *      给定 nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2,
 *      函数应该返回新的长度 5，并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *      注意这五个元素可以为任意顺序
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 * 思路：
 *      1. 尝试使用两个指针
 *      2. 你是否注意到并且使用了"允许更改数组元素顺序"的提示？
 *      3. 当要删除的元素很少时会发生什么？
 */
public class NO27_RemoveElementFromArray {

    public static int removeElement(int[] nums, int val) {

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
