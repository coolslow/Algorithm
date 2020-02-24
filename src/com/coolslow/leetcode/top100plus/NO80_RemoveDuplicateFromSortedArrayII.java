package com.coolslow.leetcode.top100plus;

/**
 * 88. 删除排序数组中的重复项 II
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1, 1, 1, 2, 2, 3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 示例 2:
 *
 * 给定 nums = [0, 0, 1, 1, 1, 1, 2, 3, 3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class NO80_RemoveDuplicateFromSortedArrayII {

    /**
     * 解法：覆盖多余的重复项
     *
     * 使用两个指针：i 是用于遍历整个数组的指针，指向当前遍历的元素。j 指向下一个将要覆盖的元素。
     * 用 count 记录当前数字出现的次数，count 的最小计数始终为 1。
     * 我们从索引 1 开始一次处理一个数组元素
     *
     * 若当前元素与前一个元素相同，即 nums[i]==nums[i-1]，则 count++。若 count > 2，则说明遇到了多余的重复项。
     * 在这种情况下，我们只向前移动 i，而 j 不动。
     *
     * 若 count <= 2，则我们将 i 所指向的元素移动到 j 位置，并同时增加 i 和 j。
     *
     * 若当前元素与前一个元素不相同，即 nums[i] != nums[i - 1]，说明遇到了新元素，则我们更新 count = 1，并且将该元素移动到 j 位置，并同时增加 i 和 j。
     * 当数组遍历完成，则返回 j。
     *
     * @param nums 给定的有序数组
     * @return 返回移除重复元素后新数组的长度
     */
    public static int removeDuplicates(int[] nums) {

        // Initialize the counter and the second pointer.
        int j = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if(count <= 2) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
