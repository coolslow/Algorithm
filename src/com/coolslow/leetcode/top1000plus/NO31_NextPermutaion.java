package com.coolslow.leetcode.top1000plus;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 解题思路：
 *   方法一：暴力法
 *   找出由给定数组元素组成的列表的每一个可能的排列，并找出比给定的排列更大的排列
 *   但这种方式要求找出所有可能的排列，实施起来复杂且费时。因此，这种方式理论可行，实际操作无法通过。
 *
 *   复杂度分析：
 *     - 时间复杂度：O(n!)，可能的排列总计有 n! 个。
 *     - 空间复杂度：O(n)，因为数组将用于存储排列。
 *
 *
 *   方法二：一遍扫描
 *   ---------------------------------------------------------------------------------------------------------------
 *   为了满足上述要求，我们需要：
 *   a. 在尽可能靠右的低位进行交换，需要从后向前查找
 *   b. 将一个尽可能小的'大数'与前面的'小数'交换。比如[1, 2, 3, 4, 6, 5]，下一个排列应该把 4 和 5 交换而不是把 4 和 6 交换
 *   c. 将'大数'换到前面后，需要将'大数'后面的所有数重置为升序，升序排列就是最小的紧邻排列。
 *      以[1, 2, 3, 4, 6, 5] 为例：
 *      - 首先按照上面的秒速，将4和5交换，得到[1, 2, 3, 5, 6, 4]
 *      - 然后将5后面的数设置为升序，得到[1, 2, 3, 5, 4, 6]
 *      很明显，[1, 2, 3, 5, 4, 6] 比 [1, 2, 3, 5, 6, 4]更小，因此，[1, 2, 3, 5, 4, 6] 就是[1, 2, 3, 4, 6, 5]的下一个排列
 *
 */
public class NO31_NextPermutaion {

    /**
     * 算法推导：
     *
     * 时间复杂度O(N)，在最坏的情况下，只需要对整个数组进行两次扫描
     * 空间负载度O(1)，没有使用额外的空间，原地替换
     * @param nums 给定的数组
     */
    public static void nextPermutaion(int[] nums) {
        int i = nums.length - 2;
        // 从后向前检查，看数组是否满足后一个数比前一个小的情况
        while(i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if(i >= 0) {
            int j = nums.length - 1;
            while(j >=0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}